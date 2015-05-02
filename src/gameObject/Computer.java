

/*
 * 
 * Tried to re constructor the program and move the computer under command
 * Today Leftover
 * 
 * GetLocation()finished, continue on setLocation;
 * then MyTimerEvent();
 * 99%Satisfied with today's work;
 * 
 * 
 * 
 */





package gameObject;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;



import Frame.GameFrame;


public class Computer {
	
	public static String imgLocation = "pic/debugger3.png";
	public static Image ComputerImg = new ImageIcon(imgLocation).getImage();

	public static Point Location = new Point(200,800);
	public static int Xmove = 0;
	public static int Ymove = 0;
	

	public static final int DIRECTION_CODE_UP = 1;
	public static final int START_HP = 7;
	public static final int DIRECTION_CODE_DOWN = 2;
	public static final int DIRECTION_CODE_LEFT = 3;
	public static final int DIRECTION_CODE_RIGHT = 4;
	public static double MIN_SPEED = 3;
	public static double MAX_SPEED = 4;
	public static double xvelocity;
	public static double yvelocity;
	public static double xfloatcount;
	public static double yfloatcount;
	public static final double BUMP_FACTOR = 0;
	public static double drag = 0.98;

	private static boolean gettingComputer = false;

	public static int HitTimesOfMonsters;

	public static int currentHP = START_HP;
	
	
public Computer(){

	
}
	
public static void ChangeImg(String loc){
	ComputerImg = new ImageIcon(loc).getImage();
	}
public  static Dimension getDimension(){
	Dimension d = new Dimension();
	double width = ComputerImg.getWidth(null);
	double height = ComputerImg.getHeight(null);

	d.setSize(width, height);
	return d;
}



public static Point getLocation(){
	return Location;
}
public  static void setLocation(Point newLocation){
	
	Location = getLocationAfterMovement();
}

public static Image getImage() {

	return ComputerImg;
}

public static void nudge(int directionCode) {
	if (directionCode == DIRECTION_CODE_UP) {
		if (yvelocity <= 0) {
			yvelocity -= BUMP_FACTOR;
		} else {
			yvelocity = -1 * BUMP_FACTOR;
		}
		yfloatcount = 0;
	} else if (directionCode == DIRECTION_CODE_DOWN) {
		if (yvelocity >= 0) {
			yvelocity += BUMP_FACTOR;
		} else {
			yvelocity = BUMP_FACTOR;
		}
		yfloatcount = 0;
	} else if (directionCode == DIRECTION_CODE_LEFT) {

		if (xvelocity <= BUMP_FACTOR) {
			xvelocity -= BUMP_FACTOR;
		} else {
			xvelocity = -1 * BUMP_FACTOR;
		}
		xfloatcount = 0;
	} else if (directionCode == DIRECTION_CODE_RIGHT) {

		if (xvelocity >= BUMP_FACTOR)

		{
			xvelocity += BUMP_FACTOR;
		} else {
			xvelocity = BUMP_FACTOR;
		}
		xfloatcount = 0;
	}

	if (directionCode == DIRECTION_CODE_LEFT
			&& Math.abs(xvelocity) < MIN_SPEED) {
		xvelocity = -1 * MIN_SPEED;
	}
	if (directionCode == DIRECTION_CODE_RIGHT
			&& Math.abs(xvelocity) < MIN_SPEED) {

		xvelocity = MIN_SPEED;
	}
	if (directionCode == DIRECTION_CODE_DOWN
			&& Math.abs(yvelocity) < MIN_SPEED) {
		yvelocity = MIN_SPEED;

	}
	if (directionCode == DIRECTION_CODE_UP
			&& Math.abs(yvelocity) < MIN_SPEED) {
		yvelocity = -1 * MIN_SPEED;
	}
	if (directionCode == DIRECTION_CODE_LEFT
			&& Math.abs(xvelocity) > MAX_SPEED) {
		xvelocity = -1 * MAX_SPEED;
	}
	if (directionCode == DIRECTION_CODE_RIGHT
			&& Math.abs(xvelocity) > MAX_SPEED) {

		xvelocity = MAX_SPEED;
	}
	if (directionCode == DIRECTION_CODE_DOWN
			&& Math.abs(yvelocity) > MAX_SPEED) {
		yvelocity = MAX_SPEED;

	}
	if (directionCode == DIRECTION_CODE_UP
			&& Math.abs(yvelocity) > MAX_SPEED) {
		yvelocity = -1 * MAX_SPEED;
	}
	

}



public static Point getLocationAfterMovement() {
	

	
	double newLocationX = Location.x;
	double newLocationY = Location.y;
	int maxX = (int) GameFrame.DEFAULT_SIZE.getWidth()-getDimension().width-10;
	int maxY = (int) GameFrame.DEFAULT_SIZE.getHeight()
			- getDimension().height-30;
	int minX = 0;
	int minY = 0;

	if (xfloatcount >2)
		addXDrag();
	if (yfloatcount > 2)
		addYDrag();
	
	
	if (yvelocity > MAX_SPEED)
		yvelocity = MAX_SPEED;
	if (xvelocity > MAX_SPEED)
		xvelocity = MAX_SPEED;
	newLocationX += xvelocity;
	newLocationY += yvelocity;

	if (newLocationX > maxX) {
		newLocationX = maxX;
		xvelocity = 0;
	} else if (newLocationX < minX) {
		newLocationX = minX;
		xvelocity = 0;
	}
	if (newLocationY > maxY) {
		newLocationY = maxY;
		yvelocity = 0;
	}

	else if (newLocationY < minY) {
		newLocationY = minY;
		yvelocity = 0;
	}

	Point newLocation = new Point();
	newLocation.setLocation(newLocationX, newLocationY);

	return newLocation;

}

public static void addDrag() {
	addXDrag();
	addYDrag();
}
public static void addYDrag() {
	if (Math.abs(yvelocity) > 0.7) {

		yvelocity = yvelocity * drag;

	} else if (Math.abs(yvelocity) <= 0.7 && Math.abs(yvelocity) > .2)
		yvelocity -= Math.copySign(.1, yvelocity);
	else
		yvelocity = 0;
}



public static void addXDrag() {

	if (Math.abs(xvelocity) > 0.7) {

		xvelocity = xvelocity * drag;

	} else if (Math.abs(xvelocity) <= 0.7 && Math.abs(xvelocity) > .2)
		xvelocity -= Math.copySign(.1, xvelocity);
	else
		xvelocity = 0;
}
/*

public static Point getLocationAfterMovement() {
	// TODO Auto-generated method stub
	double newLocationX = Location.x;
	double newLocationY = Location.y;
	Point p = new Point();
	int maxX = 350;
	int maxY = 550;
	int minX = 0;
	int minY = 0;
	int newX =Location.x;
	int newY = Location.y;
	
	newX +=Xmove;
	newY +=Ymove;
	if(newX>maxX)
		newX = maxX;
	if(newY >maxY)
		newY = maxY;
	if (newX<minX)
		newX = minX;
	if(newY<minY)
		newY = minY;
	
	
	p.setLocation(newX, newY);
	//System.out.print(newX+""+newY+""+p.toString());;
	Xmove = 0;
	Ymove = 0;
	
	return p;
	
	
	
	
}
*/

public static void setLocationAfterMovement() {

		Location = getLocationAfterMovement();


	
}

public static Point getCenter() {
	
	return new Point(Location.x+20,Location.y-5);
}

public static boolean intersects(Rectangle rect) {
	// TODO Auto-generated method stub
	
	boolean flag = false;
	int x = (int) Location.getX();
	int y = (int) Location.getY();
	int width = ComputerImg.getWidth(null);
	int height = ComputerImg.getHeight(null);
	Rectangle PartOneOfComp= new Rectangle(x, y + height * 2 / 3, width,
			height * 1 / 3);
	Rectangle PartTwoOfShip = new Rectangle(x + width * 5 / 12, y,
			width / 3, height);
	Rectangle PartThreeOfShip = new Rectangle(x + width / 4,
			y + height / 3, width * 2 / 3, height * 2 / 3);
	if (PartOneOfComp.intersects(rect) || PartTwoOfShip.intersects(rect)
			|| PartThreeOfShip.intersects(rect))
		flag = true;
	return flag;

}

public static void setIfgetComputer(boolean IF) {
	gettingComputer  = IF;
}

public static boolean getIfgetComputer() {
	return gettingComputer;
}

public static void detectIFgetComputerEnd() {
	if (HitTimesOfMonsters >= 7) {
		gettingComputer = false;
	} else
		gettingComputer = true;
}

public static boolean isAlive() {
	if (currentHP > 0)
		return true;
	else {
		if (currentHP <= 0)
			
		return false;
	}
	return false;
	
}




	
}
