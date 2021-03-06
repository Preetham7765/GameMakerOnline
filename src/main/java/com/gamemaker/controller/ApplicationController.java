package com.gamemaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamemaker.model.ScoreBoardEntry;
import com.gamemaker.service.ScoreBoardService;

@Controller
public class ApplicationController {

	@Autowired
	private ScoreBoardService scoreBoardService_;

	@RequestMapping("/")
	public String show(Model model) {
		model.addAttribute("downloadFiles", scoreBoardService_.listFiles());
		List<ScoreBoardEntry> scoreBoardEntries = scoreBoardService_.getTopScores();
		model.addAttribute("gameMaker", "App.jnlp");
		model.addAttribute("PlayerScores", scoreBoardEntries);
		return "index";
	}
	
	@RequestMapping(value = "saveScore", method = RequestMethod.POST)
	public ResponseEntity<Integer> savePlayerScore(@RequestBody ScoreBoardEntry newScoreEntry) {

		int id =  scoreBoardService_.saveScore(newScoreEntry);
		
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "saveGame", method = RequestMethod.POST)
	public ResponseEntity<Integer> saveGame(@RequestParam(value="gameName", required = true) String gameName) {

		int id =  scoreBoardService_.saveGame(gameName);
		
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}
	
	

}
