package Frame;

import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

//import org.apache.log4j.Logger;


import java.net.MalformedURLException;

import Game.Game;

import gameObject.Cannonball;
import gameObject.Computer;

public class KeyAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// private static Logger logger = Logger.getLogger(KeyAction.class);

	private String cmd;
	private java.applet.AudioClip cannonClip;

	public KeyAction(String cmd) {
		this.cmd = cmd;
	this.cannonClip = makeSound("sounds/cannon.wav");
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		if (Game.phase == 1) {
			if (cmd.equals("W"))
				//Computer.Ymove -=  10;
				Computer.nudge(Computer.DIRECTION_CODE_UP);
			else if (cmd.equals("A"))
				 Computer.nudge(Computer.DIRECTION_CODE_LEFT);
				//Computer.Xmove -= 10;
			else if (cmd.equals("S"))
				//Computer.Ymove += 10;
			 Computer.nudge(Computer.DIRECTION_CODE_DOWN);
			else if (cmd.equals("D")) {
				//Computer.Xmove += 10;
			
				 Computer.nudge(Computer.DIRECTION_CODE_RIGHT);
			}  else if (cmd.equals("J")) {
				cannonClip.play();
				Game.cannonwatch.reset();
				Game.cannonwatch.start();
				Cannonball cannon = new Cannonball(new Point(
						Computer.Location.x + 15, Computer.Location.y - 5),
						new Point(Computer.Location.x, 0));
				synchronized (Game.cannonballList) {
					Game.cannonballList.add(cannon);
				}
				// logger.debug("cannonball angle " +
				// Game.cannonballList.get(Game.cannonballList.size() -
				// 1).angleInDegrees);

			}
		}if (cmd.equals("P")) {
			
			if (Game.phase ==1){
				Game.phase = 0;Game.frame.validate();}
			else{
				Game.unpause();Game.frame.validate();
			}System.out.println(Game.phase);
		} 
//System.out.println(Computer.Xmove+" "+Computer.Ymove);
	}

	private java.applet.AudioClip makeSound(String location) {
		try {
			java.applet.AudioClip clip = java.applet.Applet
					.newAudioClip(new java.net.URL("file:" + location));
			return clip;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}