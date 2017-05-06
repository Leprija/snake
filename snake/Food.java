package snake;

import java.util.Random;

public class Food {
	
	private int x;
	private int y;
	
	private Random random = new Random();
	
	public Food() {
		this.x = random.nextInt(59)*10;
		this.y = random.nextInt(57)*10;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
		
}
