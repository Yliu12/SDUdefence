package Frame;
import gameObject.Computer;
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
public class StartPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public StartPanel() {
		this.setSize(GameFrame.DEFAULT_SIZE);
		setLayout(null);
		final JLabel lblHowToPlay = new JLabel("");
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
		final JPanel ChoosePanel = new JPanel();
		ChoosePanel.setVisible(false);
		ChoosePanel.setBounds(55, 116, 437, 324);
		add(ChoosePanel);
		ChoosePanel.setLayout(null);
		final JButton btn1 = new JButton("");
		btn1.setIcon(new ImageIcon("pic/debugger1.png"));
		btn1.setBounds(189, 75, 50, 50);
		ChoosePanel.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Computer.ChangeImg("pic/debugger1.png"); 
				ChoosePanel.setVisible(false);
			}
		});
		final JButton btn2 = new JButton("");
		btn2.setIcon(new ImageIcon("pic/debugger2.png"));
		btn2.setBounds(78, 181, 50, 50);
		ChoosePanel.add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Computer.ChangeImg("pic/debugger2.png"); 
				ChoosePanel.setVisible(false);
			}
		});
		final JButton btn3 = new JButton("");
		btn3.setIcon(new ImageIcon("pic/debugger3.png"));
		btn3.setBounds(305, 181, 50, 50);
		ChoosePanel.add(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Computer.ChangeImg("pic/debugger3.png"); 
				ChoosePanel.setVisible(false);
			}
		});
		btn1.setContentAreaFilled(false);
		btn1.setBorderPainted(false);
		btn2.setContentAreaFilled(false);
		btn2.setBorderPainted(false);
		btn3.setContentAreaFilled(false);
		btn3.setBorderPainted(false);
		ChoosePanel.setOpaque(false);
		JLabel lblChoose = new JLabel("");
		lblChoose.setIcon(new ImageIcon("pic/ChooseDebugger.png"));
		lblChoose.setBounds(0, 0, 437, 327);
		ChoosePanel.add(lblChoose);
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
		btnClose.setIcon(new ImageIcon("pic/Close.png"));
		btnClose.setBounds(414, 375, 30, 30);
		add(btnClose);
		lblHowToPlay.setBounds(55, 116, 437, 324);
		add(lblHowToPlay);
		lblHowToPlay.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHowToPlay.setVisible(false);
		lblHowToPlay.setIcon(new ImageIcon("pic/HowToPlay.png"));
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
		final JButton btnChoose = new JButton("");
		btnChoose.setIcon(new ImageIcon("pic/btnChoose.png"));
		btnChoose.setContentAreaFilled(false);
		btnChoose.setBorderPainted(false);
		btnChoose.setBounds(200, 571, 150, 50);
		add(btnChoose);
		btnChoose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChoose.setBounds(202, 573, 150, 50);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnChoose.setBounds(200, 571, 150, 50);
			}
		});
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoosePanel.setVisible(true);
			}
		});
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 540, 720);
		add(lblBackground);
		lblBackground.setIcon(new ImageIcon("pic/startPanelBackground.jpg"));
		lblBackground.setHorizontalTextPosition(SwingConstants.LEFT);
	}
}
