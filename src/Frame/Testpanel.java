package Frame;
import gameObject.Cannonball;
import gameObject.Computer;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import physics.Trig;

public class Testpanel extends JFrame implements KeyListener, MouseListener {
	private int x = 300;
	private int y = 300;
	private int x1 = 0;
	private int y1 = 0;
	private int mouseX = 0;
	private int mouseY = 0;
	private Trig t = new Trig();
	Computer com = new Computer();
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	

	/**
	 * http://dl.google.com/eclipse/inst/d2wbpro/latest/3.6
	 * 
	 * Go Set a VPN and download!!!!!!!!
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public Testpanel() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(this);
		this.addMouseListener(this);
		x = com.Location.x;
		y = com.Location.y;

	}

	/*
	 * public void gameloop(){ while(true){ x++;
	 * 
	 * 
	 * for(int i=0;i<100000000;i++){} repaint(); }
	 * 
	 * }
	 */

	public void paint(Graphics g) {
		g = this.getGraphics();
		g.clearRect(0, 0, 600, 400);
		// g.fillOval(x,y,40, 40);
		g.drawImage(Computer.getImage(), (int) com.getLocation().x,
				(int) com.getLocation().y, null);
		g.fillOval(x1, y1, 40, 40);
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode(); // 获取按键码
		switch (key) {
		case KeyEvent.VK_UP: // 向上
			up = true;
			y -= 10;
			break;
		case KeyEvent.VK_DOWN:
			y += 10;
			break;
		case KeyEvent.VK_LEFT:
			x -= 10;
			break;
		case KeyEvent.VK_RIGHT:
			x += 10;
			break;
		case KeyEvent.VK_SPACE:		
			Cannonball Cball = new Cannonball(com.Location);
			break;
		}
		Point newLocation = new Point(x, y);
		com.setLocation(newLocation);
		System.out.println(com.Location.toString());

		this.repaint();

		
		
		
		
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int i = e.getKeyCode();  
	       switch(i) {  
	           case  KeyEvent.VK_LEFT :  left=false;  break;  
	           case  KeyEvent.VK_UP :   up= false;break;  
	           case  KeyEvent.VK_DOWN :down = false; break;  
	           case  KeyEvent.VK_RIGHT : right = false;break;  
	       }  
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		Point destLocation = new Point(e.getX(), e.getY());
		Point startLocation = new Point(x, y);
		startLocation = com.Location;
		System.out.println(startLocation.toString());

		Point newLoc = new Point(0, 0);
		for (int i=0;i<10;i++) {

			newLoc = Trig.getNextMoveTowardsPoint(startLocation, destLocation,
					10);

			x1 = newLoc.x;
			y1 = newLoc.y;

			System.out.println(startLocation.toString() + newLoc.toString()
					+ destLocation.toString());

			startLocation = newLoc;

			

			this.repaint();
			for (int j = 0; j < 9999999; j++) {
			}
		}

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}




}