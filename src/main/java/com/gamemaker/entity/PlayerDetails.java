package com.gamemaker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlayerDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;

	private String score;
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private GameDetails gameId; 


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GameDetails getGameId() {
		return gameId;
	}

	public void setGameId(GameDetails gameId) {
		this.gameId = gameId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
