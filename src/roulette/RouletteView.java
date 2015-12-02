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
		buttons = new JButton[49];

		// set up every button color and font
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonIndexToString(i));
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

		// set layout for button "1" to "36"
		subCenter.setLayout(new GridLayout(3, 12));
		
		// set button 1 to 10
		for (int i = 1; i <= 10; i++) {

			if (i % 2 == 1) {
				buttons[i].setBackground(Color.red);
			} else {

				buttons[i].setBackground(Color.black);
			}

		}
		
		// set button 11 to 18
		for (int i = 11; i <= 18; i++) {

			if (i % 2 == 0) {
				buttons[i].setBackground(Color.red);
			} else {

				buttons[i].setBackground(Color.black);
			}

		}

		// set button 19 to 28
		for (int i = 19; i <= 28; i++) {

			if (i % 2 == 1) {
				buttons[i].setBackground(Color.red);
			} else {

				buttons[i].setBackground(Color.black);
			}

		}

		// set button 29 to 36
		for (int i = 29; i <= 36; i++) {

			if (i % 2 == 0) {
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
		for (int i = 37; i <= 39; i++) {
			buttons[i].setPreferredSize(new Dimension(80, 40));
			buttons[i].setBackground(FOREST_GREEN);
		}

		// add 1st-3rd dozen buttons
		subBottom.setLayout(new GridLayout(2, 3));
		subBottom.setPreferredSize(new Dimension(1200, 80));
		// for(int i = 40; i <=42;i++){
		// buttons[i].setBackground(FOREST_GREEN);
		// }

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

		for (int i = 40; i <= 48; i++) {
			if (i != 45 && i != 46) {
				buttons[i].setBackground(FOREST_GREEN);
			}

		}

		buttons[45].setBackground(Color.red);

		buttons[46].setBackground(Color.black);

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

		for (int i = 39; i >= 37; i--) {
			subRight.add(buttons[i]);
		}

		for (int i = 40; i <= 42; i++) {
			subBottom.add(buttons[i]);
		}

		subBottom.add(subBottom1);
		subBottom.add(subBottom2);
		subBottom.add(subBottom3);

		subBottom1.add(buttons[43]);
		subBottom1.add(buttons[44]);
		subBottom2.add(buttons[45]);
		subBottom2.add(buttons[46]);
		subBottom3.add(buttons[47]);
		subBottom3.add(buttons[48]);
	}

	/**
	 * Transfer button index to string
	 * 
	 * @param index
	 * @return
	 */
	private String buttonIndexToString(int index) {
		switch (index) {
			case 37:
				return "2 to 1";// 1stRow(bottom 1st)
			case 38:
				return "2 to 1";// 2ndRow
			case 39:
				return "2 to 1";// 3rdRow
			case 40:
				return "1st 12";
			case 41:
				return "2nd 12";
			case 42:
				return "3rd 12";
			case 43:
				return "1 - 18";
			case 44:
				return "EVEN";
			case 45:
				return "RED";
			case 46:
				return "BLACK";
			case 47:
				return "ODD";
			case 48:
				return "19 - 36";
			default:
				return "" + index;
			}
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
		 * 
		 * @param i
		 *            button number
		 */
		public ButtonEvent(int i) {
			this.i = i;
			clicked = 0;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String text = "";
			
			clicked++;
			if (i < 37) {
				text += i + "\n" + "[$" + clicked + "]";
			} else {
				text += buttonIndexToString(i) + " [$" + clicked + "]";
			}
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
