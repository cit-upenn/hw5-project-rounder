package lobby;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import keno.*;
import roulette.*;

/**
 * This class represents the game lobby, which has 3 options: Roulette, Keno, Slot Machine.
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
		setPreferredSize(new Dimension(1000, 400));
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
		Image newImg = img.getScaledInstance(1000, 360, java.awt.Image.SCALE_SMOOTH);
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

		// add 3 option buttons
		roulette = new JButton("Roulette");
		bottom.add(roulette);
		keno = new JButton("Keno");
		bottom.add(keno);
		slot = new JButton("Slot Machine");
		bottom.add(slot);

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
				new RouletteView().setVisible(true);
				new KenoView().setVisible(false);
			}
			
		});
		
		keno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new RouletteView().setVisible(false);
				new KenoView().setVisible(true);
			}
			
		});

	}
	
	/**
	 * test the class
	 */
	public static void main(String[] args) {
		Lobby lobby = new Lobby();
	}
	
}
