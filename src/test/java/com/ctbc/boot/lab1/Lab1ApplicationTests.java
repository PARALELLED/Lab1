package com.ctbc.boot.lab1;


import org.assertj.core.api.Assertions; // assertj
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ctbc.boot.lab1.controllers.MainController;

@SpringBootTest
class Lab1ApplicationTests {
	@Autowired // 會被Autowired叫進來
	private MainController controller;
	
	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}

}