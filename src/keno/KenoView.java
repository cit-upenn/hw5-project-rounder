package keno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import lobby.*;

/**
 * This class represents a keno lottery ticket
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 *
 */
public class KenoView extends JFrame {

	private static final long serialVersionUID = 7261847457620625993L;

	// instance variables
	private Keno keno;
	private boolean[] picked;

	// GUI variables
	private JPanel top, left, right, bottom, center;
	private JButton[] buttons;
	private JButton draw, back, rule;

	// some constants
	private static final Border WHITE_BORDER = new LineBorder(Color.WHITE, 2);
	private static final Color ROYAL_BLUE = new Color(65, 105, 225);
	private static final Color DARK_GREY = new Color(169, 169, 169);

	// store results
	private HashSet<Integer> userBets;
	private int finalPayout;

	/**
	 * constructor
	 */
	public KenoView() {
		keno = new Keno();
		userBets = new HashSet<Integer>();
		finalPayout = 0;
		picked = new boolean[80];

		// set each number as unpicked
		for (int i = 0; i < picked.length; i++) {
			picked[i] = false;
		}

		display();
	}

	/**
	 * helper method to construct the keno ticket
	 */
	private void display() {
		setTitle("Keno");
		layOutComponents();
		attachListenersToComponents();
		setPreferredSize(new Dimension(1200, 400));
		setLocation();
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * set the location of keno window
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
		addMenu();
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
		left.setBackground(DARK_GREY);
		add(center, BorderLayout.CENTER);
		center.setBackground(DARK_GREY);
		add(right, BorderLayout.EAST);
		add(bottom, BorderLayout.SOUTH);
		bottom.setBackground(DARK_GREY);

	}

	/**
	 * helper method to add sub-panels within the bottom panel
	 */
	private void addSubPanels() {

		bottom.setLayout(new GridLayout(1, 3));

		// add bottom buttons
		rule = new JButton("Rule");
		bottom.add(rule);
		setButton(rule);
		draw = new JButton("Draw");
		setButton(draw);
		bottom.add(draw);
		back = new JButton("Back");
		setButton(back);
		bottom.add(back);

	}

	/**
	 * helper method to set bottom buttons' attributes
	 * 
	 * @param button
	 *            to be set
	 */
	private void setButton(JButton button) {
		button.setForeground(Color.white);
		button.setBackground(DARK_GREY);
		button.setOpaque(true);
		button.setBorderPainted(true);
		button.setBorder(WHITE_BORDER);
		button.setFont(new Font("Arial", Font.PLAIN, 25));

	}

	/**
	 * helper method to add buttons(number 1-80)
	 */
	private void addButtons() {

		// initializing
		buttons = new JButton[80];

		// set layout for button "1" to "80"
		center.setLayout(new GridLayout(8, 10));

		// set up every button color and font
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("" + (i + 1));
			buttons[i].setForeground(Color.white);
			buttons[i].setBackground(ROYAL_BLUE);
			buttons[i].setOpaque(true);
			buttons[i].setBorderPainted(true);
			buttons[i].setBorder(WHITE_BORDER);
			buttons[i].setFont(new Font("Arial", Font.PLAIN, 25));
			center.add(buttons[i]);
		}

	}

	/**
	 * helper method to add menu
	 */
	private void addMenu() {
		JLabel blue = new JLabel("Unpicked");
		JLabel red = new JLabel("Picked");
		JLabel magenta = new JLabel("Hit");
		JLabel orange = new JLabel("Result");

		blue.setHorizontalAlignment(SwingConstants.CENTER);
		red.setHorizontalAlignment(SwingConstants.CENTER);
		magenta.setHorizontalAlignment(SwingConstants.CENTER);
		orange.setHorizontalAlignment(SwingConstants.CENTER);

		blue.setForeground(ROYAL_BLUE);
		red.setForeground(Color.red);
		magenta.setForeground(Color.magenta);
		orange.setForeground(Color.orange);

		blue.setFont(new Font("Arial", Font.PLAIN, 20));
		red.setFont(new Font("Arial", Font.PLAIN, 20));
		magenta.setFont(new Font("Arial", Font.PLAIN, 20));
		orange.setFont(new Font("Arial", Font.PLAIN, 20));

		left.setLayout(new GridLayout(10, 1));
		left.add(blue);
		left.add(red);
		left.add(magenta);
		left.add(orange);
	}

	/**
	 * attach action listeners to buttons
	 */
	private void attachListenersToComponents() {

		// add listeners for each button
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(new ButtonEvent(i));
		}

		draw.addActionListener(new DrawEvent());
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
				JOptionPane.showMessageDialog(getParent(), "Keno Rules\n" + "1. You can pick 1-10 numbers\n"
						+ "2. 20 lucky numbers will be drawn\n" + "3. You will be paid according to numbers hit\n");
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
			picked[i] = !picked[i];

			// change color when click and unclick
			if (picked[i]) {
				// only allow up to 10 picks
				if (userBets.size() < 10) {
					buttons[i].setBackground(Color.red);
					userBets.add(i + 1);
				}
			} else {
				buttons[i].setBackground(ROYAL_BLUE);
				userBets.remove(i + 1);
			}

		}

	}

	/**
	 * inner class for drawing lucky numbers
	 */
	private class DrawEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			keno.drawLuckyNumbers();
			finalPayout = keno.payout(userBets);
			showLuckyNumbers();
			JOptionPane.showMessageDialog(getParent(), "You hit " + keno.numOfHits(userBets) + " out of "
					+ userBets.size() + "\n" + "You get $" + finalPayout);
			clearUserPicks();
		}

	}

	/**
	 * helper method to reveal all drawn lucky numbers
	 */
	private void showLuckyNumbers() {

		// set background color
		for (Integer num : keno.getLuckyNumbers()) {
			if (userBets.contains(num)) {
				buttons[num - 1].setBackground(Color.magenta);
			} else {
				buttons[num - 1].setBackground(Color.orange);
			}
		}

		// set every grid unpicked
		for (int i = 0; i < picked.length; i++) {
			picked[i] = false;
		}

	}

	/**
	 * helper method to clear all previous user picks
	 */
	private void clearUserPicks() {

		// clear user picks
		userBets.clear();
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setBackground(ROYAL_BLUE);
		}

	}

}
