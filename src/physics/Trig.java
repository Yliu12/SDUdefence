package physics;
import java.awt.Point;
public class Trig {
	public static int getAngleInDegrees(Point startingPoint, Point destination)
	{
		boolean goesToLeft=true;
		
		
		
		
		
		int destinationX=(int) destination.getX();
		int destinationY=(int) destination.getY();
		int startX= (int) startingPoint.getX();
		int startY=(int) startingPoint.getY();
		double a;
		double b;
		int angle;
		if (destination.getX()>=startingPoint.getX())
		{
			goesToLeft=false;
		}
		else
			{
			goesToLeft=true;
			destinationX=destinationX+(startX-destinationX)*2;
			destinationY=destinationY+(startY-destinationY)*2;
			}
		 a=destinationX-startX;
		 b=destinationY-startY;
		double c= Math.sqrt(a*a+b*b);
		if(goesToLeft)
		{
			a*=-1;
			angle =(int) ((Math.asin(b/c)*180/Math.PI *-1)+180)%360;
		}
		else
		{angle =(int) ((Math.asin(b/c)*180/Math.PI *-1)+360)%360;
		}
		return angle;
	}
	public static double convertToRadians(int degrees)
	{
		double angleInRadians = (degrees*2*Math.PI/360);
		return angleInRadians;
	}
	public static Point getNextMoveTowardsPoint(Point startingPoint, Point destination, int velocity)
	{
		if (startingPoint==destination)
			return startingPoint;
		else
		{
			Point nextMove= new Point();
			int angleInDegrees =getAngleInDegrees(startingPoint, destination);
			double angleInRadians = convertToRadians(angleInDegrees);
			double x=Math.cos(angleInRadians)*velocity;
			double y= -1*Math.sin(angleInRadians)*velocity;
			nextMove.setLocation(x, y);
			nextMove.setLocation(startingPoint.getX() + x, startingPoint.getY()+y);
			return nextMove;
		}
	}
	public static Point getNextMoveAtAngle(Point startingPoint, int angleInDegrees, double velocity)
	{
			if(velocity==0.0)
			{
				return startingPoint;
			}
			Point nextMove= new Point();
			double angleInRadians = convertToRadians(angleInDegrees);
			double x=Math.cos(angleInRadians)*velocity;
			double y= -1*Math.sin(angleInRadians)*velocity;
			nextMove.setLocation(x, y);
			nextMove.setLocation(startingPoint.getX() + x, startingPoint.getY()+y);
			return nextMove;
	}
}
