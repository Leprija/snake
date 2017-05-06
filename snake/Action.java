package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Action implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent ke) {
		int pressedKey = ke.getKeyCode();
		Snake game = Snake.getINSTANCE();
		SnakePart head = Painter.getInstance().getHead();
		Painter painter = Painter.getInstance();
		
		if(pressedKey == KeyEvent.VK_UP && head.currentDirection() != DIRECTION.DOWN && game.status() != STATUS.PAUSED) {
			head.changeDirection(DIRECTION.UP);
		}			
		if(pressedKey == KeyEvent.VK_DOWN && head.currentDirection() != DIRECTION.UP && game.status() != STATUS.PAUSED) {
			head.changeDirection(DIRECTION.DOWN);
		}				
		if(pressedKey == KeyEvent.VK_LEFT && head.currentDirection() != DIRECTION.RIGHT && game.status() != STATUS.PAUSED) {
			head.changeDirection(DIRECTION.LEFT);
		}				
		if(pressedKey == KeyEvent.VK_RIGHT && head.currentDirection() != DIRECTION.LEFT && game.status() != STATUS.PAUSED) {
			head.changeDirection(DIRECTION.RIGHT);
		}			
		if(pressedKey == KeyEvent.VK_SPACE) {						
			if(game.status() == STATUS.RUNNING) {
				painter.getTimer().stop();
				game.changeStatus(STATUS.PAUSED);
				painter.repaint();
				return;
			}		
			if(game.status() == STATUS.PAUSED) {
				painter.getTimer().start();
				game.changeStatus(STATUS.RUNNING);
				return;
			}		
			if(game.status() == STATUS.OVER) {
				painter.getTimer().start();
				game.changeStatus(STATUS.RUNNING);
				game.setScore(0);
				head.changeDirection(DIRECTION.DOWN);	
				head.setX(10);
				head.setY(10);
				painter.setBody(new ArrayList<SnakePart>());
				painter.getBody().add(head);
				painter.setFood(new Food());
			}
		}		
		if(pressedKey == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
