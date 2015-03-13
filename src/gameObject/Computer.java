

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

import javax.swing.ImageIcon;

public class Computer {
	
	public static Image 	ComputerImg = new ImageIcon("pic/Computer.jpg").getImage();

	public static Point Location = new Point(200,400);
	public static int Xmove = 0;
	public static int Ymove = 0;
	

	
	
	
public Computer(){

	
}
	
public  static Dimension getDimension(){
	Dimension shipDimensions = new Dimension();
	double width = ComputerImg.getWidth(null);
	double height = ComputerImg.getHeight(null);

	shipDimensions.setSize(width, height);
	return shipDimensions;
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

public static Point getLocationAfterMovement() {
	// TODO Auto-generated method stub
	double newLocationX = Location.getX();
	double newLocationY = Location.getY();
	Point p = new Point();
	int maxX = 400;
	int maxY = 600;
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
	System.out.print(newX+""+newY+""+p.toString());;
	Xmove = 0;
	Ymove = 0;
	
	return p;
	
	
	
	
}

public static void setLocationAfterMovement() {

		Location = getLocationAfterMovement();


	
}





	
}
