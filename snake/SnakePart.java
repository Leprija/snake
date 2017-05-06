package snake;

public class SnakePart {

	private int x;
	private int y;
	
	private DIRECTION currentDirection = DIRECTION.DOWN;
	
	public SnakePart(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public DIRECTION currentDirection() {
		return currentDirection;
	}
	
	public void changeDirection(DIRECTION direction) {
		currentDirection = direction;
	}
	
}