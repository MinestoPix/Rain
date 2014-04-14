package com.mp.rain.level.tile;

import com.mp.rain.graphics.Screen;
import com.mp.rain.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile hedge = new HedgeTile(Sprite.hedge);
	public static Tile water = new WaterTile(Sprite.water);
	public static Tile wall1 = new WallTile(Sprite.wall1);
	public static Tile wall2 = new WallTile(Sprite.wall2);
	public static Tile floor = new FloorTile(Sprite.floor);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static final int col_grass = 0xff00ff00;
	public static final int col_hedge = 0; //unused
	public static final int col_water = 0; //unused
	public static final int col_wall1 = 0xff808080;
	public static final int col_wall2 = 0xff303030;
	public static final int col_floor = 0xff442200;

	
	public Tile(Sprite sprite) {
		
		this.sprite = sprite;
		
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}
	
}
