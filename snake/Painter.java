package snake;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Painter extends JComponent implements ActionListener {

	private static final long serialVersionUID = 1L;		
	private static final Painter INSTANCE = new Painter(); 		
	
	private Timer timer = new Timer(35, this);
	private SnakePart head = new SnakePart(10, 10);
	private ArrayList<SnakePart> body = new ArrayList<SnakePart>();		
	private Food food = new Food();
	private int round = 0;
	
	private Painter() { 
		body.add(head);
		timer.start();
		addKeyListener(new Action());		
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public static Painter getInstance() {
		return INSTANCE;
	}

	public void paintComponent(Graphics g) {
		Snake game = Snake.getINSTANCE();
		String hs = HighScore.getHighScore();
		String rh = HighScore.getRecordHolder();
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 590, 570);
		g.setColor(Color.RED);
		g.fillRect(food.getX(), food.getY(), 10, 10);
		g.setColor(Color.WHITE);
		g.drawString("Score: " + game.getScore() , 270, 10);
		if(game.status() == STATUS.PAUSED) {
			g.drawString("PAUSED", 263, 255);
			g.drawString("PRESS 'SPACE' TO CONTINUE", 201, 275);
			g.drawString("HIGH SCORE: " + rh + " - " + hs, 220, 295);
		}
		if(game.status() == STATUS.OVER) {
			g.drawString("GAME OVER", 265, 255);
			g.drawString("PRESS 'SPACE' TO START A NEW GAME", 188, 275);
			g.drawString("HIGH SCORE: " + rh + " - " + hs, 235, 295);
		}
		g.setColor(Color.GREEN.darker());
		for(int i = 0; i < body.size(); i++) {
			g.fillRect(body.get(i).getX(), body.get(i).getY(), 10, 10);
		}		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {		
		Snake game = Snake.getINSTANCE();
		HighScore highScore = HighScore.getInstance();
		Food currentFood = food;
		if(round == 0) {
			highScore.readHighScore();	
			highScore.readRecordHolder();
			round++;
		}
		for(int i = body.size()-1; i >= 1; i--) {							
			body.get(i).setX(body.get(i-1).getX());				
			body.get(i).setY(body.get(i-1).getY());			
		}
		body.get(0).setX(head.getX() + head.currentDirection().getVelX());
		body.get(0).setY(head.getY() + head.currentDirection().getVelY());
		
		for(int i = 1; i < body.size(); i++) {
			if(head.getX() == body.get(i).getX() && head.getY() == body.get(i).getY() && body.get(i).getX() != currentFood.getX() && body.get(i).getY() != currentFood.getY()) {
				timer.stop();
				game.changeStatus(STATUS.OVER);	
				highScore.readHighScore();
				repaint();
				return;
			}
		}
		
		if(head.getX() == -10 || head.getX() == 590 || head.getY() == -10 || head.getY() == 570) {
			timer.stop();
			game.changeStatus(STATUS.OVER);
			highScore.readHighScore();
			repaint();
			return;
		}
		
		if(head.getX() == food.getX() && head.getY() == food.getY()) {	
			body.add(new SnakePart(food.getX(), food.getY()));
			game.incrementScore();
			food = new Food();
		}	
		for(int i = 0; i < body.size(); i++) {
			if(food.getX() == body.get(i).getX() && food.getY() == body.get(i).getY()) {
				food = new Food();
			}
		}
		repaint();
	}
	
	public Timer getTimer() {
		return timer;
	}
	
	public SnakePart getHead() {
		return body.get(0);
	}
	
	public ArrayList<SnakePart> getBody() {
		return body;
	}
	
	public void setBody(ArrayList<SnakePart> body) {
		this.body = body;
	}
	
	public void setFood(Food food) {
		this.food = food;
	}
	
}
