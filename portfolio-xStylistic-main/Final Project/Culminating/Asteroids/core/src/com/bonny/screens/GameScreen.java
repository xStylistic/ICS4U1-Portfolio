package com.bonny.screens;

import com.bonny.managers.GameScreenManager;

/**
 * Super class
 * @author Bonny Chen
 */

public abstract class GameScreen {
	
	// protected modifier used to only allow access to the code within the package or when its subclassed
	protected GameScreenManager gsm; 
	
	protected GameScreen(GameScreenManager gsm) { 
		
		this.gsm = gsm;
		initialize();
		
	}
	
	public abstract void initialize();
	
	public abstract void update(float deltaTime);
	
	public abstract void draw();
	
	public abstract void handleInput();
	  
	public abstract void dispose();
	
}
