package com.gamemaker.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PlayerDetailId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7506435704057056978L;

	@NotNull
	private int playerId;
	
	@NotNull
	private int gameId;

	public PlayerDetailId() {
	}

	public PlayerDetailId(int playerId, int gameId) {
		this.playerId = playerId;
		this.gameId = gameId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameId;
		result = prime * result + playerId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerDetailId other = (PlayerDetailId) obj;
		if (gameId != other.gameId)
			return false;
		if (playerId != other.playerId)
			return false;
		return true;
	}

}
