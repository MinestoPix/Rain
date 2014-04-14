package com.mp.rain.level.tile;

import com.mp.rain.graphics.Screen;
import com.mp.rain.graphics.Sprite;

public class FloorTile extends Tile {
	
	public FloorTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		
		screen.renderTile(x << 4, y << 4, this);
		
	}
	
}
