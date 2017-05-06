package snake;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class HighScore {
	
	private static HighScore INSTANCE = new HighScore();
	
	private static String highScore;
	private static String recordHolder;
	
	private Formatter f;
	private Scanner scan;
	private Snake game = Snake.getINSTANCE();
	
	private HighScore() {
		
	}
		
	public static String getHighScore() {
		return highScore;
	}
	
	public static void setHighScore(String newHighScore) {
		highScore = newHighScore;
	}
	
	public static String getRecordHolder() {
		return recordHolder;
	}
	
	public void readHighScore() {
		try {
			scan = new Scanner(new File("C:/Program Files/Snake/HighScore.txt")); 
			while(scan.hasNext()) {
				highScore = scan.next();
				if(game.getScore() > Integer.valueOf(highScore)) {
					setHighScore(String.valueOf(game.getScore()));
					try {
						recordHolder = JOptionPane.showInputDialog("You broke the record! Enter your name: ");
						f = new Formatter("C:/Program Files/Snake/HighScore.txt");
						f.format(String.valueOf(game.getScore()));					
						f.close();
						f = new Formatter("C:/Program Files/Snake/RecordHolder.txt");
						f.format(String.valueOf(recordHolder));					
						f.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}			
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readRecordHolder() {
		try {
			scan = new Scanner(new File("C:/Program Files/Snake/RecordHolder.txt"));
			while(scan.hasNext()) {				
				recordHolder = scan.next(); 
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static HighScore getInstance() {
		return INSTANCE;
	}

}
