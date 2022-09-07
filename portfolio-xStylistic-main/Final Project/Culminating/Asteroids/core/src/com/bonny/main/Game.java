package com.bonny.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.bonny.managers.GameInput;
import com.bonny.managers.GameScreenManager;

public class Game implements ApplicationListener {
	
	public static int WIDTH;
	public static int HEIGHT;
	
	public static OrthographicCamera camera;
	
	private GameScreenManager gsm;
	
	public void create() { // starts the game
		
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(WIDTH, HEIGHT); // makes camera the same size as the game
		camera.translate(WIDTH / 2, HEIGHT / 2); // moves camera to the positive axis
		camera.update(); // updates position
		
		Gdx.input.setInputProcessor(new GameInput());
		
		gsm = new GameScreenManager();
		
	}

	public void render() { // loops the game
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		gsm.update(Gdx.graphics.getDeltaTime()); // how long it's been since last render 
		gsm.draw();							     // so you know how much to move the game forward 

	}

	public void resize(int width, int height) {

	}

	public void pause() {

	}

	public void resume() {

	}

	public void dispose() { // exit game

	}
	
}
