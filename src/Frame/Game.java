package Frame;
import gameObject.Cannonball;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;

import TimerTasks.MyTimerEvents;




public class Game {

public static GameFrame frame;

public static BattleField bfield = new BattleField();
//public static ArrayList<Coin> coinList = new ArrayList<Coin>();
public static List<Cannonball> cannonballList = Collections.synchronizedList(new ArrayList<Cannonball>());
//public static ArrayList<Barrier> barrierList = new ArrayList<Barrier>();
//public static ArrayList<HealthPacket> HPPList=new ArrayList<HealthPacket>();
//public static ArrayList<GhostShip> GSList=new ArrayList<GhostShip>();
//public static ArrayList<Whirlpool>whirlpoolList=new ArrayList<Whirlpool>();
//public static ArrayList<Boss>bossList=new ArrayList<Boss>();
//public static ArrayList<Fireball>fireballList=new ArrayList<Fireball>();
//public static ArrayList<MonsterType> monsterTestList= new ArrayList<MonsterType>();


static Timer timer = new Timer();


public static int phase;
	

	public static void main(String[] args) {

		frame=new GameFrame();
		BattleField bf = new BattleField();
		frame.getContentPane().add(bf);
		frame.setVisible(true);
		startNewGame();
				
		
	}
	
	
public static void startNewGame(){
	timer.schedule(new MyTimerEvents(), 0, 15l);
}
}
