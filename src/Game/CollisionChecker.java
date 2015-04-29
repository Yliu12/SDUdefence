package Game;

import java.awt.Point;
import java.awt.Rectangle;


import monsters.MonsterSuper;


//import org.apache.log4j.Logger;


import gameObject.Cannonball;

import gameObject.Computer;


public class CollisionChecker {

	//private static Logger logger = Logger.getLogger(CollisionChecker.class);
/*
	public static void detectCoinShipCollision() {

		Rectangle coinRect;

		for (int n = 0; n < Game.coinList.size();) {
			Coin c = Game.coinList.get(n);
			coinRect = c.getCollisionRect();
			if (Computer.intersects(coinRect)) {
				Game.coinList.remove(c);
				Game.score.add(10);
				Computer.shipLevelUp();
				logger.info("score = " + Game.score.getScore());
			} else
				n++;
		}
	}

	public static boolean detectShipBarrierCollision(Point destination) {
		boolean flag = false;
		Rectangle barrierRect;
		for (int i = 0; i < Game.barrierList.size(); i++) {
			Barrier b = Game.barrierList.get(i);
			barrierRect = b.getCollisionRect();
			if (Computer.willIntersect(barrierRect, destination))
				flag = true;
		}
		for (int i = 0; i < Game.bossList.size(); i++) {
			Boss b = Game.bossList.get(i);
			barrierRect = b.getRect();
			if (Computer.willIntersect(barrierRect, destination))
				flag = true;
		}
		return flag;
	}

	public static void detectShipWhirlpoolCollision() {
		Rectangle whirlpoolRect;

		for (int n = 0; n < Game.whirlpoolList.size();) {
			Whirlpool pool = Game.whirlpoolList.get(n);
			whirlpoolRect = pool.getRect();
			if (Computer.intersects(whirlpoolRect)) {
				if (!pool.hit && pool.phase == 2) {
					Computer.currentHP -= 2;
					pool.hit();
					if (!Computer.isAlive())
						Game.gameOver();
				}
				Computer.state = Computer.WHIRLPOOL_STATE;
			}

			n++;
		}

	}
/**/
	public static synchronized void detectCannonEdgeCollision() {
	Cannonball c;
		for (int n = 0; n < Game.cannonballList.size();) {

			c = Game.cannonballList.get(n);
			c.isOutOfBounds();
			if (c.outOfBounds) {
				Game.cannonballList.remove(c);
				//logger.info("remove cannonball");
			} else
				n++;
		}
	}
	/*
	public static void detectFireballEdgeCollision() {
		Fireball p;
		for (int n = 0; n < Game.fireballList.size();) {
			p = Game.fireballList.get(n);
			p.checkIfOutOfBounds();
			if (p.outOfBounds) {
				Game.fireballList.remove(p);
				logger.info("remove fireball");
			} else
				n++;
		}
	}

	public static void detectFireballShipCollision() {
		Fireball p;
		for (int n = 0; n < Game.fireballList.size();) {

			p = Game.fireballList.get(n);
			if (Computer.intersects(p.getRect())) {
				Game.fireballList.remove(p);
				logger.info("remove fireball");
				Computer.currentHP-=2;
				if (!Computer.isAlive())
					Game.gameOver();
			}

			else
				n++;
		}
	}
*/
	public static void detectShipTestMonsterCollision() {
		Rectangle monsterRect;

		for (int n = 0; n < Game.monsterTestList.size();) {
			MonsterSuper m = (MonsterSuper) Game.monsterTestList.get(n);
			monsterRect = Game.monsterTestList.get(n).getRect();
			if (Computer.intersects(monsterRect)) {
				//logger.debug("ship collided with monster");
				if (!Computer.getIfgetComputer())
					//Computer.currentHP -= Game.monsterTestList.get(n)
							//.getDamage()
					;
				else {
					Computer.HitTimesOfMonsters++;
					Computer.detectIFgetComputerEnd();
					//logger.info("Ship's shield number is used: "
							//+ Computer.HitTimesOfMonsters);
				}
				Game.monsterTestList.remove(m);
			//	logger.info("HP = " + Computer.currentHP);
				if (!Computer.isAlive())
					;
					//Game.gameOver();
			} else
				n++;
		}
	}

	public static synchronized void detectCannonTestMonsterCollision() {
		Cannonball cannon;
		int powerUpCode;
		for (int n = 0; n < Game.cannonballList.size();) {
			cannon = Game.cannonballList.get(n);
			Rectangle cannonRect = cannon.getRect();
			for (int m = 0; m < Game.monsterTestList.size();) {
				MonsterSuper monster = (MonsterSuper) Game.monsterTestList
						.get(m);
				Rectangle monsterRect = Game.monsterTestList.get(m).getRect();
				Point p = Game.monsterTestList.get(m).getLocation();
				if (monsterRect.intersects(cannonRect)) {
					Game.monsterTestList.get(m).takeDamage(1);
					if (Game.monsterTestList.get(m).isDead()) {
						
						//if (Game.monsterTestList.get(m).hasPowerUp()) {
							
							
						
						Game.monsterTestList.remove(monster);
						//logger.info("monster slain");

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
				logger.info("HP= " + Computer.currentHP);
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
		//detectCoinShipCollision();
		detectShipTestMonsterCollision();
		detectCannonTestMonsterCollision();
		detectCannonEdgeCollision();
		//detectShipHPPCollision();
		//detectShipGSCollision();
		//detectShipWhirlpoolCollision();
		//detectFireballEdgeCollision();
		//detectFireballShipCollision();
		//detectBossCannonCollision();
		//detectJellyMonsterCollision();
	}

}
