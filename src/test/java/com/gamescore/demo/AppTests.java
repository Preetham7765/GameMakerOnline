package com.gamescore.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gamemaker.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {App.class})
public class AppTests {

	@Test
	public void contextLoads() {
	}

}
