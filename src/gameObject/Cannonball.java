package gameObject;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

//import org.apache.log4j.Logger;

//import Frame.DisplayFrame;

import physics.Trig;

public class Cannonball{
	//Logger logger = Logger.getLogger(Cannonball.class);

	public static final String DEFAULT_IMAGE_LOCATION = "Pic/CannonBall.jpg";

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
		this.startingPoint=centerPoint;
		startingPoint.setLocation(centerPoint.getX(), centerPoint.getY()+10);
		outOfBounds = false;
		angleInDegrees=getDirection(DestinationLocation);
		//timer = new Timer(0, this);
	}
	
	
	public Cannonball(Point centerPoint) {
		this.location = getLocationFromCenter(centerPoint);
		this.startingPoint=centerPoint;
		startingPoint.setLocation(centerPoint.getX(), centerPoint.getY()+10);
		outOfBounds = false;
		Point dest = new Point(centerPoint.x,0);					
		angleInDegrees=getDirection(dest);
		//timer = new Timer(0, this);
	}

	public int getDirection(Point mouseLocation)
	{
		return Trig.getAngleInDegrees(startingPoint, mouseLocation);
	}

	
	
	private Point getNextMove()
	{
		Point nextMove=new Point();
		nextMove=Trig.getNextMoveAtAngle(location, angleInDegrees, VELOCITY);
		return nextMove;
	}
	
	public synchronized void setLocationAfterMovement()
	{
		location=getNextMove();
	}
	
	public Point getLocation() {
		return location;
	}
	
	public Point getLocationFromCenter(Point center)
	{
		Point location= new Point();
		int x=(int) (center.getX()-IMAGE.getWidth(null)/2);
		int y=(int) (center.getY()-IMAGE.getHeight(null)/2);
		
		location.setLocation(x,y);
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
	/*
	public void checkIfOutOfBounds(){
		int maxX = (int) DisplayFrame.DEFAULT_SIZE.getWidth();
		int maxY = (int) DisplayFrame.DEFAULT_SIZE.getHeight();
		
		if(this.getRect().x > maxX || this.getRect().y > maxY || this.getRect().x+this.getRect().getWidth() < 0 || this.getRect().y +this.getRect().getHeight()< 0){
			outOfBounds = true;
		}
	}
	*/
	public boolean isOutOfBounds()
	{
		return outOfBounds;
	}

}
