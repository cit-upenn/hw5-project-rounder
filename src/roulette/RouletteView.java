package roulette;

import java.awt.*;
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
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21,
			b22, b23, b24, b25, b26, b27, b28, b29, b30, b31, b32, b33, b34, b35, b36;
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

		// set button "0"
		subLeft.setLayout(new GridLayout(1, 1));
		b0 = new JButton("0");
		b0.setPreferredSize(new Dimension(70, 30));
		b0.setForeground(Color.white);
		b0.setBackground(FOREST_GREEN);
		b0.setOpaque(true);
		b0.setBorderPainted(true);
		b0.setBorder(WHITE_BORDER);

		// set button "1" to "36"
		subCenter.setLayout(new GridLayout(3, 12));
		b1 = new JButton("1");
		b1.setForeground(Color.white);
		b1.setBackground(Color.red);
		b1.setOpaque(true);
		b1.setBorderPainted(true);
		b1.setBorder(WHITE_BORDER);

		b2 = new JButton("2");
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setOpaque(true);
		b2.setBorderPainted(true);
		b2.setBorder(WHITE_BORDER);

		b3 = new JButton("3");
		b3.setForeground(Color.white);
		b3.setBackground(Color.red);
		b3.setOpaque(true);
		b3.setBorderPainted(true);
		b3.setBorder(WHITE_BORDER);

		b4 = new JButton("4");
		b4.setForeground(Color.white);
		b4.setBackground(Color.black);
		b4.setOpaque(true);
		b4.setBorderPainted(true);
		b4.setBorder(WHITE_BORDER);

		b5 = new JButton("5");
		b5.setForeground(Color.white);
		b5.setBackground(Color.red);
		b5.setOpaque(true);
		b5.setBorderPainted(true);
		b5.setBorder(WHITE_BORDER);

		b6 = new JButton("6");
		b6.setForeground(Color.white);
		b6.setBackground(Color.black);
		b6.setOpaque(true);
		b6.setBorderPainted(true);
		b6.setBorder(WHITE_BORDER);

		b7 = new JButton("7");
		b7.setForeground(Color.white);
		b7.setBackground(Color.red);
		b7.setOpaque(true);
		b7.setBorderPainted(true);
		b7.setBorder(WHITE_BORDER);

		b8 = new JButton("8");
		b8.setForeground(Color.white);
		b8.setBackground(Color.black);
		b8.setOpaque(true);
		b8.setBorderPainted(true);
		b8.setBorder(WHITE_BORDER);

		b9 = new JButton("9");
		b9.setForeground(Color.white);
		b9.setBackground(Color.red);
		b9.setOpaque(true);
		b9.setBorderPainted(true);
		b9.setBorder(WHITE_BORDER);

		b10 = new JButton("10");
		b10.setForeground(Color.white);
		b10.setBackground(Color.black);
		b10.setOpaque(true);
		b10.setBorderPainted(true);
		b10.setBorder(WHITE_BORDER);

		b11 = new JButton("11");
		b11.setForeground(Color.white);
		b11.setBackground(Color.black);
		b11.setOpaque(true);
		b11.setBorderPainted(true);
		b11.setBorder(WHITE_BORDER);

		b12 = new JButton("12");
		b12.setForeground(Color.white);
		b12.setBackground(Color.red);
		b12.setOpaque(true);
		b12.setBorderPainted(true);
		b12.setBorder(WHITE_BORDER);

		b13 = new JButton("13");
		b13.setForeground(Color.white);
		b13.setBackground(Color.black);
		b13.setOpaque(true);
		b13.setBorderPainted(true);
		b13.setBorder(WHITE_BORDER);

		b14 = new JButton("14");
		b14.setForeground(Color.white);
		b14.setBackground(Color.red);
		b14.setOpaque(true);
		b14.setBorderPainted(true);
		b14.setBorder(WHITE_BORDER);

		b15 = new JButton("15");
		b15.setForeground(Color.white);
		b15.setBackground(Color.black);
		b15.setOpaque(true);
		b15.setBorderPainted(true);
		b15.setBorder(WHITE_BORDER);

		b16 = new JButton("16");
		b16.setForeground(Color.white);
		b16.setBackground(Color.red);
		b16.setOpaque(true);
		b16.setBorderPainted(true);
		b16.setBorder(WHITE_BORDER);

		b17 = new JButton("17");
		b17.setForeground(Color.white);
		b17.setBackground(Color.black);
		b17.setOpaque(true);
		b17.setBorderPainted(true);
		b17.setBorder(WHITE_BORDER);

		b18 = new JButton("18");
		b18.setForeground(Color.white);
		b18.setBackground(Color.red);
		b18.setOpaque(true);
		b18.setBorderPainted(true);
		b18.setBorder(WHITE_BORDER);

		b19 = new JButton("19");
		b19.setForeground(Color.white);
		b19.setBackground(Color.red);
		b19.setOpaque(true);
		b19.setBorderPainted(true);
		b19.setBorder(WHITE_BORDER);

		b20 = new JButton("20");
		b20.setForeground(Color.white);
		b20.setBackground(Color.black);
		b20.setOpaque(true);
		b20.setBorderPainted(true);
		b20.setBorder(WHITE_BORDER);

		b21 = new JButton("21");
		b21.setForeground(Color.white);
		b21.setBackground(Color.red);
		b21.setOpaque(true);
		b21.setBorderPainted(true);
		b21.setBorder(WHITE_BORDER);

		b22 = new JButton("22");
		b22.setForeground(Color.white);
		b22.setBackground(Color.black);
		b22.setOpaque(true);
		b22.setBorderPainted(true);
		b22.setBorder(WHITE_BORDER);

		b23 = new JButton("23");
		b23.setForeground(Color.white);
		b23.setBackground(Color.red);
		b23.setOpaque(true);
		b23.setBorderPainted(true);
		b23.setBorder(WHITE_BORDER);

		b24 = new JButton("24");
		b24.setForeground(Color.white);
		b24.setBackground(Color.black);
		b24.setOpaque(true);
		b24.setBorderPainted(true);
		b24.setBorder(WHITE_BORDER);

		b25 = new JButton("25");
		b25.setForeground(Color.white);
		b25.setBackground(Color.red);
		b25.setOpaque(true);
		b25.setBorderPainted(true);
		b25.setBorder(WHITE_BORDER);

		b26 = new JButton("26");
		b26.setForeground(Color.white);
		b26.setBackground(Color.black);
		b26.setOpaque(true);
		b26.setBorderPainted(true);
		b26.setBorder(WHITE_BORDER);

		b27 = new JButton("27");
		b27.setForeground(Color.white);
		b27.setBackground(Color.red);
		b27.setOpaque(true);
		b27.setBorderPainted(true);
		b27.setBorder(WHITE_BORDER);

		b28 = new JButton("28");
		b28.setForeground(Color.white);
		b28.setBackground(Color.black);
		b28.setOpaque(true);
		b28.setBorderPainted(true);
		b28.setBorder(WHITE_BORDER);

		b29 = new JButton("29");
		b29.setForeground(Color.white);
		b29.setBackground(Color.black);
		b29.setOpaque(true);
		b29.setBorderPainted(true);
		b29.setBorder(WHITE_BORDER);

		b30 = new JButton("30");
		b30.setForeground(Color.white);
		b30.setBackground(Color.red);
		b30.setOpaque(true);
		b30.setBorderPainted(true);
		b30.setBorder(WHITE_BORDER);

		b31 = new JButton("31");
		b31.setForeground(Color.white);
		b31.setBackground(Color.black);
		b31.setOpaque(true);
		b31.setBorderPainted(true);
		b31.setBorder(WHITE_BORDER);

		b32 = new JButton("32");
		b32.setForeground(Color.white);
		b32.setBackground(Color.red);
		b32.setOpaque(true);
		b32.setBorderPainted(true);
		b32.setBorder(WHITE_BORDER);

		b33 = new JButton("33");
		b33.setForeground(Color.white);
		b33.setBackground(Color.black);
		b33.setOpaque(true);
		b33.setBorderPainted(true);
		b33.setBorder(WHITE_BORDER);

		b34 = new JButton("34");
		b34.setForeground(Color.white);
		b34.setBackground(Color.red);
		b34.setOpaque(true);
		b34.setBorderPainted(true);
		b34.setBorder(WHITE_BORDER);

		b35 = new JButton("35");
		b35.setForeground(Color.white);
		b35.setBackground(Color.black);
		b35.setOpaque(true);
		b35.setBorderPainted(true);
		b35.setBorder(WHITE_BORDER);

		b36 = new JButton("36");
		b36.setForeground(Color.white);
		b36.setBackground(Color.red);
		b36.setOpaque(true);
		b36.setBorderPainted(true);
		b36.setBorder(WHITE_BORDER);

		// add 1st-3rd column buttons
		subRight.setLayout(new GridLayout(3, 1));
		b1stColumn = new JButton("2 to 1");
		b1stColumn.setPreferredSize(new Dimension(80, 40));
		b1stColumn.setForeground(Color.white);
		b1stColumn.setBackground(FOREST_GREEN);
		b1stColumn.setOpaque(true);
		b1stColumn.setBorderPainted(true);
		b1stColumn.setBorder(WHITE_BORDER);

		b2ndColumn = new JButton("2 to 1");
		b2ndColumn.setPreferredSize(new Dimension(80, 40));
		b2ndColumn.setForeground(Color.white);
		b2ndColumn.setBackground(FOREST_GREEN);
		b2ndColumn.setOpaque(true);
		b2ndColumn.setBorderPainted(true);
		b2ndColumn.setBorder(WHITE_BORDER);

		b3rdColumn = new JButton("2 to 1");
		b3rdColumn.setPreferredSize(new Dimension(80, 40));
		b3rdColumn.setForeground(Color.white);
		b3rdColumn.setBackground(FOREST_GREEN);
		b3rdColumn.setOpaque(true);
		b3rdColumn.setBorderPainted(true);
		b3rdColumn.setBorder(WHITE_BORDER);

		// add 1st-3rd dozen buttons
		subBottom.setLayout(new GridLayout(2, 3));
		b1stDozen = new JButton("1st 12");
		b1stDozen.setForeground(Color.white);
		b1stDozen.setBackground(FOREST_GREEN);
		b1stDozen.setOpaque(true);
		b1stDozen.setBorderPainted(true);
		b1stDozen.setBorder(WHITE_BORDER);

		b2ndDozen = new JButton("2nd 12");
		b2ndDozen = new JButton("1st 12");
		b2ndDozen.setForeground(Color.white);
		b2ndDozen.setBackground(FOREST_GREEN);
		b2ndDozen.setOpaque(true);
		b2ndDozen.setBorderPainted(true);
		b2ndDozen.setBorder(WHITE_BORDER);

		b3rdDozen = new JButton("3rd 12");
		b3rdDozen = new JButton("1st 12");
		b3rdDozen.setForeground(Color.white);
		b3rdDozen.setBackground(FOREST_GREEN);
		b3rdDozen.setOpaque(true);
		b3rdDozen.setBorderPainted(true);
		b3rdDozen.setBorder(WHITE_BORDER);

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

		bEven = new JButton("EVEN");
		bEven.setForeground(Color.white);
		bEven.setBackground(FOREST_GREEN);
		bEven.setOpaque(true);
		bEven.setBorderPainted(true);
		bEven.setBorder(WHITE_BORDER);

		b1stHalf = new JButton("1 to 18");
		b1stHalf.setForeground(Color.white);
		b1stHalf.setBackground(FOREST_GREEN);
		b1stHalf.setOpaque(true);
		b1stHalf.setBorderPainted(true);
		b1stHalf.setBorder(WHITE_BORDER);

		b2ndHalf = new JButton("19 to 36");
		b2ndHalf.setForeground(Color.white);
		b2ndHalf.setBackground(FOREST_GREEN);
		b2ndHalf.setOpaque(true);
		b2ndHalf.setBorderPainted(true);
		b2ndHalf.setBorder(WHITE_BORDER);

		bRed = new JButton("RED");
		bBlack = new JButton("BLACK");
		bRed.setForeground(Color.white);
		bRed.setBackground(Color.red);
		bRed.setOpaque(true);
		bRed.setBorderPainted(true);
		bRed.setBorder(WHITE_BORDER);
		bBlack.setForeground(Color.white);
		bBlack.setBackground(Color.black);
		bBlack.setOpaque(true);
		bBlack.setBorderPainted(true);
		bBlack.setBorder(WHITE_BORDER);

		addButtonToPanel();
	}

	/**
	 * helper method to add all buttons to panels
	 */
	private void addButtonToPanel() {

		// add buttons in certain order
		subLeft.add(b0);

		subCenter.add(b3);
		subCenter.add(b6);
		subCenter.add(b9);
		subCenter.add(b12);
		subCenter.add(b15);
		subCenter.add(b18);
		subCenter.add(b21);
		subCenter.add(b24);
		subCenter.add(b27);
		subCenter.add(b30);
		subCenter.add(b33);
		subCenter.add(b36);
		subCenter.add(b2);
		subCenter.add(b5);
		subCenter.add(b8);
		subCenter.add(b11);
		subCenter.add(b14);
		subCenter.add(b17);
		subCenter.add(b20);
		subCenter.add(b23);
		subCenter.add(b26);
		subCenter.add(b29);
		subCenter.add(b32);
		subCenter.add(b35);
		subCenter.add(b1);
		subCenter.add(b4);
		subCenter.add(b7);
		subCenter.add(b10);
		subCenter.add(b13);
		subCenter.add(b16);
		subCenter.add(b19);
		subCenter.add(b22);
		subCenter.add(b25);
		subCenter.add(b28);
		subCenter.add(b31);
		subCenter.add(b34);

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
		// TODO
	}

	/**
	 * test the class
	 */
	public static void main(String[] args) {
		RouletteView rv = new RouletteView();
	}

}
