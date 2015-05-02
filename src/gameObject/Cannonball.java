package gameObject;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


import Frame.GameFrame;
import physics.Trig;
public class Cannonball {
	public static final String DEFAULT_IMAGE_LOCATION = "Pic/bullet.png";
	public static final Image IMAGE = new ImageIcon(DEFAULT_IMAGE_LOCATION)
			.getImage();
	public static final Dimension DIMENSIONS = new Dimension(
			IMAGE.getWidth(null), IMAGE.getHeight(null));
	public static final double VELOCITY = 10;
	private Point location;
	private Point startingPoint;
	public boolean outOfBounds = false;
	public int angleInDegrees;
	public Cannonball(Point centerPoint, Point DestinationLocation) {
		this.location = getLocationFromCenter(centerPoint);
		this.startingPoint = centerPoint;
		startingPoint.setLocation(centerPoint.getX(), centerPoint.getY() + 10);
		outOfBounds = false;
		angleInDegrees = getDirection(DestinationLocation);
	}
	public Cannonball(Point centerPoint) {
		this.location = getLocationFromCenter(centerPoint);
		this.startingPoint = centerPoint;
		startingPoint.setLocation(centerPoint.getX(), centerPoint.getY() + 10);
		outOfBounds = false;
		Point dest = new Point(centerPoint.x, 0);
		angleInDegrees = getDirection(dest);
	}
	public int getDirection(Point mouseLocation) {
		return Trig.getAngleInDegrees(startingPoint, mouseLocation);
	}
	private Point getNextMove() {
		Point nextMove = new Point();
		nextMove = Trig.getNextMoveAtAngle(location, angleInDegrees, VELOCITY);
		return nextMove;
	}
	public synchronized void setLocationAfterMovement() {
		location = getNextMove();
	}
	public Point getLocation() {
		return location;
	}
	public Point getLocationFromCenter(Point center) {
		Point location = new Point();
		int x = (int) (center.getX() - IMAGE.getWidth(null) / 2);
		int y = (int) (center.getY() - IMAGE.getHeight(null) / 2);
		location.setLocation(x, y);
		return location;
	}
	public Rectangle getRect() {
		int x = (int) location.getX();
		int y = (int) location.getY();
		int width = IMAGE.getWidth(null);
		int height = IMAGE.getWidth(null);
		Rectangle cannonRect = new Rectangle(x, y, width, height);
		return cannonRect;
	}
	public boolean isOutOfBounds() {
		int x = (int) location.getX();
		int y = (int) location.getY();
		if (x > GameFrame.DEFAULT_SIZE.getWidth() || x < -5)
			outOfBounds = true;
		if (y > GameFrame.DEFAULT_SIZE.getHeight() || y < 0)
			outOfBounds = true;
		return outOfBounds;
	}
	public boolean isatBase() {
		boolean atBase = false;
		int y = (int) location.getY();
		if (y > 950)
			atBase = true;
		return atBase;
	}
}
