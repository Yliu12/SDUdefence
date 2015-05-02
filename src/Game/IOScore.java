package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class IOScore {


	public static String FileLocation = "Score.txt";
	public static ArrayList<Integer> ScoreList = new ArrayList<Integer>();
	
	
	public IOScore(){
		
	}
	public static ArrayList<Integer> readScore(){
		
		try {
			ScoreList = new ArrayList<Integer>();
			BufferedReader br = new BufferedReader (new FileReader(FileLocation));
			String str1="";
			while ((str1=br.readLine()) != null ){
				
				ScoreList.add(Integer.parseInt(str1));
				
				
			}
			br.close();
		} catch (Exception e) {
			//input again;
			e.printStackTrace();
		} 
		
		
		return ScoreList;
		
	}
	
	public boolean SetScoresOnEndPanel(){
		
		
		
	return false;
	}
	public static void WriteScore(int score) {
		// TODO Auto-generated method stub
		
	    try {
					
					FileWriter writer = new FileWriter("Score.txt", true);
					writer.write("\n"+score);
					writer.close();
					} catch (Exception e) {
					e.printStackTrace();
					}
					
		
		
		
		
	}
	
}
