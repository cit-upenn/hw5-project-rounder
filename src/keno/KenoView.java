package keno;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * This class represents a keno lottery ticket
 * 
 * @author SHANG
 *
 */
public class KenoView extends JFrame {

	private static final long serialVersionUID = 7261847457620625993L;

	// instance variables
	private Keno keno;

	// GUI variables
	private JPanel top, left, right, bottom, center;
	private JButton[] buttons;
	private static final Border WHITE_BORDER = new LineBorder(Color.WHITE, 2);

	/**
	 * constructor
	 */
	public KenoView() {
		keno = new Keno();
		display();
	}

	/**
	 * helper method to construct the keno ticket
	 */
	private void display() {
		setTitle("Roulette");
		layOutComponents();
		// attachListenersToComponents();
		setPreferredSize(new Dimension(1200, 400));
		setLocation();
		pack();
		setVisible(true);
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
	 * helper method to add buttons
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
			buttons[i].setBackground(Color.blue);
			buttons[i].setOpaque(true);
			buttons[i].setBorderPainted(true);
			buttons[i].setBorder(WHITE_BORDER);
			buttons[i].setFont(new Font("Arial", Font.PLAIN, 25));
			center.add(buttons[i]);
		}

	}

	/**
	 * test the class
	 */
	public static void main(String[] args) {
		KenoView kv = new KenoView();
	}

}
