package monsters;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;





public class TestMonster extends MonsterSuper{
	//private static Logger logger=Logger.getLogger(TestMonster.class);
	
	public static String DEFAULT_IMAGE_LOCATION = "pic/monster.png";
	public static Image DEFAULT_IMAGE = new ImageIcon(DEFAULT_IMAGE_LOCATION).getImage();
	public static String DEFAULT_IMAGE_LOCATION2 = "pic/monster.png";
	public static Image DEFAULT_IMAGE2 = new ImageIcon(DEFAULT_IMAGE_LOCATION2).getImage();
	public static String DEFAULT_IMAGE_LOCATION3 = "pic/monster.png";
	public static Image DEFAULT_IMAGE3 = new ImageIcon(DEFAULT_IMAGE_LOCATION3).getImage();
	Image image3; 
	
	public TestMonster(Point startingPoint) {
		super(startingPoint);
		super.maxHP=3;
		HP=maxHP;
		super.minCoinsPerKill=1;
		super.maxCoinsPerKill=3;
		super.image=DEFAULT_IMAGE;
		super.image2=DEFAULT_IMAGE2;
		image3=DEFAULT_IMAGE3;
		super.clockmax=50;
		super.phasemax=3;
	}

	@Override
	public int getDirection() {
		return super.getDirection();
	}

	@Override
	public Point getNextMove() {
		return super.getNextMove();
	}


	@Override
	public int getPowerUp() {
		return super.getPowerUp();
	}
	
	@Override
	public Image getImage() {
		if(HP>=3)
		return image;
		else if(HP>=2)
		return image2;
		else
		return image3;
	}
	
	@Override
	public int getDamage()
	{
		//logger.info("ada");
		return 1;
	}
}
