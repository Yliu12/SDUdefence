package TimerTasks;

import gameObject.Computer;

import java.util.TimerTask;

import Frame.BattleField;
import Frame.Game;

public class MyTimerEvents extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		moveShip();
		//System.out.println(Computer.Location.toString());
		Game.frame.repaint();
	}

	private void moveShip() {
		// TODO Auto-generated method stub
		Computer.setLocationAfterMovement();
	}

	
	
	
	
	
}
