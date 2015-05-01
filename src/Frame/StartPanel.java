package Frame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Game.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class StartPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		this.setSize(GameFrame.DEFAULT_SIZE);
		setLayout(null);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 540, 720);
		lblBackground.setIcon(new ImageIcon("pic/startPanelBackground.jpg"));
		lblBackground.setHorizontalTextPosition(SwingConstants.LEFT);
		final JLabel lblHowToPlay = new JLabel("");
		lblHowToPlay.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHowToPlay.setVisible(false);
		final JButton btnStart = new JButton("");
		btnStart.setIcon(new ImageIcon("pic/btnStart.png"));
		btnStart.setContentAreaFilled(false);
		btnStart.setBorderPainted(false);
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStart.setBounds(310, 502, 150, 50);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnStart.setBounds(308, 500, 150, 50);
				
			}
		});
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.startNewGame();
				
				
				
				
			}
		});
		
		final JButton btnClose = new JButton("");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHowToPlay.setVisible(false);
				btnClose.setVisible(false);
			}
		});
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setVisible(false);
		btnClose.setIcon(new ImageIcon("pic/hi.png"));
		btnClose.setBounds(414, 375, 30, 30);
		add(btnClose);
		
		
		lblHowToPlay.setIcon(new ImageIcon("pic/HowToPlay.png"));
		lblHowToPlay.setBounds(55, 116, 437, 324);
		add(lblHowToPlay);
		btnStart.setBounds(308, 500, 150, 50);
		add(btnStart);
		
		final JButton btnInstruct = new JButton("");
		btnInstruct.setIcon(new ImageIcon("pic/btnhtp.png"));
		btnInstruct.setContentAreaFilled(false);
		btnInstruct.setBorderPainted(false);
		btnInstruct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInstruct.setBounds(96, 502, 150, 50);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnInstruct.setBounds(94, 500, 150, 50);
				
			}
		});
		btnInstruct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHowToPlay.setVisible(true);
				btnClose.setVisible(true);
			}
		});
		btnInstruct.setBounds(94, 500, 150, 50);
		add(btnInstruct);
		add(lblBackground);
	}
}
