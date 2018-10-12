package com.gamemaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamemaker.service.ScoreBoradService;

@RestController
public class ApplicationController {

	@Autowired
	private ScoreBoradService scoreBoardService;
	
	@GetMapping("/scoreboard")
	public String getScoreBoard() {

		return "Hello! Welcome to our game maker";
		
	}
	
	@PostMapping("/scoreboard")
	public void addNewScoreBoardEntry(){
		
	}
	
}
