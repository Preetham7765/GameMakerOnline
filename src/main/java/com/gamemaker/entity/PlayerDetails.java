package com.gamemaker.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PlayerDetails {

	@EmbeddedId
	private PlayerDetailId id;

	private String name;

	private String score;

	public PlayerDetailId getId() {
		return id;
	}

	public void setId(PlayerDetailId id) {
		this.id = id;
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
