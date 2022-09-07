package com.bonny.managers;

import com.bonny.screens.GameOverScreen;
import com.bonny.screens.GameScreen;
import com.bonny.screens.MenuScreen;
import com.bonny.screens.PlayScreen;

public class GameScreenManager {
	
	// current game screen
	private GameScreen gameScreen; 
	
	public static final int MENU = 0;
	public static final int PLAY = 1;
	public static final int GAMEOVER = 2;
	
	public GameScreenManager() { // the different game screens
		
		setScreen(MENU);
		
	}
	
	public void setScreen(int screen) {
		
		if (gameScreen != null) gameScreen.dispose(); // gets rid of last game screen
		
		if (screen == MENU) { // switch to the menu screen
			
		gameScreen = new MenuScreen(this);
			
		}
		
		if (screen == PLAY) { // switch to play screen 
			
			gameScreen = new PlayScreen(this);
			
		}
		
		if (screen == GAMEOVER) {
			
			gameScreen = new GameOverScreen(this);
			
		}
		
	}
	
	public void update(float deltaTime) { 
		
		gameScreen.update(deltaTime);
		
	}
	
	public void draw() { 
		
		gameScreen.draw();
		
	}

}
