package com.mp.rain.level.tile;

import com.mp.rain.graphics.Screen;
import com.mp.rain.graphics.Sprite;

public class WaterTile extends Tile {
	
	public WaterTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		
		screen.renderTile(x << 4, y << 4, this);
		
	}
	
}
