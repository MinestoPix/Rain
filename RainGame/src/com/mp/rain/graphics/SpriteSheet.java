package com.mp.rain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public int[] pixels;

	// Tile sprites
	public static SpriteSheet grass = new SpriteSheet(
			"/textures/tiles/grass_top.png", 16);
	public static SpriteSheet flower = new SpriteSheet(
			"/textures/tiles/flower.png", 16);
	public static SpriteSheet rock = new SpriteSheet(
			"/textures/tiles/rock.png", 16);
	public static SpriteSheet hedge = new SpriteSheet(
			"/textures/tiles/hedge.png", 16);
	public static SpriteSheet water = new SpriteSheet(
			"/textures/tiles/water.png", 16);
	public static SpriteSheet wall1 = new SpriteSheet(
			"/textures/tiles/stonebrick.png", 16);
	public static SpriteSheet wall2 = new SpriteSheet(
			"/textures/tiles/stonebrick_cracked.png", 16);
	public static SpriteSheet floor = new SpriteSheet(
			"/textures/tiles/planks_oak.png", 16);

	// Player sprites
	public static SpriteSheet player = new SpriteSheet(
			"/textures/player/king_cherno.png", 128);

	public SpriteSheet(String path, int size) {

		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];

		load();

	}

	private void load() {

		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class
					.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
