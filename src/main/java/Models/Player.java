package Models;

import javafx.scene.paint.Color;

public class Player {
	private String sessionID;
	private int id;
	private String name;
	private javafx.scene.paint.Color color;
	private int score;

	public Player(String sessionID, int id, String name, javafx.scene.paint.Color color) {
		this.sessionID = sessionID;
		this.id = id;
		this.name = name;
		this.color = color;
		score = 0;
	}

	public Player(int id, String name){
		this.id = id;
		this.name = name;
	}

	public String getSessionID() {
		return sessionID;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int score) {
		this.score += score;
	}
}