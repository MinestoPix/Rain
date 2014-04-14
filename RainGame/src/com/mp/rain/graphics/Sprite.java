package com.mp.rain.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	// Tile sprites
	public static Sprite grass = new Sprite(16, SpriteSheet.grass);
	public static Sprite hedge = new Sprite(16, SpriteSheet.hedge);
	public static Sprite water = new Sprite(16, SpriteSheet.water);
	public static Sprite wall1 = new Sprite(16, SpriteSheet.wall1);
	public static Sprite wall2 = new Sprite(16, SpriteSheet.wall2);
	public static Sprite floor = new Sprite(16, SpriteSheet.floor);
	public static Sprite flower = new Sprite(16, SpriteSheet.flower);
	public static Sprite rock = new Sprite(16, SpriteSheet.rock);
	public static Sprite voidSprite = new Sprite(16, 0x0000ff);
	
	// Player sprites
	public static Sprite player_forward = new Sprite(32, 0, 0, SpriteSheet.player);
	public static Sprite player_back = new Sprite(32, 2, 0, SpriteSheet.player);
	public static Sprite player_side = new Sprite(32, 1, 0, SpriteSheet.player);
	
	public static Sprite player_forward_1 = new Sprite(32, 0, 1, SpriteSheet.player);
	public static Sprite player_forward_2 = new Sprite(32, 0, 2, SpriteSheet.player);
	
	public static Sprite player_side_1 = new Sprite(32, 1, 1, SpriteSheet.player);
	public static Sprite player_side_2 = new Sprite(32, 1, 2, SpriteSheet.player);
	
	public static Sprite player_back_1 = new Sprite(32, 2, 1, SpriteSheet.player);
	public static Sprite player_back_2 = new Sprite(32, 2, 2, SpriteSheet.player);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		
		load();
		
	}
	
	public Sprite(int size, SpriteSheet sheet) {
		
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = 0;
		this.y = 0;
		this.sheet = sheet;
		
		load();
		
	}
	
	public Sprite(int size, int colour) {
		
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
		
	}
	
	private void setColour(int colour) {
		
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}
		
	}
	
	private void load() {
		
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
				
			}
		}
	}
	
}
