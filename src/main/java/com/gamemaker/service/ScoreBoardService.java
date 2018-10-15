package com.gamemaker.service;

import java.io.File;
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
		System.out.println("Game Name: " + entry.getGameName());
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
		Iterable<PlayerDetails> playerDetails = playerRepository.getTopFiveScore();
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

	public int saveGame(String fileName) {
		
		String gameName = fileName.split("\\.")[0];
		System.out.println("gameName" + gameName);
		GameDetails game = gameRepository.findByName(gameName);
		if (game != null)
			return -1;

		GameDetails gameDetail = new GameDetails();
		gameDetail.setName(gameName);
		gameDetail.setPath(PATH + fileName);
		
		gameRepository.save(gameDetail);

		return gameDetail.getId();
	}
	
	public List<String> listFiles() {
		String path = this.getClass().getResource("/static").getPath();
		File[] files = new File(path).listFiles();
		List<String> filenames = new ArrayList<>();
		for(File f: files) {
			String name = f.getName();
			if (name.contains(".ser")) {
				filenames.add(name.substring(0, name.lastIndexOf('.')));
			}
		}
		return filenames;
	}

	public String getPath(String fileName) {
		GameDetails game = gameRepository.findByName(fileName);
		if(game == null) return null;
		
		return game.getPath();
	} 

}
