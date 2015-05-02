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
		
		moveTestMonster();
		moveShip();
		moveCannonballs();
		CollisionChecker.detectCollisions();
		
		Game.frame.repaint();}
		BattleField.lblHP.setText("HP    "+Computer.currentHP+"");
		BattleField.lblScore.setText("Score   "+Game.Score+"");
		BattleField.lblHP.repaint();
		BattleField.lblScore.repaint();
	}
	private void moveShip() {
		
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
