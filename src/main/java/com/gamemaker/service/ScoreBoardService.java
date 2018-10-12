package com.gamemaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamemaker.dao.GameRepository;
import com.gamemaker.dao.PlayerRepository;

@Service
public class ScoreBoardService {

	@Autowired
	private GameRepository gameRespository_;
	
	@Autowired
	private PlayerRepository playerRepository_;
	
	
	
}
