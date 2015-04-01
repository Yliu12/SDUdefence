package Frame;

import gameObject.Cannonball;
import gameObject.Computer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;







import javax.swing.JLabel;
import javax.swing.JPanel;






public class BattleField extends JPanel implements KeyListener{

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
	this.setSize(400,600);
	this.setLayout(null);
	//this.setOpaque(false);
	this.addKeyListener(this);
	this.setVisible(true);
	this.setFocusable(true);
	repaint();
}

public void paint(Graphics g){
	
	//g.clearRect(0,0, 400, 600);
	drawComputer(g,Computer.getLocation());
	drawCannonballs(g);
}

public void drawComputer(Graphics g, Point atPoint) {
	Image computer =Computer.ComputerImg;

	g.drawImage(computer, (int) atPoint.getX(), (int) atPoint.getY(),
			null);
	
}
	
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
		case KeyEvent.VK_J:		
			JPressed = true;
			break;
		case KeyEvent.VK_K:		
			KPressed = true;
			break;		
			
			
			
			
		}
	System.out.println(Computer.Ymove);
	}
	
	
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
	

}
