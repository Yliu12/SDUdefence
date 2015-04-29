package monsters;

import java.awt.Image;

import javax.swing.ImageIcon;

public class HPBar {

	public static String HP_LOCATION1 = "gfx/hp1.png";
	public static Image HP1_4 = new ImageIcon(HP_LOCATION1).getImage();
	public static String HP_LOCATION2 = "gfx/hp2.png";
	public static Image HP2_4 = new ImageIcon(HP_LOCATION2).getImage();
	public static String HP_LOCATION3 = "gfx/hp3.png";
	public static Image HP3_4 = new ImageIcon(HP_LOCATION3).getImage();
	public static String HP_LOCATION4 = "gfx/hp.png";
	public static Image HP4_4 = new ImageIcon(HP_LOCATION4).getImage();
	
	public static String HP_LOCATION1_1 = "gfx/hp1.1.png";
	public static Image HP1_1 = new ImageIcon(HP_LOCATION1_1).getImage();

	
	public static String HP_LOCATION1_2 = "gfx/hp2.1.png";
	public static Image HP1_2 = new ImageIcon(HP_LOCATION1_2).getImage();
	public static String HP_LOCATION2_2 = "gfx/hp2.2.png";
	public static Image HP2_2 = new ImageIcon(HP_LOCATION2_2).getImage();
	
	public static String HP_LOCATION1_3 = "gfx/hp3.1.png";
	public static Image HP1_3 = new ImageIcon(HP_LOCATION1_3).getImage();
	public static String HP_LOCATION2_3 = "gfx/hp3.2.png";
	public static Image HP2_3 = new ImageIcon(HP_LOCATION2_3).getImage();
	public static String HP_LOCATION3_3 = "gfx/hp3.3.png";
	public static Image HP3_3 = new ImageIcon(HP_LOCATION3_3).getImage();

	
	
	public static Image getHPBar(int HP, int maxHP)
	{
		if(maxHP==1)
		{
			return HP1_1;
		}
		else if (maxHP==2)
		{
			if(HP==1)
				return HP1_2;
			else
				return HP2_2;
			
		}
		else if(maxHP==3)
		{
			if(HP==1)
				return HP1_3;
			else if(HP==2)
				return HP2_3;
			else
				return HP3_3;
		}
		else
		{
		if(HP==1)
			return HP1_4;
		else if(HP==2)
			return HP2_4;
		else if(HP==3)
			return HP3_4;
		else
			return HP4_4;
		}
			
	}
	
	
	
	
}
