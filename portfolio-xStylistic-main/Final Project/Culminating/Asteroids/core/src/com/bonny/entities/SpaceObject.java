package com.bonny.entities;

import com.bonny.main.Game;

public class SpaceObject {

	protected float x;
	protected float y;

	protected float[] shapeX;
	protected float[] shapeY;

	protected float dx;
	protected float dy;

	protected float radians;
	protected float speed;
	protected float rotationSpeed;

	protected int width;
	protected int height;

	public float getX() {

		return x;

	}

	public float getY() {

		return y;

	}

	public float[] getShapeX() {

		return shapeX;

	}

	public float[] getShapeY() {

		return shapeY;

	}
	
	public void setPosition(float x, float y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public boolean intersects(SpaceObject other) {
		
		float[] sx = other.getShapeX();
		float[] sy = other.getShapeY();
		
		for (int i = 0; i < sx.length; i++) {
			
			if (contains(sx[i], sy[i])) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}

	public boolean contains(float x, float y) {
		
		boolean b = false;
		
		for (int i = 0, j = shapeX.length - 1; i < shapeX.length; j = i++) {
			
			if ((shapeY[i] > y) != (shapeY[j] > y)
					
					&& (x < (shapeX[j] - shapeX[i]) * (y - shapeY[i]) / (shapeY[j] - shapeY[i]) + shapeX[i])) {
				
				b = !b;
				
			}
			
		}
		
		return b;
		
	}

	protected void wrap() {

		if (x < 0)

			x = Game.WIDTH;

		if (x > Game.WIDTH)

			x = 0;

		if (y < 0)

			y = Game.HEIGHT;

		if (y > Game.HEIGHT)

			y = 0;

	}

}
