package monsters;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
public interface MonsterType {
	
	public String DEFAULT_IMAGE_LOCATION = "";
	public static final int HEALTH = 1;
	public static final int GHOST = 2;
	public static final int CANNON = 3;
	public Image getImage();
	public Point getLocation();
	public Point getCenter();
	public int getWidth();
	public int getHeight();
	public int getDirection();
	Point getNextMove();
	public boolean isAtBottom();
	public void setLocationAfterMovement();
	public Rectangle getRect();
	public void phaseShift();
	public boolean hasPowerUp();
	public int getPowerUp();
	public int getDamage();
	public int getHP();
	public boolean isDead();
	public void takeDamage(int i);
	public void setVelocity(int i);
	public void setHealth(int i);
	public int getMaxHP();
	public int getScore();
}
