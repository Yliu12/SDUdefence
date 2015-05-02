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
				//System.out.println(Computer.currentHP );
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
			//	System.out.println(Computer.currentHP);
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
		//	System.out.print("++++"+Game.Score);
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
						
						//if (Game.monsterTestList.get(m).hasPowerUp()) {
							
							
						
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
/*
	public static synchronized void detectJellyMonsterCollision() {

		boolean hit = false;
		for (int n = 0; n < Game.monsterTestList.size();) {
			if (Game.monsterTestList.get(n) instanceof Jellyfin) {
				Jellyfin jelli = (Jellyfin) Game.monsterTestList.get(n);
				Rectangle jellyRect = Game.monsterTestList.get(n).getRect();
				for (int m = n; m < Game.monsterTestList.size();) {
					MonsterSuper monster = (MonsterSuper) Game.monsterTestList
							.get(m);
					Rectangle monsterRect = Game.monsterTestList.get(m)
							.getRect();
					Point p = Game.monsterTestList.get(m).getLocation();
					if (monsterRect.intersects(jellyRect)
							&& !(monster instanceof Jellyfin) && hit == false)
					{
						hit = true;
						jelli.feed();
						{
							jelli.feedTimer = 0;
							Game.monsterTestList.get(m).setVelocity(4);
							Game.monsterTestList.get(m).setHealth(5);
						}
						m++;
					} else
						m++;
				}
				if (hit == false) {
					jelli.stopFeed();
				}
			}
			n++;
		}
	}

	public static void detectShipHPPCollision() {
		Rectangle HPPRect;

		for (int n = 0; n < Game.HPPList.size();) {
			HealthPacket HPP = Game.HPPList.get(n);
			HPPRect = HPP.getCollisionRect();
			if (Computer.intersects(HPPRect)) {
				Game.HPPList.remove(HPP);
				Computer.currentHP += HealthPacket.hpValue;
				
			} else
				n++;
		}
	}

	// do not remove boss from list during this method - it will break.
	public static synchronized void detectBossCannonCollision() {
		Cannonball cannon;
		Boss boss;
		for (int n = 0; n < Game.bossList.size();) {
			boss = Game.bossList.get(n);
			Rectangle bossRect = boss.getRect();
			for (int p = 0; p < Game.cannonballList.size();) {
				cannon = Game.cannonballList.get(p);
				if (bossRect.intersects(cannon.getRect())) {
					double random = Math.random();
					boss.loseHealth(1);
					if(random>0.8)
					Game.coinList.add(new Coin(cannon.getLocation()));
					Game.cannonballList.remove(cannon);
					logger.info(boss.getHealth());
					break;
				} else
					p++;
			}
			n++;
		}
	}

	public static void detectShipGSCollision() {
		Rectangle GSRect;
		for (int n = 0; n < Game.GSList.size();) {
			Computer GS = Game.GSList.get(n);
			GSRect = GS.getCollisionRect();
			if (Computer.intersects(GSRect)) {
				Game.GSList.remove(GS);
				Computer.setIfgetComputer(true);
				Computer.maxSpeed += Computer.speedUp;
				logger.info("Maxspeed= " + Computer.maxSpeed);
			} else
				n++;
		}
	}
*/
	public static void detectCollisions() {		
		detectMonsterBaseCollision();	
		detectShipTestMonsterCollision();
		detectCannonTestMonsterCollision();
		detectCannonEdgeCollision();
	
	}

}
