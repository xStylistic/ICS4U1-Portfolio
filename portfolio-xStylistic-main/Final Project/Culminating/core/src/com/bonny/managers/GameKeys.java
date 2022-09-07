package com.bonny.managers;

public class GameKeys {

	private static boolean[] keys; // true = key pressed, false = key released
	private static boolean[] previousKeys;

	private static final int NUM_KEYS = 8;
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	public static final int ENTER = 4;
	public static final int ESCAPE = 5;
	public static final int SPACE = 6;
	public static final int SHIFT = 7;

	static {
		
		keys = new boolean[NUM_KEYS];
		previousKeys = new boolean[NUM_KEYS];
		
	}

	public static void update() {
		
		for (int i = 0; i < NUM_KEYS; i++) {
			
			previousKeys[i] = keys[i];
			
		}
		
	}

	public static void setKey(int k, boolean b) {
		
		keys[k] = b;
		
	}

	public static boolean isDown(int k) { // if the key is held down

		return keys[k];

	}

	public static boolean isPressed(int k) { // when the previous key was up and the current key is down

		return keys[k] && !previousKeys[k];

	}

}
