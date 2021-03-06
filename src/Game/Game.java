	/*
	 * @author  Ying Liu @E-mail:yliu12@bsu.edu
	 * Image by Chuxi Liang 
	 * Ball State University
	 * Shandong University at Weihai
	 * 
	 * 
	 * */



package Game;
import gameObject.Cannonball;
import gameObject.Computer;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import monsters.MonsterType;
import monsters.TestMonster;
import Frame.BattleField;
import Frame.EndPanel;
import Frame.GameFrame;
import Frame.StartPanel;
import TimerTasks.SpawnTask;
import TimerTasks.StopWatch;
import TimerTasks.MyTimerEvents;
public class Game implements ActionListener{
public static GameFrame frame;
public static BattleField bfield = new BattleField();
public static List<Cannonball> cannonballList = Collections.synchronizedList(new ArrayList<Cannonball>());
public static StopWatch cannonwatch = new StopWatch();
public static int Score=0;
static Timer timer = new Timer();
public static int phase = 1;
public static ArrayList<MonsterType> monsterTestList= new ArrayList<MonsterType>();
public static TestMonster monsterTest = new TestMonster(GameFrame.getCenter());
static BattleField bf = new BattleField();
static StartPanel sp = new StartPanel();
static EndPanel ep = new EndPanel();





public static void main(String[] args){
		
		
		
		
		frame=new GameFrame();
		frame.getContentPane().add(sp);
		frame.setVisible(true);
		
	}
public static void startNewGame(){
	Score = 0;
	phase = 1;
	timer = new Timer();
	cannonwatch = new StopWatch();
	Computer.currentHP= Computer.START_HP;
	timer.schedule(new MyTimerEvents(), 0, 15l);
	timer.schedule(new SpawnTask(), 1000, 1000);
	frame.getContentPane().remove(bf);
	frame.getContentPane().remove(ep);
	frame.getContentPane().remove(sp);
	frame.validate();   
	frame.repaint();
	bf = new BattleField();
	frame.getContentPane().add(bf, 0);
	bf.requestFocusInWindow();
 }
public static void unpause(){
		phase = 1;
	frame.repaint();
}
@Override
public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("cycle")) {
	}
}
public static void gameOver() {
	phase =0;
	frame.getContentPane().remove(bf);
	ep.setScore();
	frame.getContentPane().add(ep, BorderLayout.CENTER, 0);
	frame.validate();   
	frame.repaint();
	timer.cancel();
	cannonwatch.reset();
	monsterTestList.clear();	
	cannonballList.clear();
}
}
