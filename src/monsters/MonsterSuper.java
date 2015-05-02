package monsters;
import gameObject.Computer;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

import physics.Trig;

import Frame.GameFrame;


public class MonsterSuper implements MonsterType {
	
	public static final String DEFAULT_IMAGE_LOCATION = "pic/monster.png";
	public static final Image DEFAULT_IMAGE = new ImageIcon(
			DEFAULT_IMAGE_LOCATION).getImage();
	public static final String DEFAULT_IMAGE_LOCATION2 = "pic/monster.png";
	public static final Image DEFAULT_IMAGE2 = new ImageIcon(
			DEFAULT_IMAGE_LOCATION2).getImage();
	public static final int NUMBER_OF_POWERUPS = 3;
	public static final double POWER_UP_CHANCE = 0.02;
	public static final int HEALTH = 1;
	public static final int GHOST = 2;
	public static final int CANNON = 3;
	public int Score = 10;
	public int maxCoinsPerKill = 4;
	public int minCoinsPerKill = 1;
	protected Image image;
	protected Image image2;
	protected Dimension dimensions;
	protected Point location;
	protected int angleInDegrees;
	public double velocity = 1.0;
	protected int damage = 1;
	protected int count;
	protected int phase = 1;
	protected int clockmax = 20;
	protected int phasemax = 2;;
	public int maxHP = 1;
	public int HP = maxHP;
	public boolean givesPowerup;
	public MonsterSuper(Point startingPoint) {
		image = DEFAULT_IMAGE;
		image2 = DEFAULT_IMAGE;
		location = startingPoint;
		count = 0;
		givesPowerup = false;
	}
	public static Point getRandomSpawnLocation() {
		Point location = new Point();
		int x;
		int y;
		int maxY = (int) (GameFrame.DEFAULT_SIZE.getHeight()
				- DEFAULT_IMAGE.getHeight(null) - 20);
		int minY = 0;
		int maxX = (int) (GameFrame.DEFAULT_SIZE.getWidth()
				- DEFAULT_IMAGE.getWidth(null) - 60);
		int minX = 0;
		double random = Math.random();
		double random2 = Math.random();
		if (random <= 0.25) {
			x = (int) (random2 * (double) maxX);
			y = maxY;
		} else if (random <= .5) {
			x = (int) (random2 * maxX);
			y = minY;
		} else if (random <= .75) {
			x = maxX;
			y = (int) (random2 * maxY);
		} else {
			x = minX;
			y = (int) (random2 * maxY);
		}
		location.setLocation(x, 70);
		return location;
	}
	@Override
	public Image getImage() {
		if (phase == 1)
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
		int x = (int) (location.getX() + image.getWidth(null) / 2);
		int y = (int) (location.getY() + image.getHeight(null) / 2);
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
		Point nextMove = new Point();
		angleInDegrees = getDirection();
		nextMove = Trig.getNextMoveAtAngle(location, angleInDegrees, velocity);
		return nextMove;
	}
	@Override
	public void setLocationAfterMovement() {
		location = getNextMove();
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
	public boolean isOutOfBounds() {
		boolean outOfBounds = false;
		{
			int x = (int) location.getX();
			int y = (int) location.getY();
			if (x > GameFrame.DEFAULT_SIZE.getWidth()
					- DEFAULT_IMAGE.getWidth(null) - 50
					|| x <= 0)
				outOfBounds = true;
			if (y > GameFrame.DEFAULT_SIZE.getHeight()
					- DEFAULT_IMAGE.getHeight(null) - 50
					|| y <= 0)
				outOfBounds = true;
			return outOfBounds;
		}
	}
	@Override
	public boolean isAtBottom() {
		boolean atBase = false;
		int y = (int) location.getY();
		if (y > GameFrame.DEFAULT_SIZE.getHeight()
				- DEFAULT_IMAGE.getHeight(null))
			atBase = true;
		return atBase;
	}
	public void getChangeFactor() {
	}
	@Override
	public boolean hasPowerUp() {
		return givesPowerup;
	}
	@Override
	public int getPowerUp() {
		if (givesPowerup = true) {
			double random = Math.random();
			return (int) (random * NUMBER_OF_POWERUPS - .005);
		} else
			return 0;
	}
	public int getDamage() {
		return damage;
	}
	public int getHP() {
		return HP;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void takeDamage(int damage) {
		HP -= damage;
	}
	public boolean isDead() {
		if (HP <= 0)
			return true;
		else
			return false;
	}
	public void phaseShift() {
		count++;
		getChangeFactor();
		if (count % clockmax == 0)
			phase++;
		if (phase > phasemax)
			phase = 1;
	}
	@Override
	public void setVelocity(int i) {
		velocity = i;
	}
	@Override
	public void setHealth(int i) {
		HP = i;
	}
	@Override
	public int getScore() {
		
		return Score;
	}
}
