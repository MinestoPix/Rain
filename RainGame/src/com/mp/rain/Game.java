package com.mp.rain;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.mp.rain.graphics.Screen;
import com.mp.rain.input.Keyboard;
import com.mp.rain.level.Level;
import com.mp.rain.level.RandomLevel;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "Rain";
	
	private Thread gameThread;
	private JFrame frame;
	private Keyboard key;
	private Level level;
	private boolean running = false;
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = new RandomLevel(64, 64);
		
		addKeyListener(key);
		
	}
	
	public synchronized void start() {
		
		running = true;
		
		gameThread = new Thread(this, "Display");
		gameThread.start();
		
	}
	
	public synchronized void stop() {
		
		running = false;
		
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
		// 60 ups
		final int ups = 60;
		final double ns = 1000000000 / ups;
		long lastTime = System.nanoTime();
		double delta = 0;
		
		// fps and update counter
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		
		requestFocus();
		
		while (running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				frames = 0;
				updates = 0;
			}
			
		}
		stop();
	}
	
	int x = 0, y = 0;
	
	public void update() {
		
		key.update();
		if (key.down)
			y++;
		if (key.up)
			y--;
		if (key.right)
			x++;
		if (key.left)
			x--;
		
	}
	
	public void render() {
		
		BufferStrategy bs = getBufferStrategy();
		
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		level.render(x, y, screen);
		
		for (int i = 0; i < pixels.length; i++) {
			
			pixels[i] = screen.pixels[i];
			
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		
		bs.show();
		
	}
	
	public static void main(String[] args) {
		
		Game game = new Game();
		
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
		
	}
	
}
