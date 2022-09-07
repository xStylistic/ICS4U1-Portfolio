package com.bonny.entities;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.bonny.main.Game;

public class Player extends SpaceObject {

	private final int MAX_BULLETS = 1;
	private ArrayList<Bullet> bullets;

	private float[] rocketX;
	private float[] rocketY;

	private boolean left;
	private boolean right;
	private boolean up;

	private float maxSpeed;
	private float acceleration;
	private float deceleration;
	private float acceleratingTimer;

	private boolean hit;
	private boolean dead;

	private float hitTimer;
	private float hitTime;
	private Line2D.Float[] hitLines;
	private Point2D.Float[] hitLinesVector;
	
	private int score;
	private int extraLives;

	public Player(ArrayList<Bullet> bullets) {

		this.bullets = bullets;

		// center the game
		x = Game.WIDTH / 2;
		y = Game.HEIGHT / 2;

		// set the speeds
		maxSpeed = 300;
		acceleration = 200;
		deceleration = 20;
		rotationSpeed = 3;

		// there are 4 points from the centre needed to draw the ship
		shapeX = new float[4];
		shapeY = new float[4];
		rocketX = new float[3];
		rocketY = new float[3];

		// make ship face upwards
		radians = (float) Math.PI / 2;

		hit = false;
		hitTimer = 0;
		hitTime = 2;
		
		score = 0;
		extraLives = 3;

	}

	private void setShape() {

		shapeX[0] = x + MathUtils.cos(radians) * 12;
		shapeY[0] = y + MathUtils.sin(radians) * 12;

		shapeX[1] = x + MathUtils.cos((float) (radians - 4 * Math.PI / 5)) * 12;
		shapeY[1] = y + MathUtils.sin((float) (radians - 4 * Math.PI / 5)) * 12;

		shapeX[2] = x + MathUtils.cos((float) (radians + Math.PI)) * 5;
		shapeY[2] = y + MathUtils.sin((float) (radians + Math.PI)) * 5;

		shapeX[3] = x + MathUtils.cos((float) (radians + 4 * Math.PI / 5)) * 12;
		shapeY[3] = y + MathUtils.sin((float) (radians + 4 * Math.PI / 5)) * 12;

	}

	private void setRocket() {

		rocketX[0] = x + MathUtils.cos((float) (radians - 5 * Math.PI / 6)) * 5;
		rocketY[0] = y + MathUtils.sin((float) (radians - 5 * Math.PI / 6)) * 5;

		rocketX[1] = x + MathUtils.cos((float) (radians - Math.PI)) * (8 + acceleratingTimer * 50);
		rocketY[1] = y + MathUtils.sin((float) (radians - Math.PI)) * (8 + acceleratingTimer * 50);

		rocketX[2] = x + MathUtils.cos((float) (radians + 5 * Math.PI / 6)) * 5;
		rocketY[2] = y + MathUtils.sin((float) (radians + 5 * Math.PI / 6)) * 5;

	}

	public void setLeft(boolean b) {

		left = b;
	}

	public void setRight(boolean b) {

		right = b;

	}

	public void setUp(boolean b) {

		up = b;

	}

	public boolean isHit() {

		return hit;

	}

	public boolean isDead() {

		return dead;

	}

	public void reset() {

		x = Game.WIDTH / 2;
		y = Game.HEIGHT / 2;
		setShape();
		hit = dead = false;

	}
	
	public int getScore() {
		
		return score;
		
	}
	
	public int getLives() {
		
		return extraLives;
		
	}
	
	public void loseLife() {
		
		extraLives--;
		
	}
	
	public void increaseScore(int i) {
		
		score += i;
		
	}
	
	public void setPosition(float x, float y) {
		
		super.setPosition(x, y);
		setShape();
		
	}

	public void shoot() {

		if (bullets.size() == MAX_BULLETS)

			return;

		bullets.add(new Bullet(x, y, radians));

	}

	public void hit() {

		if (hit)

			return;

		hit = true;
		dx = dy = 0;
		left = right = up = false;

		hitLines = new Line2D.Float[4];

		for (int i = 0, j = hitLines.length - 1; i < hitLines.length; j = i++) {

			hitLines[i] = new Line2D.Float(shapeX[i], shapeY[i], shapeX[j], shapeY[j]);

		}

		hitLinesVector = new Point2D.Float[4];
		hitLinesVector[0] = new Point2D.Float(MathUtils.cos((float) (radians + 1.5)), MathUtils.sin((float) (radians + 1.5)));
		hitLinesVector[1] = new Point2D.Float(MathUtils.cos((float) (radians - 1.5)), MathUtils.sin((float) (radians - 1.5)));
		hitLinesVector[2] = new Point2D.Float(MathUtils.cos((float) (radians - 2.8)), MathUtils.sin((float) (radians - 2.8)));
		hitLinesVector[3] = new Point2D.Float(MathUtils.cos((float) (radians + 2.8)), MathUtils.sin((float) (radians + 2.8)));

	}

	public void update(float deltaTime) {

		// check if ship is hit
		if (hit) {

			hitTimer += deltaTime;

			if (hitTimer > hitTime) {

				dead = true;
				hitTimer = 0;

			}

			for (int i = 0; i < hitLines.length; i++) {

				hitLines[i].setLine(hitLines[i].x1 + hitLinesVector[i].x * 10 * deltaTime,
									hitLines[i].y1 + hitLinesVector[i].y * 10 * deltaTime,
									hitLines[i].x2 + hitLinesVector[i].x * 10 * deltaTime,
									hitLines[i].y2 + hitLinesVector[i].y * 10 * deltaTime);

			}

			return;

		}

		// turning
		if (left) {

			radians += rotationSpeed * deltaTime;

		}

		else if (right) {

			radians -= rotationSpeed * deltaTime;

		}

		// accelerating
		if (up) {

			dx += MathUtils.cos(radians) * acceleration * deltaTime;
			dy += MathUtils.sin(radians) * acceleration * deltaTime;
			acceleratingTimer += deltaTime;

			if (acceleratingTimer > 0.1) {

				acceleratingTimer = 0;

			}

		} else {

			acceleratingTimer = 0;

		}

		// deceleration
		float vector = (float) Math.sqrt(dx * dx + dy * dy);

		if (vector > 0) {

			dx -= (dx / vector) * deceleration * deltaTime;
			dy -= (dy / vector) * deceleration * deltaTime;

		}

		if (vector > maxSpeed) {

			dx = (dx / vector) * maxSpeed;
			dy = (dx / vector) * maxSpeed;

		}

		// set position
		x += dx * deltaTime;
		y += dy * deltaTime;

		// set shape
		setShape();

		// set rocket
		if (up) {

			setRocket();

		}

		// wrap screen
		wrap();

	}

	public void draw(ShapeRenderer sr) {

		sr.setColor(1, 1, 1, 1);

		sr.begin(ShapeType.Line);

		// check if ship is hit, if it's hit the ship splits
		if (hit) {
			
			for (int i = 0; i < hitLines.length; i++) {
				
				sr.line(hitLines[i].x1, hitLines[i].y1, hitLines[i].x2, hitLines[i].y2);
				
			}
			
			sr.end();
			return;

		}

		// draw ship
		for (int i = 0, j = shapeX.length - 1; i < shapeX.length; j = i++) {

			sr.line(shapeX[i], shapeY[i], shapeX[j], shapeY[j]);

		}

		// draw rockets
		if (up) {

			for (int i = 0, j = rocketX.length - 1; i < rocketX.length; j = i++) {

				sr.line(rocketX[i], rocketY[i], rocketX[j], rocketY[j]);

			}
		}

		sr.end();

	}

}
