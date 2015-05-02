package Game;
import java.awt.Point;
import java.awt.Rectangle;
import monsters.MonsterSuper;
import gameObject.Cannonball;
import gameObject.Computer;
public class CollisionChecker {
	public static synchronized void detectCannonEdgeCollision() {
	Cannonball c;
		for (int n = 0; n < Game.cannonballList.size();n++) {
			c = Game.cannonballList.get(n);
			if (c.isOutOfBounds()) {
				Game.cannonballList.remove(c);
			} 
		}
	}
	public static synchronized void detectMonsterEdgeCollision() {
	for (int n = 0; n < Game.monsterTestList.size();n++) {
		MonsterSuper m = (MonsterSuper) Game.monsterTestList.get(n);
			if (m.isOutOfBounds()) {
				Game.monsterTestList.remove(m);
			} 
		}
	}
	public static synchronized void detectMonsterBaseCollision() {
		for (int n = 0; n < Game.monsterTestList.size();n++) {
			MonsterSuper m = (MonsterSuper) Game.monsterTestList.get(n);
			if (m.isAtBottom()){
				Computer.currentHP--;
				Game.monsterTestList.remove(m);
				
			}
		}
	}
	public static void detectShipTestMonsterCollision() {
		Rectangle monsterRect;
		for (int n = 0; n < Game.monsterTestList.size();) {
			MonsterSuper m = (MonsterSuper) Game.monsterTestList.get(n);
			monsterRect = Game.monsterTestList.get(n).getRect();
			if (Computer.intersects(monsterRect)) {
				if (!Computer.getIfgetComputer()){
					Computer.currentHP -= Game.monsterTestList.get(n)
							.getDamage();
			
					}
				else {
					Computer.HitTimesOfMonsters++;
					Computer.detectIFgetComputerEnd();
				}
				Game.monsterTestList.remove(m);
			} else
				n++;
		}
		if (!Computer.isAlive()){
		
			IOScore.WriteScore(Game.Score);
			Game.gameOver();}
	}
	public static synchronized void detectCannonTestMonsterCollision() {
		Cannonball cannon;
		for (int n = 0; n < Game.cannonballList.size();) {
			cannon = Game.cannonballList.get(n);
			Rectangle cannonRect = cannon.getRect();
			for (int m = 0; m < Game.monsterTestList.size();) {
				MonsterSuper monster = (MonsterSuper) Game.monsterTestList
						.get(m);
				Rectangle monsterRect = Game.monsterTestList.get(m).getRect();
				Point p = Game.monsterTestList.get(m).getLocation();
				if (monsterRect.intersects(cannonRect)) {
					Game.Score += Game.monsterTestList.get(m).getScore();
					Game.monsterTestList.get(m).takeDamage(1);
					if (Game.monsterTestList.get(m).isDead()) {
						
						Game.monsterTestList.remove(monster);
					}
					Game.cannonballList.remove(cannon);
				}
				if (Game.cannonballList.size() == 0)
					break;
				else
					m++;
			}
			n++;
		}
	}

	public static void detectCollisions() {		
		detectMonsterBaseCollision();	
		detectShipTestMonsterCollision();
		detectCannonTestMonsterCollision();
		detectCannonEdgeCollision();
	}
}
