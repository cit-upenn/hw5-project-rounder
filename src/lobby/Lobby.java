package lobby;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import keno.*;
import roulette.*;
import slot_machine.*;

/**
 * This class represents the game lobby, which has 3 options: Roulette, Keno,
 * Slot Machine.
 * 
 * @author SHANG
 *
 */
public class Lobby extends JFrame {

	private static final long serialVersionUID = 5008340198532190080L;

	// instance variables

	// GUI variables
	private JPanel top, left, right, bottom, center;
	private JButton roulette, keno, slot;
	private JLabel lobbyView;

	private static final Border WHITE_BORDER = new LineBorder(Color.WHITE, 2);
	private static final Color DARK_GREEN = new Color(0, 100, 0);
	private static final Color MEDIUM_ORCHID = new Color(186, 85, 211);

	/**
	 * constructor
	 */
	public Lobby() {
		display();
	}

	/**
	 * helper method to construct the lobby
	 */
	private void display() {
		setTitle("Lobby");
		layOutComponents();
		attachListenersToComponents();
		setPreferredSize(new Dimension(600, 400));
		setLocation();
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * set the location of lobby window
	 */
	private void setLocation() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() / 2 - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() / 2 - this.getHeight()) / 2);
		setLocation(x, y);
	}

	/**
	 * helper method to add image to the view
	 */
	private void addImage() {

		// adjust image size and add to view
		ImageIcon image = new ImageIcon(getClass().getResource("lobby.jpg"));
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(600, 360, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newImage = new ImageIcon(newImg);
		lobbyView = new JLabel(newImage);
		center.add(lobbyView);
	}

	/**
	 * helper method to set the layout
	 */
	private void layOutComponents() {
		setLayout(new BorderLayout());
		addPanels();
		addSubPanels();
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
		add(left, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(right, BorderLayout.EAST);
		add(bottom, BorderLayout.SOUTH);

	}

	/**
	 * helper method to add sub-panels within the bottom panel
	 */
	private void addSubPanels() {

		bottom.setLayout(new GridLayout(1, 3));
		bottom.setBackground(DARK_GREEN);

		// add 3 option buttons
		roulette = new JButton("Roulette");
		setButton(roulette);
		bottom.add(roulette);
		keno = new JButton("Keno");
		keno.setForeground(Color.white);
		setButton(keno);
		bottom.add(keno);
		slot = new JButton("Slot Machine");
		setButton(slot);
		bottom.add(slot);

	}

	/**
	 * set button attributes
	 * 
	 * @param button
	 */
	private void setButton(JButton button) {
		button.setForeground(Color.white);
		button.setBackground(MEDIUM_ORCHID);
		button.setOpaque(true);
		button.setBorderPainted(true);
		button.setBorder(WHITE_BORDER);
		button.setFont(new Font("Arial", Font.PLAIN, 25));

	}

	/**
	 * attach action listeners to buttons
	 */
	private void attachListenersToComponents() {

		// add listeners to buttons
		roulette.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Game.rouletteView.setVisible(true);
			}

		});

		keno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Game.kenoView.setVisible(true);
			}

		});

		slot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Game.slotView.setVisible(true);
			}

		});

	}

}
