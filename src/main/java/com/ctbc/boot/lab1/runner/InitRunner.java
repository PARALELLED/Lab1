package com.ctbc.boot.lab1.runner;

import org.slf4j.Marker;
import org.springframework.boot.CommandLineRunner; // spring boot
import org.springframework.stereotype.Component;

import com.ctbc.boot.lab1.bean.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j // Simple Logging Facade(門面) for Java 
@Component
public class InitRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("one term startup script will put here"); // 一些一次性初始化的工作寫在這裡
		/*
		log.info("one term startup script will put here");
		log.debug("debug");
		log.warn("warn");
		log.error("error");
		*/
		
		int x = 5;
		float y = 3.14f;
		String z = "hi";
		
		//log.info("x = {}, y = {}, z = {}",x,y,z);
		
		// 
		Employee mark = new Employee();
		Employee brian = new Employee("Y000456","Brain Chiang",75);
		//log.info("mark = {}, brain = {}",mark,brian);
	}
}
