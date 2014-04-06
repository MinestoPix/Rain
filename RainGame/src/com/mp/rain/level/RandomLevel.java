package com.mp.rain.level;

import java.util.Random;

public class RandomLevel extends Level {
	
	private static final Random random = new Random();
	
	public RandomLevel(int width, int height) {
		
		super(width, height);
		
	}
	
	protected void generateLevel() {
		
		int rand;
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				
				rand = random.nextInt(100);
				
				if (rand < 60) tiles[x + y * width] = 0;
				else if (rand < 80) tiles[x + y * width] = 1;
				else if (rand < 90) tiles[x + y * width] = 2;
				else if (rand < 100) tiles[x + y * width] = 3;
				else tiles[x + y * width] = random.nextInt(4);
				
			}
		}
	}
	
}
