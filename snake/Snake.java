package snake;

import java.awt.*;
import javax.swing.JFrame;

public class Snake {
	
	private static final Snake INSTANCE = new Snake();
	private int score;
	private STATUS currentStatus = STATUS.RUNNING;

	private Snake() {
		JFrame window = new JFrame("Snake");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		window.setSize(596, 597); 
		window.setResizable(false);
		window.setLocation(dim.width/2 - window.getWidth()/2, dim.height/2 - window.getHeight()/2);		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(Painter.getInstance());
		window.setVisible(true);
	}
	
	public static Snake getINSTANCE() {       
		return INSTANCE;
	}
	
	public int getScore() {
		return score;
	}
		
	public void incrementScore() {
		score++;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public STATUS status() {
		return currentStatus;
	}
	
	public void changeStatus(STATUS status) {
		currentStatus = status;
	}
	
	public static void main(String[] args) {
				
	}

}
