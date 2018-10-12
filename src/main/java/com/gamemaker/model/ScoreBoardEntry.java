package com.gamemaker.model;


public class ScoreBoardEntry {

	private String game;
	private String userName;
	private String score;
	
	public ScoreBoardEntry() {}
	
	public ScoreBoardEntry(String game, String userName, String score) {
		this.game = game;
		this.userName = userName;
		this.score = score;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	   
}
