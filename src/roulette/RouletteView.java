package roulette;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import lobby.*;

/**
 * This class will show a roulette table for the player to play
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 *
 */
public class RouletteView extends JFrame {

	/**
	 * serial ID
	 */
	private static final long serialVersionUID = 1227969985674089474L;

	/**
	 * roulette: represents a roulette game
	 */
	private Roulette roulette;

	/** 
	 * GUI variables
	 */
	private JPanel top, left, right, bottom, center;
	private JPanel subTop, subLeft, subRight, subBottom, subCenter;
	private JPanel subBottom1, subBottom2, subBottom3;
	private JButton[] buttons;
	private JButton spin, back, rule;
	private JLabel rouletteImage;
	private static final Border WHITE_BORDER = new LineBorder(Color.WHITE, 2);
	private static final Color DARK_GREEN = new Color(0, 100, 0);
	private static final Color FOREST_GREEN = new Color(34, 139, 34);
	private static final Color ROYAL_BLUE = new Color(65, 105, 225);

	/**
	 * store results
	 */
	private int[] userBets;
	private int finalPayout;

	/**
	 * constructor
	 */
	public RouletteView() {
		roulette = new Roulette();
		finalPayout = 0;

		// initialize results, all equal to 0
		userBets = new int[49];
		for (int i = 0; i < userBets.length; i++) {
			userBets[i] = 0;
		}

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
		setLocation();
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * set the location of roulette window
	 */
	private void setLocation() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() / 2 - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() / 2 - this.getHeight()) / 2);
		setLocation(x, y);
	}

	/**
	 * helper method to set the layout
	 */
	private void layOutComponents() {
		setLayout(new BorderLayout());
		addPanels();
		addSubPanels();
		addButtons();
		addImage();
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

		// add them to the frame
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

		bottom.setLayout(new GridLayout(1, 3));
		bottom.setBackground(ROYAL_BLUE);

		// add "Spin" button
		rule = new JButton("Rule");
		bottom.add(rule);
		setButton(rule);
		spin = new JButton("Spin");
		spin.setName("Spin");
		setButton(spin);
		bottom.add(spin);
		back = new JButton("Back");
		setButton(back);
		bottom.add(back);
	}

	/**
	 * set button attributes
	 * 
	 * @param button the button to be set
	 */
	private void setButton(JButton button) {
		button.setForeground(Color.white);
		button.setBackground(ROYAL_BLUE);
		button.setOpaque(true);
		button.setBorderPainted(true);
		button.setBorder(WHITE_BORDER);
		button.setFont(new Font("Arial", Font.PLAIN, 25));

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

		// add 1st - 3rd column buttons
		subRight.setLayout(new GridLayout(3, 1));
		for (int i = 37; i <= 39; i++) {
			buttons[i].setPreferredSize(new Dimension(80, 40));
			buttons[i].setBackground(FOREST_GREEN);
		}

		// add 1st - 3rd dozen buttons
		subBottom.setLayout(new GridLayout(2, 3));
		subBottom.setPreferredSize(new Dimension(1200, 80));

		// add sub-bottom buttons
		// 1 - 18 / 19 - 36, RED / BLACK, ODD / EVEN
		subBottom1 = new JPanel();
		subBottom2 = new JPanel();
		subBottom3 = new JPanel();

		subBottom1.setBackground(DARK_GREEN);
		subBottom2.setBackground(DARK_GREEN);
		subBottom3.setBackground(DARK_GREEN);

		subBottom1.setLayout(new GridLayout(1, 2));
		subBottom2.setLayout(new GridLayout(1, 2));
		subBottom3.setLayout(new GridLayout(1, 2));

		// set background color for bottom sections
		for (int i = 40; i <= 48; i++) {
			if (i != 45 && i != 46) {
				buttons[i].setBackground(FOREST_GREEN);
			}
		}

		// set background color for RED and BLACK
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
	 * helper method to add image to the view
	 */
	private void addImage() {

		// adjust image size and add to view
		ImageIcon image = new ImageIcon(getClass().getResource("static-wheel.jpg"));
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(360, 360, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newImage = new ImageIcon(newImg);
		rouletteImage = new JLabel(newImage);
		left.add(rouletteImage);
	}

	/**
	 * Transfer button index to string
	 * 
	 * @param index array index
	 * @return corresponding bet
	 */
	private String buttonIndexToString(int index) {
		switch (index) {
		case 37:
			return "2 to 1"; // 1st Row (bottom 1st)
		case 38:
			return "2 to 1"; // 2nd Row
		case 39:
			return "2 to 1"; // 3rd Row
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

		// add listeners for each button
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(new ButtonEvent(i));
		}

		// add listener to spin, back, rule
		spin.addActionListener(new SpinEvent());
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Game.lobby.setVisible(true);
			}

		});

		rule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(), "Roulette Rules\n"
						+ "1. You can bet any combinations\n"
						+ "2. The wheel will then spin a lucky number\n"
						+ "3. You will get paid according to your hits\n");
			}

		});
		
	}

	/**
	 * inner class for button click event
	 */
	private class ButtonEvent implements ActionListener {

		// instance variables
		private int i;

		/**
		 * constructor
		 * 
		 * @param i
		 *            button number
		 */
		public ButtonEvent(int i) {
			this.i = i;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String text = "";
			userBets[i]++;

			if (i < 37) {
				text += i + "\n" + "[$" + userBets[i] + "]";
			} else {
				text += buttonIndexToString(i) + " [$" + userBets[i] + "]";
			}

			buttons[i].setText("<html>" + text.replaceAll("\\n", "<br>") + "</html>");
		}

	}

	/**
	 * inner class for spinning the roulette
	 */
	private class SpinEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			changeImage();
			roulette.spin();
			finalPayout = roulette.getPayout(userBets);
			JOptionPane.showMessageDialog(getParent(),
					"The number is " + roulette.getRoundNumber().getNum() + "\n" + "You bet $" + getTotalBets() + "\n"
							+ "You get $" + finalPayout + "\n" + "You earn $" + (finalPayout - getTotalBets()));
			clearUserBets();
			restoreImage();
		}

	}

	/**
	 * helper method to change displayed image when roulette spins
	 */
	private void changeImage() {

		// adjust image size and add to view
		ImageIcon image = new ImageIcon(getClass().getResource("spin-wheel.jpg"));
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(360, 360, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newImage = new ImageIcon(newImg);
		rouletteImage.setIcon(newImage);
	}

	/**
	 * helper method to change displayed image when roulette stops spinning
	 */
	private void restoreImage() {

		// adjust image size and add to view
		ImageIcon image = new ImageIcon(getClass().getResource("static-wheel.jpg"));
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(360, 360, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newImage = new ImageIcon(newImg);
		rouletteImage.setIcon(newImage);
	}

	/**
	 * helper method to clear all previous user bets
	 */
	private void clearUserBets() {

		// clear userBets array and roulette table
		for (int i = 0; i < userBets.length; i++) {
			userBets[i] = 0;
			buttons[i].setText(buttonIndexToString(i));
		}
	}

	/**
	 * return total bets from the user
	 * 
	 * @return total bets
	 */
	public int getTotalBets() {
		int totalBets = 0;

		// calculates total bets
		for (int i = 0; i < userBets.length; i++) {
			totalBets += userBets[i];
		}

		return totalBets;
	}

}
