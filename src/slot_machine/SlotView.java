package slot_machine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import lobby.*;

/**
 * This class will show the GUI view for the slot game with animation
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 *
 */
public class SlotView extends JFrame {

	private static final long serialVersionUID = 3448807048334175081L;

	// instance variables
	private Slot slot;
	private int finalPayout;

	// GUI variables
	private JPanel top, left, right, bottom, center;
	private JPanel subLeft, subCenter, subRight;
	private JButton spin, back, rules;
	private JLabel[] reels;
	private ArrayList<ImageIcon> images;
	private Timer[] timer, spinner;

	// constant
	private static final Border WHITE_BORDER = new LineBorder(Color.WHITE, 2);

	/**
	 * constructor
	 */
	public SlotView() {
		slot = new Slot(3);
		images = new ArrayList<ImageIcon>();
		reels = new JLabel[3];
		timer = new Timer[3];
		spinner = new Timer[3];
		finalPayout = 0;

		display();
	}

	/**
	 * helper method to construct the slot view
	 */
	private void display() {
		setTitle("Slot");
		layOutComponents();
		attachListenersToComponents();
		setPreferredSize(new Dimension(1000, 600));
		setLocation();
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * set the location of window
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

		add(top, BorderLayout.NORTH);

		// add an image to top
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("slot-machine.jpg"));
		Image imageImage = imageIcon.getImage().getScaledInstance(1000, 200, java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(imageImage);
		top.add(new JLabel(image));

		add(left, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(right, BorderLayout.EAST);
		add(bottom, BorderLayout.SOUTH);
		addSubPanels();
	}

	/**
	 * helper method to add 5 sub-panels within the center panel
	 */
	private void addSubPanels() {

		// add 3 sub panels in center
		center.setLayout(new GridLayout(1, 3));
		subLeft = new JPanel();
		subLeft.setPreferredSize(new Dimension(300, 300));
		subLeft.setBackground(Color.BLACK);
		subCenter = new JPanel();
		subCenter.setPreferredSize(new Dimension(300, 300));
		subCenter.setBackground(Color.BLACK);
		subRight = new JPanel();
		subRight.setBackground(Color.BLACK);
		subRight.setPreferredSize(new Dimension(300, 300));

		center.add(subLeft);
		center.add(subCenter);
		center.add(subRight);

		bottom.setLayout(new GridLayout(1, 3));
		bottom.setBackground(Color.BLACK);

		// add bottom buttons
		rules = new JButton("Rule");
		rules.setName("Rule");
		bottom.add(rules);
		setButton(rules);
		spin = new JButton("Spin");
		spin.setName("Spin");
		setButton(spin);
		bottom.add(spin);
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
		button.setBackground(Color.BLACK);
		button.setOpaque(true);
		button.setBorderPainted(true);
		button.setBorder(WHITE_BORDER);
		button.setFont(new Font("Arial", Font.PLAIN, 25));

	}

	/**
	 * helper method to load image
	 */
	private ImageIcon loadImage(String imageName) {

		// adjust image size and add to view
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageName));
		Image imageImage = imageIcon.getImage().getScaledInstance(280, 280, java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(imageImage);
		return image;
	}

	/**
	 * helper method to transfer symbol to image name
	 * 
	 * @param order
	 *            order of symbol
	 * @return image name image name to be loaded
	 */
	private String orderToImageName(int order) {
		switch (order) {
		case 0:
			return "bar.jpg";
		case 1:
			return "bell.jpg";
		case 2:
			return "cherry.jpg";
		case 3:
			return "grape.jpg";
		case 4:
			return "lemon.jpg";
		case 5:
			return "seven.jpg";
		case 6:
			return "watermelon.jpg";
		default:
			return "" + order;
		}
	}

	/**
	 * helper method to add image
	 */
	private void addImage() {

		// initialize center with 3 question marks(unkown.jpg0
		reels[0] = new JLabel(loadImage("unkown.jpg"));
		reels[1] = new JLabel(loadImage("unkown.jpg"));
		reels[2] = new JLabel(loadImage("unkown.jpg"));

		subLeft.add(reels[0]);
		subCenter.add(reels[1]);
		subRight.add(reels[2]);

		// load 7 symbols' image to the arraylist
		for (int i = 0; i < SlotSymbol.values().length; i++) {
			images.add(loadImage(orderToImageName(SlotSymbol.values()[i].getOrder())));
		}

	}

	/**
	 * attach action listeners to buttons
	 */
	private void attachListenersToComponents() {

		// add listener to each button
		rules.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(getParent(),
						"Slot Rules\n1. Press \"spin\" to play(as you insert $1 in this slot) \n2. 2 symbols in common, you get $3\n3. 3 symbols in common, you get $10\n Good luck! ");

			}
		});

		spin.addActionListener(new SpinEvent());

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Game.lobby.setVisible(true);
			}

		});

	}

	/**
	 * inner class for spinning
	 */
	private class SpinEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// after clicking "spin", set it unclickable for a while
			spin.setEnabled(false);

			// generate 3 random symbols
			slot.spin();
			finalPayout = slot.getPayout(1);

			// get each symbol order of the result
			int symbol0 = slot.getSymbols()[0].getOrder();
			int symbol1 = slot.getSymbols()[1].getOrder();
			int symbol2 = slot.getSymbols()[2].getOrder();

			// set spining time for each reel based on the symbols
			// reel1 stops first, then reel2, reel3 stops in the end
			timer[0] = new Timer((symbol0 + 7) * 100, new TimerEvent(0));
			timer[0].start();

			timer[1] = new Timer((symbol1 + 7 + 7) * 120, new TimerEvent(1));
			timer[1].start();

			timer[2] = new Timer((symbol2 + 7 + 7 + 7) * 140, new TimerEvent(2));
			timer[2].start();

			// set image switching time for each reel
			spinner[0] = new Timer(100, new SpinnerEvent(0));
			spinner[0].start();

			spinner[1] = new Timer(120, new SpinnerEvent(1));
			spinner[1].start();

			spinner[2] = new Timer(140, new SpinnerEvent(2));
			spinner[2].start();
		}

	}

	/**
	 * inner class to represent a timer event
	 */
	private class TimerEvent implements ActionListener {

		private int i;

		/**
		 * constructor
		 * 
		 * @param i
		 */
		public TimerEvent(int i) {
			this.i = i;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			// stop sippner and timmer
			spinner[i].stop();
			timer[i].stop();

			// show results
			if (i == 2) {
				JOptionPane.showMessageDialog(getParent(), "You bet $1\nYou get $" + finalPayout + "\n");
				clearReelImage();
				// set spin button clickable again
				spin.setEnabled(true);
			}
		}

	}

	/**
	 * inner class to represent a spinner event
	 */
	private class SpinnerEvent implements ActionListener {

		private int i;
		private int counter;

		/**
		 * constructor
		 * 
		 * @param i
		 */
		public SpinnerEvent(int i) {
			this.i = i;
			counter = 0;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			// change images
			reels[i].setIcon(images.get(counter % 7));
			counter++;

		}

	}

	/**
	 * helper method to reset images
	 */
	private void clearReelImage() {
		reels[0].setIcon(loadImage("unkown.jpg"));
		reels[1].setIcon(loadImage("unkown.jpg"));
		reels[2].setIcon(loadImage("unkown.jpg"));
	}

}
