package com.bonny.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.bonny.main.Game;
import com.bonny.managers.GameKeys;
import com.bonny.managers.GameScreenManager;

public class GameOverScreen extends GameScreen {

	private SpriteBatch sb;

	private BitmapFont gameOverFont;
	private BitmapFont font;

	private FreeTypeFontGenerator fontGen;
	private FreeTypeFontGenerator.FreeTypeFontParameter gameOverFontParam;
	private FreeTypeFontGenerator.FreeTypeFontParameter fontParam;
	
	private GlyphLayout glyphLayout = new GlyphLayout();

	private final String gameOver = "GameOver!";
	private int currentOption;
	private String[] menuOptions;

	public GameOverScreen(GameScreenManager gsm) {

		super(gsm);

	}

	public void initialize() {

		sb = new SpriteBatch();

		fontGen = new FreeTypeFontGenerator(Gdx.files.internal("Bubble Pixel.TTF"));
		
		gameOverFontParam = new FreeTypeFontGenerator.FreeTypeFontParameter();
		gameOverFontParam.size = 70;
		gameOverFontParam.color = Color.WHITE;
		gameOverFont = fontGen.generateFont(gameOverFontParam);

		fontParam = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParam.size = 42;
		fontParam.color = Color.WHITE;
		font = fontGen.generateFont(fontParam);

		menuOptions = new String[] {

				"Play Again", "Quit"

		};

	}

	public void update(float deltaTime) {

		handleInput();

	}

	public void draw() {

		sb.begin();
		

		// draw title
		glyphLayout.setText(gameOverFont, gameOver);
		gameOverFont.draw(sb, glyphLayout, (Game.WIDTH - glyphLayout.width) / 2, 370);

		// draw menu
		for (int i = 0; i < menuOptions.length; i++) {

			if (currentOption == i)
				
				font.setColor(Color.PINK);
			
			else
				
				font.setColor(Color.WHITE);
			
			glyphLayout.setText(font, menuOptions[i]);
			font.draw(sb, glyphLayout, (Game.WIDTH - glyphLayout.width) / 2, 210 - 50 * i);

		}

		sb.end();

	}

	public void handleInput() {

		if (GameKeys.isPressed(GameKeys.UP)) {

			if (currentOption > 0) {

				currentOption--;

			}

		}

		if (GameKeys.isPressed(GameKeys.DOWN)) {

			if (currentOption < menuOptions.length - 1) {

				currentOption++;

			}

		}

		if (GameKeys.isPressed(GameKeys.ENTER)) {

			select();

		}

	}

	public void select() {

		// play
		if (currentOption == 0) {

			gsm.setScreen(GameScreenManager.PLAY);

		}

		else if (currentOption == 1) {

			Gdx.app.exit();

		}

	}

	public void dispose() {

		sb.dispose();
		gameOverFont.dispose();
		font.dispose();

	}

}
