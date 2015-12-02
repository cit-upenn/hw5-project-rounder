package roulette;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

/**
 * This class will show a roulette table for the player to play
 * 
 * @author zhiyuanli
 *
 */
public class RouletteView extends JFrame {

	// instance variables
	private Roulette roulette;

	// GUI variables
	private JPanel top, left, right, bottom, center;
	private JPanel subTop, subLeft, subRight, subBottom, subCenter;
	private JPanel subBottom1, subBottom2, subBottom3;
	private JButton[] buttons;
	private JButton b1stColumn, b2ndColumn, b3rdColumn, b1stDozen, b2ndDozen, b3rdDozen, b1stHalf, b2ndHalf, bOdd,
			bEven, bRed, bBlack;
	private static final Border WHITE_BORDER = new LineBorder(Color.WHITE, 2);
	private static final Color DARK_GREEN = new Color(0, 100, 0);
	private static final Color FOREST_GREEN = new Color(34, 139, 34);

	/**
	 * constructor
	 */
	public RouletteView() {
		roulette = new Roulette();
		display();

	}

	/**
	 * helper method to construct the roulette table
	 */
	private void display() {
		setTitle("Roulette");
		layOutComponents();
		attachListenersToComponents();
		setPreferredSize(new Dimension(1200, 400));
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * helper method to set the layout
	 */
	private void layOutComponents() {
		setLayout(new BorderLayout());
		addPanels();
		addSubPanels();
		addButtons();
	}

	/**
	 * helper method to add 5 panels
	 */
	private void addPanels() {
		top = new JPanel();
		left = new JPanel();
		center = new JPanel();
		right = new JPanel();
		bottom = new JPanel();

		add(top, BorderLayout.NORTH);
		add(left, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(right, BorderLayout.EAST);
		add(bottom, BorderLayout.SOUTH);
	}

	/**
	 * helper method to add 5 sub-panels within the center panel
	 */
	private void addSubPanels() {
		center.setLayout(new BorderLayout());

		subTop = new JPanel();
		subLeft = new JPanel();
		subCenter = new JPanel();
		subRight = new JPanel();
		subBottom = new JPanel();

		// set background color
		subTop.setBackground(DARK_GREEN);
		subLeft.setBackground(DARK_GREEN);
		subCenter.setBackground(DARK_GREEN);
		subRight.setBackground(DARK_GREEN);
		subBottom.setBackground(DARK_GREEN);

		// add to center panel
		center.add(subTop, BorderLayout.NORTH);
		center.add(subLeft, BorderLayout.WEST);
		center.add(subCenter, BorderLayout.CENTER);
		center.add(subRight, BorderLayout.EAST);
		center.add(subBottom, BorderLayout.SOUTH);
	}

	/**
	 * helper method to add buttons
	 */
	private void addButtons() {

		// initializing
		buttons = new JButton[37];
		
		// set up every button color and font
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("" + i);
			buttons[i].setForeground(Color.white);
			buttons[i].setOpaque(true);
			buttons[i].setBorderPainted(true);
			buttons[i].setBorder(WHITE_BORDER);
			buttons[i].setFont(new Font("Arial", Font.PLAIN, 25));
		}

		// set button "0"
		subLeft.setLayout(new GridLayout(1, 1));
		buttons[0].setPreferredSize(new Dimension(70, 30));
		buttons[0].setBackground(FOREST_GREEN);

		// set button "1" to "36"
		subCenter.setLayout(new GridLayout(3, 12));
		// set button 1 to 10
		for (int i = 1; i <= 10; i++) {

			if (i % 2 == 1) {
				buttons[i].setBackground(Color.red);
			} else {

				buttons[i].setBackground(Color.black);
			}

		}

		for (int i = 11; i <= 18; i++) {

			if (i % 2 == 0) {
				buttons[i].setBackground(Color.red);
			} else {

				buttons[i].setBackground(Color.black);
			}

		}

		for (int i = 19; i <= 28; i++) {

			if (i % 2 == 1) {
				buttons[i].setBackground(Color.red);
			} else {

				buttons[i].setBackground(Color.black);
			}

		}

		for (int i = 29; i <= 36; i++) {

			if (i % 2 == 0) {
				buttons[i].setBackground(Color.red);
			} else {

				buttons[i].setBackground(Color.black);
			}
			
		}

		// add 1st-3rd column buttons
		subRight.setLayout(new GridLayout(3, 1));
		b1stColumn = new JButton("2 to 1");
		b1stColumn.setPreferredSize(new Dimension(80, 40));
		b1stColumn.setForeground(Color.white);
		b1stColumn.setBackground(FOREST_GREEN);
		b1stColumn.setOpaque(true);
		b1stColumn.setBorderPainted(true);
		b1stColumn.setBorder(WHITE_BORDER);
		b1stColumn.setFont(new Font("Arial", Font.PLAIN, 25));
		
		b2ndColumn = new JButton("2 to 1");
		b2ndColumn.setPreferredSize(new Dimension(80, 40));
		b2ndColumn.setForeground(Color.white);
		b2ndColumn.setBackground(FOREST_GREEN);
		b2ndColumn.setOpaque(true);
		b2ndColumn.setBorderPainted(true);
		b2ndColumn.setBorder(WHITE_BORDER);
		b2ndColumn.setFont(new Font("Arial", Font.PLAIN, 25));
		
		b3rdColumn = new JButton("2 to 1");
		b3rdColumn.setPreferredSize(new Dimension(80, 40));
		b3rdColumn.setForeground(Color.white);
		b3rdColumn.setBackground(FOREST_GREEN);
		b3rdColumn.setOpaque(true);
		b3rdColumn.setBorderPainted(true);
		b3rdColumn.setBorder(WHITE_BORDER);
		b3rdColumn.setFont(new Font("Arial", Font.PLAIN, 25));

		// add 1st-3rd dozen buttons
		subBottom.setLayout(new GridLayout(2, 3));
		subBottom.setPreferredSize(new Dimension(1200, 80));
		b1stDozen = new JButton("1st 12");
		b1stDozen.setForeground(Color.white);
		b1stDozen.setBackground(FOREST_GREEN);
		b1stDozen.setOpaque(true);
		b1stDozen.setBorderPainted(true);
		b1stDozen.setBorder(WHITE_BORDER);
		b1stDozen.setFont(new Font("Arial", Font.PLAIN, 25));
		
		b2ndDozen = new JButton("2nd 12");
		b2ndDozen.setForeground(Color.white);
		b2ndDozen.setBackground(FOREST_GREEN);
		b2ndDozen.setOpaque(true);
		b2ndDozen.setBorderPainted(true);
		b2ndDozen.setBorder(WHITE_BORDER);
		b2ndDozen.setFont(new Font("Arial", Font.PLAIN, 25));
		
		b3rdDozen = new JButton("3rd 12");
		b3rdDozen.setForeground(Color.white);
		b3rdDozen.setBackground(FOREST_GREEN);
		b3rdDozen.setOpaque(true);
		b3rdDozen.setBorderPainted(true);
		b3rdDozen.setBorder(WHITE_BORDER);
		b3rdDozen.setFont(new Font("Arial", Font.PLAIN, 25));
		
		// add sub-bottom buttons
		// 1-18/19-36, RED/BLACK, ODD/EVEN
		subBottom1 = new JPanel();
		subBottom2 = new JPanel();
		subBottom3 = new JPanel();

		subBottom1.setBackground(DARK_GREEN);
		subBottom2.setBackground(DARK_GREEN);
		subBottom3.setBackground(DARK_GREEN);

		subBottom1.setLayout(new GridLayout(1, 2));
		subBottom2.setLayout(new GridLayout(1, 2));
		subBottom3.setLayout(new GridLayout(1, 2));

		bOdd = new JButton("ODD");
		// bOdd.setPreferredSize(new Dimension(40, 20));
		bOdd.setForeground(Color.white);
		bOdd.setBackground(FOREST_GREEN);
		bOdd.setOpaque(true);
		bOdd.setBorderPainted(true);
		bOdd.setBorder(WHITE_BORDER);
		bOdd.setFont(new Font("Arial", Font.PLAIN, 25));

		bEven = new JButton("EVEN");
		bEven.setForeground(Color.white);
		bEven.setBackground(FOREST_GREEN);
		bEven.setOpaque(true);
		bEven.setBorderPainted(true);
		bEven.setBorder(WHITE_BORDER);
		bEven.setFont(new Font("Arial", Font.PLAIN, 25));
		
		b1stHalf = new JButton("1 to 18");
		b1stHalf.setForeground(Color.white);
		b1stHalf.setBackground(FOREST_GREEN);
		b1stHalf.setOpaque(true);
		b1stHalf.setBorderPainted(true);
		b1stHalf.setBorder(WHITE_BORDER);
		b1stHalf.setFont(new Font("Arial", Font.PLAIN, 25));
		
		b2ndHalf = new JButton("19 to 36");
		b2ndHalf.setForeground(Color.white);
		b2ndHalf.setBackground(FOREST_GREEN);
		b2ndHalf.setOpaque(true);
		b2ndHalf.setBorderPainted(true);
		b2ndHalf.setBorder(WHITE_BORDER);
		b2ndHalf.setFont(new Font("Arial", Font.PLAIN, 25));
		
		bRed = new JButton("RED");
		bBlack = new JButton("BLACK");
		
		bRed.setForeground(Color.white);
		bRed.setBackground(Color.red);
		bRed.setOpaque(true);
		bRed.setBorderPainted(true);
		bRed.setBorder(WHITE_BORDER);
		bRed.setFont(new Font("Arial", Font.PLAIN, 25));
		
		bBlack.setForeground(Color.white);
		bBlack.setBackground(Color.black);
		bBlack.setOpaque(true);
		bBlack.setBorderPainted(true);
		bBlack.setBorder(WHITE_BORDER);
		bBlack.setFont(new Font("Arial", Font.PLAIN, 25));
		
		addButtonToPanel();
	}

	/**
	 * helper method to add all buttons to panels
	 */
	private void addButtonToPanel() {

		// add buttons in certain order
		subLeft.add(buttons[0]);

		subCenter.add(buttons[3]);
		subCenter.add(buttons[6]);
		subCenter.add(buttons[9]);
		subCenter.add(buttons[12]);
		subCenter.add(buttons[15]);
		subCenter.add(buttons[18]);
		subCenter.add(buttons[21]);
		subCenter.add(buttons[24]);
		subCenter.add(buttons[27]);
		subCenter.add(buttons[30]);
		subCenter.add(buttons[33]);
		subCenter.add(buttons[36]);
		subCenter.add(buttons[2]);
		subCenter.add(buttons[5]);
		subCenter.add(buttons[8]);
		subCenter.add(buttons[11]);
		subCenter.add(buttons[14]);
		subCenter.add(buttons[17]);
		subCenter.add(buttons[20]);
		subCenter.add(buttons[23]);
		subCenter.add(buttons[26]);
		subCenter.add(buttons[29]);
		subCenter.add(buttons[32]);
		subCenter.add(buttons[35]);
		subCenter.add(buttons[1]);
		subCenter.add(buttons[4]);
		subCenter.add(buttons[7]);
		subCenter.add(buttons[10]);
		subCenter.add(buttons[13]);
		subCenter.add(buttons[16]);
		subCenter.add(buttons[19]);
		subCenter.add(buttons[22]);
		subCenter.add(buttons[25]);
		subCenter.add(buttons[28]);
		subCenter.add(buttons[31]);
		subCenter.add(buttons[34]);

		subRight.add(b3rdColumn);
		subRight.add(b2ndColumn);
		subRight.add(b1stColumn);

		subBottom.add(b1stDozen);
		subBottom.add(b2ndDozen);
		subBottom.add(b3rdDozen);

		subBottom.add(subBottom1);
		subBottom.add(subBottom2);
		subBottom.add(subBottom3);

		subBottom1.add(b1stHalf);
		subBottom1.add(bEven);
		subBottom2.add(bRed);
		subBottom2.add(bBlack);
		subBottom3.add(bOdd);
		subBottom3.add(b2ndHalf);
	}

	/**
	 * attach action listeners to buttons
	 */
	private void attachListenersToComponents() {
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(new ButtonEvent(i));
		}
		
	}
	
	/**
	 * inner class for single number betting
	 */
	private class ButtonEvent implements ActionListener {
		
		// instance variables
		private int i;
		private int clicked;
		
		/**
		 * constructor
		 * @param i button number
		 */
		public ButtonEvent(int i) {
			this.i = i;
			clicked = 0;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = "" + i + "\n" + "[$" + clicked + "]";
			clicked++;
			buttons[i].setText("<html>" + text.replaceAll("\\n", "<br>") + "</html>");
		}
		
	}

	/**
	 * test the class
	 */
	public static void main(String[] args) {
		RouletteView rv = new RouletteView();
	}

}
