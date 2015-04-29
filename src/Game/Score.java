package Game;

//import org.apache.log4j.Logger;

public class Score {
	//Logger logger = Logger.getLogger(Score.class);

	public static int total;

	public Score() {
		//logger.debug("score object created");
		total = 0;
	}

	public void add(int amount) {
		total += amount;
		//logger.debug("added amount " + amount + ", total = " + total);
	}

	public void remove(int amount) {
		total -= amount;
		//logger.debug("removed amount " + amount + ", total = " + total);
	}

	public int getScore() {
		return total;
	}

}
