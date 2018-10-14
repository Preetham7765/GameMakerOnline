package com.gamemaker.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.gamemaker.dao.GameRepository;
import com.gamemaker.dao.PlayerRepository;
import com.gamemaker.entity.GameDetails;
import com.gamemaker.entity.PlayerDetails;
import com.gamemaker.model.ScoreBoardEntry;

@Service
public class ScoreBoardService {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private PlayerRepository playerRepository;

	private static final String PATH = "static/";

	public int saveScore(@NonNull ScoreBoardEntry entry) {
		GameDetails gameDetails = gameRepository.findByName(entry.getGameName());

		if (gameDetails == null) {

			return -1;
		}

		PlayerDetails playerDetails = new PlayerDetails();
		playerDetails.setName(entry.getUserName());
		playerDetails.setGameId(gameDetails);
		playerDetails.setScore(entry.getScore());

		playerRepository.save(playerDetails);

		return playerDetails.getId();
	}

	public List<ScoreBoardEntry> getTopScores() {
		Iterable<PlayerDetails> playerDetails = playerRepository.findAll();
		List<PlayerDetails> p = new ArrayList<>();
		Iterator<PlayerDetails> itr = playerDetails.iterator();
		while (itr.hasNext()) {
			p.add((PlayerDetails) itr.next());
		}
		return p.stream().map(s -> this.toScoreBoardEntry(s)).collect(Collectors.toList());
	}

	private ScoreBoardEntry toScoreBoardEntry(@NonNull PlayerDetails playerDetails) {

		String gameName = gameRepository.findNameById(playerDetails.getGameId().getId());
		return new ScoreBoardEntry(gameName, playerDetails.getName(), playerDetails.getScore());

	}

	public int saveGame(String gameName) {

		GameDetails game = gameRepository.findByName(gameName);
		if (game != null)
			return -1;

		GameDetails gameDetail = new GameDetails();
		gameDetail.setName(gameName);
		gameDetail.setPath(PATH + gameName);

		gameRepository.save(gameDetail);

		return gameDetail.getId();
	}

}
