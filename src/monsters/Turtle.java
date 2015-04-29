package monsters;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import physics.Trig;

public class Turtle extends MonsterSuper{

	public static String DEFAULT_IMAGE_LOCATION = "gfx/turtle.png";
	public static Image DEFAULT_IMAGE = new ImageIcon(DEFAULT_IMAGE_LOCATION).getImage();
	public static String DEFAULT_IMAGE_LOCATION2 = "gfx/turtle2.png";
	public static Image DEFAULT_IMAGE2 = new ImageIcon(DEFAULT_IMAGE_LOCATION2).getImage();
	
	private int velocity2=3;
	public Turtle(Point p)
	{	super(p);
		super.maxHP=4;
		HP=maxHP;
		//super(p);
		image=DEFAULT_IMAGE2;
		image2=DEFAULT_IMAGE;
		velocity=1;
		clockmax=100;
	}
	
	@Override 
	public void getChangeFactor()
	{
		if (phase==1&&count%42==2)
			{
				phase++;
				
				count=1;
			}
	}
	@Override
	public Point getNextMove() {
		Point nextMove=new Point();
		angleInDegrees=getDirection();
		if(phase==1)
		nextMove=Trig.getNextMoveAtAngle(location, angleInDegrees, velocity2);
		else
		nextMove=Trig.getNextMoveAtAngle(location, angleInDegrees, velocity);
		return nextMove;
	}
	
}
