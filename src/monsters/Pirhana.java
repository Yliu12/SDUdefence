package monsters;

import gameObject.Computer;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import physics.Trig;


public class Pirhana extends MonsterSuper{
	//Logger logger = Logger.getLogger(Pirhana.class);

	public static String DEFAULT_IMAGE_LOCATION = "pic/PiratePirhana1.png";
	public static Image DEFAULT_IMAGE = new ImageIcon(DEFAULT_IMAGE_LOCATION).getImage();
	public static String DEFAULT_IMAGE_LOCATION2 = "pic/PiratePirhana2.png";
	public static Image DEFAULT_IMAGE2 = new ImageIcon(DEFAULT_IMAGE_LOCATION2).getImage();
 private int vertical = 270;
	
	public Pirhana(Point startingPoint) {
		super(startingPoint);
		super.image=DEFAULT_IMAGE;
		super.image2=DEFAULT_IMAGE2;
		super.damage=3;
		super.velocity=2;
		super.minCoinsPerKill=2;
		super.maxCoinsPerKill=4;
		super.maxHP=1;
		super.HP=maxHP;
	}

	@Override
	public int getDirection() {
		return Trig.getAngleInDegrees(location, new Point(Computer.Location.x,1000));
	}

	@Override
	public Point getNextMove() {
		
		Point nextMove=new Point();
		angleInDegrees=getDirection();
		nextMove=Trig.getNextMoveAtAngle(location, vertical, velocity);
		return nextMove;
		


	}

	

	@Override
	public int getPowerUp() {
		return super.getPowerUp();
	}
	
}
