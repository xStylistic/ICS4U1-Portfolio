package com.bonny.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.bonny.entities.Asteroid;
import com.bonny.entities.Bullet;
import com.bonny.entities.FlyingSaucer;
import com.bonny.entities.Particle;
import com.bonny.entities.Player;
import com.bonny.main.Game;
import com.bonny.managers.GameKeys;
import com.bonny.managers.GameScreenManager;

import java.util.ArrayList;

public class PlayScreen extends GameScreen {

	private SpriteBatch sb;
	private ShapeRenderer sr;

	private FreeTypeFontGenerator fontGen;
	private FreeTypeFontGenerator.FreeTypeFontParameter fontParam;
	private BitmapFont font;

	private Player livesDisplay;
	private Player player;
	private ArrayList<com.bonny.entities.Bullet> bullets;
	private ArrayList<Asteroid> asteroids;
	private ArrayList<Particle> particles;
	private ArrayList<Bullet> enemyBullets;
	private FlyingSaucer flyingSaucer;
	
	private float fsTimer;
	private float fsTime;

	private int level;
	private int totalAsteroids;
	private int numAsteroidsLeft;

	public PlayScreen(GameScreenManager gsm) {

		super(gsm);

	}

	public void initialize() {

		sb = new SpriteBatch();
		sr = new ShapeRenderer();

		fontGen = new FreeTypeFontGenerator(Gdx.files.internal("Bubble Pixel.TTF"));
		fontParam = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParam.size = 22;
		fontParam.color = Color.WHITE;
		font = fontGen.generateFont(fontParam);

		bullets = new ArrayList<com.bonny.entities.Bullet>();

		player = new Player(bullets);

		asteroids = new ArrayList<Asteroid>();

		particles = new ArrayList<Particle>();

		level = 1;
		spawnAsteroids();

		livesDisplay = new Player(null);

		fsTimer = 0;
		fsTime = 10;
		enemyBullets = new ArrayList<Bullet>();

	}

	private void createParticles(float x, float y) {

		for (int i = 0; i < 6; i++) {

			particles.add(new Particle(x, y));

		}

	}

	private void spawnAsteroids() {

		asteroids.clear();

		int numToSpawn = 4 + level - 1;
		totalAsteroids = numToSpawn * 7;
		numAsteroidsLeft = totalAsteroids;

		for (int i = 0; i < numToSpawn; i++) {

			float x = MathUtils.random(Game.WIDTH);
			float y = MathUtils.random(Game.HEIGHT);

			float dx = x - player.getX();
			float dy = y = player.getY();
			float distance = (float) Math.sqrt(dx * dx + dy * dy);

			// spawns the player away from the asteroids
			while (distance < 300) {

				x = MathUtils.random(Game.WIDTH);
				y = MathUtils.random(Game.HEIGHT);

				dx = x - player.getX();
				dy = y = player.getY();
				distance = (float) Math.sqrt(dx * dx + dy * dy);

			}

			asteroids.add(new Asteroid(x, y, Asteroid.LARGE));

		}

	}

	private void splitAsteroids(Asteroid a) {

		createParticles(a.getX(), a.getY());

		numAsteroidsLeft--;

		if (a.getType() == Asteroid.LARGE) {

			asteroids.add(new Asteroid(a.getX(), a.getY(), Asteroid.MEDIUM));
			asteroids.add(new Asteroid(a.getX(), a.getY(), Asteroid.MEDIUM));

		}

		if (a.getType() == Asteroid.MEDIUM) {

			asteroids.add(new Asteroid(a.getX(), a.getY(), Asteroid.SMALL));
			asteroids.add(new Asteroid(a.getX(), a.getY(), Asteroid.SMALL));

		}

	}

	private void checkCollisions() {

		// player hit asteroid collision
		if (!player.isHit()) {

			for (int i = 0; i < asteroids.size(); i++) {

				Asteroid a = asteroids.get(i);

				if (a.intersects(player)) {

					player.hit();
					asteroids.remove(i);
					i--;

					splitAsteroids(a);
					break;

				}

			}

		}

		// bullet hit asteroid collision
		for (int i = 0; i < bullets.size(); i++) {

			Bullet b = bullets.get(i);
			for (int j = 0; j < asteroids.size(); j++) {

				Asteroid a = asteroids.get(j);

				if (a.contains(b.getX(), b.getY())) {

					bullets.remove(i);
					i--;
					asteroids.remove(j);
					j--;

					splitAsteroids(a);

					// increase score
					player.increaseScore(a.getScore());

					break;

				}

			}

		}

		// player hit flying saucer collision
		if (flyingSaucer != null) {
			
			if (player.intersects(flyingSaucer)) {
				
				player.hit();
				createParticles(player.getX(), player.getY());
				createParticles(flyingSaucer.getX(), flyingSaucer.getY());
				flyingSaucer = null;
				
			}
			
		}

		// bullet hit flying saucer collision
		if (flyingSaucer != null) {
			
			for (int i = 0; i < bullets.size(); i++) {
				Bullet b = bullets.get(i);
				if (flyingSaucer.contains(b.getX(), b.getY())) {
					
					bullets.remove(i);
					i--;
					createParticles(flyingSaucer.getX(), flyingSaucer.getY());
					player.increaseScore(flyingSaucer.getScore());
					flyingSaucer = null;
					
					break;
					
				}
				
			}
			
		}

		// player hit enemy bullets collision
		if (!player.isHit()) {
			
			for (int i = 0; i < enemyBullets.size(); i++) {
				
				Bullet b = enemyBullets.get(i);
				
				if (player.contains(b.getX(), b.getY())) {
					
					player.hit();
					enemyBullets.remove(i);
					i--;
					
					break;
					
				}
				
			}
			
		}

		// flying saucer hit asteroid collision
		if (flyingSaucer != null) {
			
			for (int i = 0; i < asteroids.size(); i++) {
				
				Asteroid a = asteroids.get(i);
				
				if (a.intersects(flyingSaucer)) {
					
					asteroids.remove(i);
					i--;
					splitAsteroids(a);
					createParticles(a.getX(), a.getY());
					createParticles(flyingSaucer.getX(), flyingSaucer.getY());
					flyingSaucer = null;
					
					break;
					
				}
				
			}
			
		}

		// asteroid hit enemy bullet collision
		for (int i = 0; i < enemyBullets.size(); i++) {
			
			Bullet b = enemyBullets.get(i);
			
			for (int j = 0; j < asteroids.size(); j++) {
				
				Asteroid a = asteroids.get(j);
				
				if (a.contains(b.getX(), b.getY())) {
					
					asteroids.remove(j);
					j--;
					splitAsteroids(a);
					enemyBullets.remove(i);
					i--;
					createParticles(a.getX(), a.getY());
					
					break;
					
				}
				
			}
			
		}

	}

	public void update(float deltaTime) {

		// get user input
		handleInput();

		// next level
		if (asteroids.size() == 0) {

			level++;
			spawnAsteroids();

		}

		// update player
		player.update(deltaTime);

		// respawns player
		if (player.isDead()) {

			// if player has no lives, game is over
			if (player.getLives() == 0) {

				gsm.setScreen(GameScreenManager.GAMEOVER);

			}

			player.reset();
			player.loseLife();

			return;

		}

		// update player bullets
		for (int i = 0; i < bullets.size(); i++) {

			bullets.get(i).update(deltaTime);

			if (bullets.get(i).shouldRemove()) {

				bullets.remove(i);
				i--;

			}
		}

		// update flying saucer
		if (flyingSaucer == null) {

			fsTimer += deltaTime;

			if (fsTimer >= fsTime) {

				fsTimer = 0;

				int type = MathUtils.random() < 0.5 ? FlyingSaucer.SMALL : FlyingSaucer.LARGE;
				int direction = MathUtils.random() < 0.5 ? FlyingSaucer.RIGHT : FlyingSaucer.LEFT;

				flyingSaucer = new FlyingSaucer(type, direction, player, enemyBullets);

			}

		}

		// if there is a flying saucer already
		else {

			flyingSaucer.update(deltaTime);

			if (flyingSaucer.shouldRemove()) {

				flyingSaucer = null;

			}

		}

		// update flying saucer bullets
		for (int i = 0; i < enemyBullets.size(); i++) {

			enemyBullets.get(i).update(deltaTime);

			if (enemyBullets.get(i).shouldRemove()) {

				enemyBullets.remove(i);
				i--;

			}

		}

		// update particles
		for (int i = 0; i < particles.size(); i++) {

			particles.get(i).update(deltaTime);

			if (particles.get(i).shouldRemove()) {

				particles.remove(i);
				i--;

			}

		}

		// update asteroids
		for (int i = 0; i < asteroids.size(); i++) {

			asteroids.get(i).update(deltaTime);

			if (asteroids.get(i).shouldRemove()) {

				asteroids.remove(i);
				i--;

			}

		}

		// check collisions
		checkCollisions();

	}

	public void draw() {

		// draw player
		player.draw(sr);

		// draw bullets
		for (int i = 0; i < bullets.size(); i++) {

			bullets.get(i).draw(sr);

		}

		// draw asteroids
		for (int i = 0; i < asteroids.size(); i++) {

			asteroids.get(i).draw(sr);

		}

		// draw particles
		for (int i = 0; i < particles.size(); i++) {

			particles.get(i).draw(sr);

		}

		// draw score
		sb.begin();
		font.draw(sb, String.valueOf(player.getScore()), 30, 455);
		sb.end();

		// draw lives
		for (int i = 0; i < player.getLives(); i++) {

			livesDisplay.setPosition(35 + i * 14, 410);
			livesDisplay.draw(sr);

		}

		// draw flying saucer
		if (flyingSaucer != null) {

			flyingSaucer.draw(sr);

		}

		// draw flying saucer bullets
		for (int i = 0; i < enemyBullets.size(); i++) {

			enemyBullets.get(i).draw(sr);

		}

	}

	public void handleInput() {

		if (!player.isHit()) {

			player.setLeft(GameKeys.isDown(GameKeys.LEFT));
			player.setRight(GameKeys.isDown(GameKeys.RIGHT));
			player.setUp(GameKeys.isDown(GameKeys.UP));

			if (GameKeys.isPressed(GameKeys.SPACE)) {

				player.shoot();

			}

		}

	}

	public void dispose() {

		sb.dispose();
		sr.dispose();
		font.dispose();

	}

}
