package com.gamemaker.model;


public class ScoreBoardEntry {

	private String gameName;
	private String userName;
	private String score;
	
	public ScoreBoardEntry() {}
	
	public ScoreBoardEntry(String game, String userName, String score) {
		this.gameName = game;
		this.userName = userName;
		this.score = score;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String game) {
		this.gameName = game;
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
