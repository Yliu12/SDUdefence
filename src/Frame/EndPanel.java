package Frame;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Game.Game;
import Game.IOScore;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class EndPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public static ArrayList<JLabel> ScorelblList = new ArrayList<JLabel>();
    public ArrayList<Integer> score = new ArrayList<Integer>();
	/**
	 * Create the panel.
	 */
	public EndPanel() {
 this.setSize(GameFrame.DEFAULT_SIZE);
 score = new ArrayList<Integer>();
 setLayout(null);
 
 final JButton btnRetry = new JButton("");
 btnRetry.setIcon(new ImageIcon("pic/btnRetry.png"));
 btnRetry.setContentAreaFilled(false);
 btnRetry.setBorderPainted(false);
 btnRetry.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			 btnRetry.setBounds(208, 606, 150, 50);
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			 btnRetry.setBounds(206, 604, 150, 50);
			
		}
	});
 btnRetry.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		
 		
 		Game.startNewGame();
 	}
 });
 
 JLabel lblScore1 = new JLabel("Score 1");
 lblScore1.setFont(new Font("Tahoma", Font.PLAIN, 30));
 lblScore1.setBounds(197, 240, 159, 37);
 add(lblScore1);
 
 JLabel lblScore2 = new JLabel("Score 1");
 lblScore2.setFont(new Font("Tahoma", Font.PLAIN, 30));
 lblScore2.setBounds(197, 299, 159, 37);
 add(lblScore2);
 
 JLabel lblScore3 = new JLabel("Score 1");
 lblScore3.setFont(new Font("Tahoma", Font.PLAIN, 30));
 lblScore3.setBounds(197, 361, 159, 37);
 add(lblScore3);
 
 JLabel lblScore4 = new JLabel("Score 1");
 lblScore4.setFont(new Font("Tahoma", Font.PLAIN, 30));
 lblScore4.setBounds(197, 418, 173, 37);
 add(lblScore4);
 
 JLabel lblScore5 = new JLabel("Score 1");
 lblScore5.setFont(new Font("Tahoma", Font.PLAIN, 30));
 lblScore5.setBounds(197, 479, 159, 44);
 add(lblScore5);
 btnRetry.setBounds(206, 604, 150, 50);
 add(btnRetry);
 
 JLabel lblNewLabel = new JLabel("");
 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\YLIU12\\Desktop\\End.png"));
 lblNewLabel.setBounds(0, 0, 540, 720);
 add(lblNewLabel);
 
 
 ScorelblList.add(lblScore1);
 ScorelblList.add(lblScore2);
 ScorelblList.add(lblScore3);
 ScorelblList.add(lblScore4);
 ScorelblList.add(lblScore5);


	}
	
	public void setScore() {
		// TODO Auto-generated method stub
		
		 
		 score = IOScore.readScore();
		 
		Collections.sort(score, new Comparator<Integer>() {
			 
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				 return new Integer(o1).compareTo(o2);
			}
		    });
		
		
		
		for (int i=0;i<5;i++){
			ScorelblList.get(i).setText(score.get(score.size()-i-1).toString());
		}
	}
	
	
	
	
}
