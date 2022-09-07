package com.bonny.entities;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.bonny.main.Game;

public class FlyingSaucer extends SpaceObject {
	
	private ArrayList<Bullet> bullets;
	
	public static final int LARGE = 0;
	public static final int SMALL = 1;
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	
	private int type;
	private int direction;
	private int score; 
	
	private float fireTimer;
	private float fireTime;
	
	private Player player;
	
	private float pathTimer;
	private float pathTime1;
	private float pathTime2;
	
	private boolean remove;
	
	public FlyingSaucer(int type, int direction, Player player, ArrayList<Bullet> bullets) {
		
		this.type = type;
		this.direction = direction;
		this.player = player;
		this.bullets = bullets;
		
		speed = 60;
		
		if (direction == LEFT) {
			
			dx = -speed;
			x = Game.WIDTH;
			
		}
		else if (direction == RIGHT) {
			
			dx = speed;
			x = 0;
			
		}
		
		y = MathUtils.random(Game.HEIGHT);
		
		shapeX = new float[6];
		shapeY = new float[6];
		
		setShape();
		
		if (type == LARGE) {
			
			score = 300;
	
		}
		else if (type == SMALL) {
			
			score = 1000;
	
		}
		
		fireTimer = 0;
		fireTime = 1;
		
		pathTimer = 0;
		pathTime1 = 2;
		pathTime2 = pathTime1 + 2;
		
	}
	
	private void setShape() {
		
		if (type == LARGE) {
			
			shapeX[0] = x - 15;
			shapeY[0] = y;
			
			shapeX[1] = x - 4;
			shapeY[1] = y - 6;
			
			shapeX[2] = x + 4;
			shapeY[2] = y - 6;
			
			shapeX[3] = x + 15;
			shapeY[3] = y;
			
			shapeX[4] = x + 4;
			shapeY[4] = y + 6;
			
			shapeX[5] = x - 4;
			shapeY[5] = y + 6;
			
		}
		
		else if (type == SMALL) {
			
			shapeX[0] = x - 10;
			shapeY[0] = y;
			
			shapeX[1] = x - 3;
			shapeY[1] = y - 5;
			
			shapeX[2] = x + 3;
			shapeY[2] = y - 5;
			
			shapeX[3] = x + 10;
			shapeY[3] = y;
			
			shapeX[4] = x + 3;
			shapeY[4] = y + 5;
			
			shapeX[5] = x - 3;
			shapeY[5] = y + 5;
			
		}
		
	}
	
	public int getScore() { 
		
		return score; 
	
	}
	
	public boolean shouldRemove() { 
		
		return remove; 
		
	}
	
	public void update(float deltaTime) {
		
		// fire
		if (!player.isHit()) {
			
			fireTimer += deltaTime;
			
			if (fireTimer > fireTime) {
				
				fireTimer = 0;
				
				if (type == LARGE) {
					
					radians = MathUtils.random((int) (2 * Math.PI));
					
				}
				else if (type == SMALL) {
					
					radians = MathUtils.atan2(player.getY() - y, player.getX() - x);
				}
				
				bullets.add(new Bullet(x, y, radians));
		
			}
			
		}
		
		// move along path
		pathTimer += deltaTime;
		
		// move forward
		if (pathTimer < pathTime1) {
			
			dy = 0;
			
		}
		
		// move downward
		if (pathTimer > pathTime1 && pathTimer < pathTime2) {
			
			dy = -speed;
			
		}
		
		// move to end of screen
		if (pathTimer > pathTime1 + pathTime2) {
			
			dy = 0;
			
		}
		
		x += dx * deltaTime;
		y += dy * deltaTime;
		
		// screen wrap
		if (y < 0) y = Game.HEIGHT;
		
		// set shape
		setShape();
		
		// check if remove
		if ((direction == RIGHT && x > Game.WIDTH) || (direction == LEFT && x < 0)) {
			
			remove = true;
			
		}
		
	}
	
	public void draw(ShapeRenderer sr) {
		
		sr.setColor(1, 1, 1, 1);
		sr.begin(ShapeType.Line);
		
		for (int i = 0, j = shapeX.length - 1; i < shapeX.length; j = i++) {
			
			sr.line(shapeX[i], shapeY[i], shapeX[j], shapeY[j]);
			
		}
		
		sr.line(shapeX[0], shapeY[0], shapeX[3], shapeY[3]);
			
		sr.end();
		
	}
	
}
