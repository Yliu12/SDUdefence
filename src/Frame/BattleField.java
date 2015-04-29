package Frame;

import gameObject.Cannonball;
import gameObject.Computer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;









import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


import monsters.TestMonster;
import Game.Game;





public class BattleField extends JPanel implements  MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean WPressed;
	public static boolean SPressed;
	public static boolean APressed;
	public static boolean DPressed;
	public static boolean JPressed;
	public static boolean KPressed;


public BattleField(){
	
	
	InputMap im = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
	ActionMap am = this.getActionMap();
	// Key Bindings*********************************************************
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
	
	

	
	
	this.setSize(800,1000);
	this.setLayout(null);
	//this.setOpaque(false);
	//this.addKeyListener(this);
	this.addMouseListener(this);
	this.setVisible(true);
	this.setFocusable(true);
	repaint();
}

public void paint(Graphics g){
	
	//g.clearRect(0,0, 800, 1000);
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
			/*if (Game.monsterTestList.get(n) instanceof Jellyfin)
				g.drawImage(monsterImage, (int) monsterLocation.getX(),
						(int) monsterLocation.getY(), null);*/

		}
	}

public void drawComputer(Graphics g, Point atPoint) {
	Image computer =Computer.ComputerImg;

	g.drawImage(computer, (int) atPoint.getX(), (int) atPoint.getY(),
			null);
	
}
	/*
	@Override
	public void keyPressed(KeyEvent e) {		
		// TODO Auto-generated method stub
		
		int key = e.getKeyCode(); 
		switch (key) {
		case KeyEvent.VK_W: 
			Computer.Ymove=-10;
			break;
		case KeyEvent.VK_S:
			Computer.Ymove=+10;
			break;
		case KeyEvent.VK_A:
			Computer.Xmove=-10;
			break;
		case KeyEvent.VK_D:
			DPressed = true;
			Computer.Xmove=+10;
			break;
		case KeyEvent.VK_J:{
			
		
				//cannonClip.play();
				Game.cannonwatch.reset();
				Game.cannonwatch.start();
				Cannonball cannon = new Cannonball(Computer.getCenter(), new Point(0,0));
				synchronized (Game.cannonballList)
				{
				Game.cannonballList.add(cannon);
				}
				//logger.debug("cannonball angle " + Game.cannonballList.get(Game.cannonballList.size() - 1).angleInDegrees);
			
			
			JPressed = true;
			break;}
		case KeyEvent.VK_K:		
			KPressed = true;
			break;		
			
			
			
			
		}
	
	}
	
*/
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.requestFocusInWindow();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
