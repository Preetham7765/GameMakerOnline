package com.gamemaker.service;

import org.springframework.lang.NonNull;

import com.gamemaker.entity.PlayerDetails;
import com.gamemaker.model.ScoreBoardEntry;

public class ScoreBoardMapper {
	public static ScoreBoardEntry toScoreBoardEntry(@NonNull PlayerDetails playerDetails) {
		return new ScoreBoardEntry(playerDetails.getGameName(), playerDetails.getName(), playerDetails.getScore());
	}

}
