package Frame;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
public class GameFrame extends JFrame {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(540,720);
	private static final long serialVersionUID = 1L;
public GameFrame(){
	this.setSize(DEFAULT_SIZE);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.setResizable(false);
}
public static Point getCenter() {
	Point center = new Point();
	int x = (int) (GameFrame.DEFAULT_SIZE.getWidth() / 2);
	int y = (int) (GameFrame.DEFAULT_SIZE.getHeight() / 2);
	center.setLocation(x, y);
	return center;
}
}
