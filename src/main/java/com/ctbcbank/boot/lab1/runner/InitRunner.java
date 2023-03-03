package com.ctbcbank.boot.lab1.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ctbcbank.boot.lab1.bean.Employee;

import lombok.extern.slf4j.Slf4j;



@Slf4j // Simple Logging Facade(門面) for java
@Component
public class InitRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		int x = 5;
		float y = 3.14f;
		String z = "hi";
		
		log.info("x = {}, y = {}, z = {}",x,y,z);
		
		Employee mark = new Employee();
		Employee brain = new Employee("[Y000456]","[Brain]",75);
		log.info("mark = {}, brain = {}",mark,brain);
		
		
	}
}
