package com.gamemaker.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.gamemaker.dao.GameDetailsDao;
import com.gamemaker.dao.GameRepository;
import com.gamemaker.dao.PlayerDetailsDao;
import com.gamemaker.dao.PlayerRepository;
import com.gamemaker.entity.GameDetails;
import com.gamemaker.entity.PlayerDetails;
import com.gamemaker.model.ScoreBoardEntry;

@Service
public class ScoreBoradService {

	@Autowired
	private GameRepository gameRespository_;

	@Autowired
	private PlayerRepository playerRepository_;
	
	@Autowired
	private GameDetailsDao gameDetailsDao;
	
	@Autowired
	private PlayerDetailsDao playerDetailsDao;
	
	public void saveScore(@NonNull int gameId, @NonNull String gameName, @NonNull int Score) {
		GameDetails gameDetails = gameDetailsDao.findById(gameId).get();
		if (gameDetails == null) {
			//TO DO: throw error
		}
	}
	
	public List<ScoreBoardEntry> getTopScores() {
		Iterable<PlayerDetails> playerDetails = playerDetailsDao.findAll();
		List<PlayerDetails> p = new ArrayList<>();
		Iterator itr = playerDetails.iterator();
		while(itr.hasNext()) {
			p.add((PlayerDetails)itr.next());
		}
		return p.stream().map(s->ScoreBoardMapper.toScoreBoardEntry(s)).collect(Collectors.toList());
	}

}
