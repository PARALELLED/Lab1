package com.ctbcbank.boot.lab1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.ctbcbank.boot.lab1.controllers.MainController;

@SpringBootTest
class Lab1ApplicationTests {
	@Autowired // 會被Autowird進來
	private MainController controller;

	@Test
	void contextLoads() {
		/*
		[ERROR]  Lab1ApplicationTests.contextLoads:16 
		Expecting actual not to be null
		*/
		//Assertions.assertThat(controller).isNotNull();
		Assertions.assertThat(controller).isNotNull();
	}

}
