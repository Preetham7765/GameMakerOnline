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

import com.gamemaker.model.ScoreBoardEntry;
import com.gamemaker.service.ScoreBoardService;

@Controller
public class ApplicationController {

	@Autowired
	private ScoreBoardService scoreBoardService_;

	@RequestMapping("/")
	public String show(Model model) {
		
		List<ScoreBoardEntry> scoreBoardEntries = scoreBoardService_.getTopScores();
		model.addAttribute("gameMaker", "App.jnlp");
		model.addAttribute("PlayerScores", scoreBoardEntries);
		return "index";

	}
	
	@RequestMapping(value = "saveScore", method = RequestMethod.POST)
	public ResponseEntity<String> savePlayerScore(@RequestBody ScoreBoardEntry newScoreEntry) {
		
		System.out.println(newScoreEntry.getGame());
		System.out.println(newScoreEntry.getUserName());
		System.out.println(newScoreEntry.getScore());
		
		return new ResponseEntity<>("OK", HttpStatus.CREATED);
	} 

}
