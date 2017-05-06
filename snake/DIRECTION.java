package snake;

public enum DIRECTION {

	UP(0, -10), 
	DOWN(0, 10), 
	LEFT(-10, 0), 
	RIGHT(10, 0);
	
	private int velX;
	private int velY;
	
	private DIRECTION(int velX, int velY) {
		this.velX = velX;
		this.velY = velY;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}
	
}
