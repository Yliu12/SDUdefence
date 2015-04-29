package monsters;

import gameObject.Computer;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

//import org.apache.log4j.Logger;



import physics.Trig;
//import Frame.DisplayFrame;
import Frame.GameFrame;
//import GameObjects.PirateShip;
//import collectibles.Coin;

public class MonsterSuper implements MonsterType{
	//Logger logger = Logger.getLogger(MonsterSuper.class);

	public static final String DEFAULT_IMAGE_LOCATION = "gfx/monster.png";
	public static final Image DEFAULT_IMAGE = new ImageIcon(DEFAULT_IMAGE_LOCATION).getImage();
	public static final String DEFAULT_IMAGE_LOCATION2 = "gfx/monster3.png";
	public static final Image DEFAULT_IMAGE2 = new ImageIcon(DEFAULT_IMAGE_LOCATION2).getImage();
	public static final int NUMBER_OF_POWERUPS=3;
	public static final double POWER_UP_CHANCE=0.02;
	public static final int HEALTH=1;
	public static final int GHOST=2;
	public static final int CANNON=3;
	public int maxCoinsPerKill=4;
	public int minCoinsPerKill=1;
	protected Image image;
	protected Image image2;
	protected Dimension dimensions;
	protected Point location;
	protected int angleInDegrees;
	public double velocity=1.0;
	protected int damage=1;
	protected int count;
	protected int phase=1;
	protected int clockmax=20;
	protected int phasemax=2;;
	public int maxHP=1;
	public int HP=maxHP;
	public boolean givesPowerup;

	
	
	public MonsterSuper(Point startingPoint)
	{
		image=DEFAULT_IMAGE;
		image2=DEFAULT_IMAGE;
		location=startingPoint;
		count=0;
		givesPowerup=false;
	}
	public static Point getRandomSpawnLocation() {
		Point location = new Point();
		int x;
		int y;
		
		int maxY =(int) (1000+10);
		int minY =-10 - DEFAULT_IMAGE.getHeight(null);
		int maxX = (int) (800);
		int minX=-10-DEFAULT_IMAGE.getWidth(null);
		
		double random = Math.random();
		
		double random2 = Math.random();
		if(random<=0.25)
		{
		x= (int) (random2*(double) maxX);
			y=maxY;
		}
		else if(random<=.5)
		{
			x=(int) (random2*maxX);
			y=minY;
		}
		else if(random<=.75)
		{
			x=maxX;
			y=(int)(random2*maxY);
		}
		else
		{
			x=minX;
			y=(int)(random2*maxY);
		}
		
		location.setLocation(x, 0);
		return location;
			
	}

	@Override
	public Image getImage() {
		if(phase==1)
		return image;
		else
		return image2;
	}

	@Override
	public Point getLocation() {
		return location;
	}

	@Override
	public Point getCenter() {
		Point center = new Point();
		int x= (int) (location.getX()+image.getWidth(null)/2);
		int y=(int) (location.getY()+image.getHeight(null)/2);
		center.setLocation(x, y);
		return center;
	}

	@Override
	public int getWidth() {
		return image.getWidth(null);
	}

	@Override
	public int getHeight() {
		return image.getHeight(null);
	}

	@Override
	public int getDirection() {
		return Trig.getAngleInDegrees(location, Computer.Location);
	}

	@Override
	public Point getNextMove() {
		Point nextMove=new Point();
		angleInDegrees=getDirection();
		nextMove=Trig.getNextMoveAtAngle(location, angleInDegrees, velocity);
		return nextMove;
	}

	@Override
	public void setLocationAfterMovement() {
		location=getNextMove();
		
	}

	@Override
	public Rectangle getRect() {
		int x = (int) location.getX();
		int y = (int) location.getY();
		int width = getWidth();
		int height = getHeight();
		Rectangle monsterRect = new Rectangle(x, y, width, height);

		return monsterRect;
	}

/*	@Override
	public Coin[] getLoot() {
		double coinRandom = Math.random();
		double powerUpRandom = Math.random();
		givesPowerup=false;
		int numberCoins;
		numberCoins=(int) (minCoinsPerKill+coinRandom*(maxCoinsPerKill+2-minCoinsPerKill)-.005);
		if(powerUpRandom<=POWER_UP_CHANCE)
			{
				numberCoins=0;
				givesPowerup=true;
			}
		Coin[] loot= new Coin[numberCoins];

		int minX=(int) getLocation().getX();
		int minY=(int) getLocation().getY();
		int maxX=(int) getLocation().getX()+getWidth();
		int maxY=(int) getLocation().getY()+getHeight();
		
		Point p = new Point();
		Point p2 = new Point();
		Point p3 = new Point();
		Point p4 = new Point();
			switch(numberCoins)
			{	case 0: givesPowerup=true;
				break;
				
				case 1: loot[0] = new Coin(getCenter());
				break;
			
				case 2:	p.setLocation(minX,minY);
				loot[0] = new Coin(p);
				p2.setLocation(maxX-Coin.IMAGE.getWidth(null),minY);
				loot[1] = new Coin(p2);
				break;
				
				case 3:	p.setLocation(minX,minY);
				loot[0] = new Coin(p);
				p2.setLocation(maxX-Coin.IMAGE.getWidth(null),minY);
				loot[1] = new Coin(p2);
				p3.setLocation(minX+getWidth()/2-Coin.IMAGE.getWidth(null)/2, maxY-getHeight()/2);
				loot[2]= new Coin(p3);
				break;
				
				case 4: p.setLocation(minX,minY);
				loot[0] = new Coin(p);
				p2.setLocation(maxX-Coin.IMAGE.getWidth(null),minY);
				loot[1] = new Coin(p2);
				p3.setLocation(minX, maxY-getHeight()/2);
				loot[2]= new Coin(p3);
				p4.setLocation(maxX-Coin.IMAGE.getWidth(null), maxY-getHeight()/2);
				loot[3]= new Coin(p4);
				break;
				default:  
					for(int n=1; n<=numberCoins; n++)
					{
						loot[n-1] = new Coin(getCenter());
					}
				break;
			}

		return loot;
	}*/
	public void  getChangeFactor()
	{
		
	}
	@Override
	public boolean hasPowerUp()
	{
		return givesPowerup;
	}
	@Override
	public int getPowerUp() {
		if(givesPowerup=true)
		{
		double random=Math.random();
		return (int) (random*NUMBER_OF_POWERUPS-.005);
		}
		else return 0;
	}

	public int getDamage()
	{
		return damage;
	}
	public int getHP()
	{
		return HP;
	}
	
	public int getMaxHP()
	{
		return maxHP;
	}
	
	public void takeDamage(int damage)
	{
		HP-=damage;
	}
	
	public boolean isDead()
	{
		if (HP<=0)
			return true;
		else return false;
	}
	public void phaseShift()
	{
		count++;
		getChangeFactor();
		if(count%clockmax==0)
			phase++;
		if (phase>phasemax)
			phase=1;
	}
	@Override
	public void setVelocity(int i) {
		velocity=i;
		
	}
	@Override
	public void setHealth(int i)
	{
		HP=i;
	}
	
}
