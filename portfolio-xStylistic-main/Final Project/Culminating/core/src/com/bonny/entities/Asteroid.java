package com.bonny.entities;

/**
 * Name: Bonny Chen
 * Date: June 20th
 * Description: The Asteroid class creates the asteroids in the game
 */

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class Asteroid extends SpaceObject {
	
	/*
	 * Attributes + Variables
	 */
	
	/** the number 0 represents a small asteroid */
	public static final int SMALL = 0;
	
	/** the number 1 represents a medium asteroid */
	public static final int MEDIUM = 1;
	
	/** the number 2 represents a large asteroid */
	public static final int LARGE = 2;
	
	/** the type of the asteroid */
	private int type;
	
	/** the amount of points the asteroid is worth */
	private int score;
	
	/** the number of vertices the asteroid has */
	private int numPoints;
	
	/** the distance between each vertices */
	private float[] distance;
	
	/** if the asteroid should be removed from the screen */
	private boolean remove;
	
	/**
	 * this class creates the asteroids
	 * 
	 * @param x		the x coordinate 
	 * @param y		the y coordinate
	 * @param type	the size of the asteroid
	 */
	public Asteroid(float x, float y, int type) {

		this.x = x;
		this.y = y;
		this.type = type;

		if (type == SMALL) { // the parameters of a small asteroid

			numPoints = 8; 
			width = height = 18;
			speed = MathUtils.random(70, 100);
			score = 100;

		} else if (type == MEDIUM) { // the parameters of a medium asteroid

			numPoints = 10;
			width = height = 36;
			speed = MathUtils.random(50, 60);
			score = 50;

		} else if (type == LARGE) { // the parameters of large asteroid

			numPoints = 12;
			width = height = 60 ;
			speed = MathUtils.random(20, 30);
			score = 25;

		}

		rotationSpeed = MathUtils.random(-1, 1); // the random speed the asteroid spins at
		
		// asteroid movement speed
		radians = MathUtils.random((int) (2 * Math.PI));
		dx = MathUtils.cos(radians) * speed;
		dy = MathUtils.sin(radians) * speed;
		
		// draws the shape with the number of points and the distance between them
		shapeX = new float[numPoints];
		shapeY = new float[numPoints];
		distance = new float[numPoints];

		int radius = width / 2;

		for (int i = 0; i < numPoints; i++) {

			distance[i] = MathUtils.random(radius / 2, radius);

		}

		setShape();

	}
	
	/*
	 * Methods
	 */
	
	/**
	 * gets the type of asteroid
	 * 
	 * @return the type of asteroid
	 */
	public int getType() {

		return type;

	}
	
	/**
	 * gets the score
	 * 
	 * @return the score
	 */
	public int getScore() {
		
		return score;
		
	}
	
	/**
	 * sets the shape of the asteroid
	 */
	private void setShape() {

		float angle = 0;

		for (int i = 0; i < numPoints; i++) {

			shapeX[i] = x + MathUtils.cos(angle + radians) * distance[i];
			shapeY[i] = y + MathUtils.sin(angle + radians) * distance[i];
			angle += 2 * Math.PI / numPoints;

		}

	}

	/**
	 * this method removes the asteroid from the screen
	 * 
	 * @return if the asteroid should be removed after it's destroyed
	 */
	public boolean shouldRemove() {

		return remove;

	}
	
	/**
	 * this method updates the asteroid per frame
	 * 
	 * @param deltaTime		the time it takes to load per frame
	 */
	public void update(float deltaTime) {

		x += dx * deltaTime;
		y += dy * deltaTime;

		radians += rotationSpeed * deltaTime;
		setShape();

		wrap();

	}
	
	/**
	 * this method draws the the asteroids on the screen
	 * 
	 * @param sr	short for for ShapeRenderer, allows you do use the ShapeRenderer library to draw the asteroids
	 */
	public void draw(ShapeRenderer sr) {
		
		sr.setColor(1, 1, 1, 1);
		sr.begin(ShapeType.Line);
		
		for (int i = 0, j = shapeX.length - 1; i < shapeX.length; j = i++) {

			sr.line(shapeX[i], shapeY[i], shapeX[j], shapeY[j]);
		}
		
		sr.end();
		
	}

}