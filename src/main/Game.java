package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import graficos.ImageResizer;

import graficos.Spritesheet;

import som.Sound;


public class Game extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	// Janela
	public static JFrame frame;
	public static final int WIDTH = 190;
	public static final int HEIGHT = 108;
	public final static int TILE_SIZE = 32;
	public static int SCALE = 1;
	// Thread1
	private static boolean isRunning;
	public static Thread thread;
	// Render
	public static BufferedImage image;
	public static Spritesheet spritesheet;
	public static Random rand;
	public static String estado = "Game";
	static Game game;
	public static int frames;
	public static BufferedImage background;
	

	public static void iniciar() {
		
	
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Agrupamento.Agrupar();
	}

	public Game() {
		Game.rand = new Random();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		// Inicializando objetos.
	
		
		iniciar();
	}

	public void initFrame() {
		frame = new JFrame("IA_Agrupamento");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
	//	spritesheet = new Spritesheet("/spritesheet.png");

		// Icone Mouse
		// Toolkit toolkit = Toolkit.getDefaultToolkit();
		// Cursor c = toolkit.createCustomCursor(icon, new Point(0, 0), "img");
		// frame.setCursor(c);
		// frame.setIconImage(icon);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void autoScale() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		int x = WIDTH * SCALE;
		int y = HEIGHT * SCALE;
		while (x < width && y < height) {
			SCALE++;
			x = WIDTH * SCALE;
			y = HEIGHT * SCALE;
		}
		SCALE--;
	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		autoScale();
		Sound.fundo.play();
	//	 SCALE = 5;
		System.out.println("SCALE: "+SCALE);
		game = new Game();
		game.start();
	}

	public synchronized void start() throws InterruptedException {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public static synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void tick() {
		
		
	}

	int load_frames = 0;
	boolean ft = true;

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = image.getGraphics();
		
		g.dispose();
		g = bs.getDrawGraphics();

		g.setColor(new Color(0, 0, 0));
		// g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		g.drawImage(background, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		
		bs.show();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		frames = 0;
		double timer = System.currentTimeMillis();
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if (System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;
			}
		}
		stop();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}