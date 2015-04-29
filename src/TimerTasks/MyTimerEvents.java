package TimerTasks;

import gameObject.Computer;

import java.util.TimerTask;

import monsters.MonsterType;
import Frame.BattleField;
import Game.CollisionChecker;
import Game.Game;
import gameObject.Cannonball;

public class MyTimerEvents extends TimerTask{

	@Override
	public void run() {
		if (Game.phase == 1) {
		// TODO Auto-generated method stub
		moveTestMonster();
		moveShip();
		moveCannonballs();
		CollisionChecker.detectCollisions();
		//System.out.println(Computer.Location.toString());
		Game.frame.repaint();}
	}

	private void moveShip() {
		// TODO Auto-generated method stub
		Computer.setLocationAfterMovement();
		Computer.xfloatcount++;
		Computer.yfloatcount++;
	}

	
	private synchronized void moveCannonballs() {

		for (Cannonball c : Game.cannonballList) {
			c.setLocationAfterMovement();
		}
	
	}

	private void moveTestMonster() {

		for (MonsterType m:Game.monsterTestList)
		{
			m.setLocationAfterMovement();
			Game.monsterTest.setLocationAfterMovement();
		}

	}
}
