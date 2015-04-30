package Frame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Game.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		this.setSize(GameFrame.DEFAULT_SIZE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 540, 720);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\YLIU12\\Desktop\\startPanelBackground.jpg"));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.startNewGame();
				
				
				
				
			}
		});
		btnStart.setBounds(350, 500, 150, 50);
		add(btnStart);
		add(lblNewLabel);
	}
}
