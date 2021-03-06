package Frame;
import gameObject.Cannonball;
import gameObject.Computer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import monsters.TestMonster;
import Game.Game;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
public class BattleField extends JPanel implements  MouseListener, ActionListener {
	
	private static final long serialVersionUID = 1L;
	public static boolean WPressed;
	public static boolean SPressed;
	public static boolean APressed;
	public static boolean DPressed;
	public static boolean JPressed;
	public static boolean KPressed;
	public static JLabel lblHP = new JLabel();
	public static JLabel lblScore = new JLabel();
public BattleField(){
	lblHP.setForeground(Color.WHITE);
	lblHP.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblHP.setText(Computer.currentHP+"");
	lblScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblScore.setForeground(Color.WHITE);
	lblScore.setText(Game.Score+"");
	lblScore.setBounds(30, 30, 199, 30);
	lblHP.setBounds(30, 50, 100, 30);
	lblHP.setVisible(true);
	this.add(lblHP);
	this.add(lblScore);
	InputMap im = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
	ActionMap am = this.getActionMap();
	
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "W");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "A");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "S");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "D");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "P");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "Q");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_J, 0), "J");
	am.put("W", new KeyAction("W"));
	am.put("A", new KeyAction("A"));
	am.put("S", new KeyAction("S"));
	am.put("D", new KeyAction("D"));
	am.put("P", new KeyAction("P"));
	am.put("Q", new KeyAction("Q"));
	am.put("J", new KeyAction("J"));
	this.setSize(GameFrame.DEFAULT_SIZE);
	this.setLayout(null);
	this.addMouseListener(this);
	this.setVisible(true);
	this.setFocusable(true);
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("Pic/battleField.png"));
	label.setBounds(0, 0, 540, 720);
	add(label);
}
public void paint(Graphics g){
	 super.paint(g);
	drawComputer(g,Computer.getLocation());
	drawCannonballs(g);
	drawTestMonsters(g);
}
	public void drawTestMonsters(Graphics g) {
		for (int n = 0; n < Game.monsterTestList.size(); n++) {
			Image monsterImage = Game.monsterTestList.get(n).getImage();
			Point monsterLocation = Game.monsterTestList.get(n).getLocation();
			g.drawImage(monsterImage, (int) monsterLocation.getX(),
					(int) monsterLocation.getY(), null);
		}
		for (int n = 0; n < Game.monsterTestList.size(); n++) {
			Image monsterImage = Game.monsterTestList.get(n).getImage();
			Point monsterLocation = Game.monsterTestList.get(n).getLocation();
		}
	}
public void drawComputer(Graphics g, Point atPoint) {
	Image computer =Computer.ComputerImg;
	g.drawImage(computer, (int) atPoint.getX(), (int) atPoint.getY(),
			null);
}
	public synchronized void drawCannonballs(Graphics g) {
		for (int n = 0; n < Game.cannonballList.size(); n++) {
			Cannonball cannonball = Game.cannonballList.get(n);
			Image cannonImage = Cannonball.IMAGE;
			Point cannonLocation = cannonball.getLocation();
			g.drawImage(cannonImage, (int) cannonLocation.getX(),
					(int) cannonLocation.getY(), null);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		this.requestFocusInWindow();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
