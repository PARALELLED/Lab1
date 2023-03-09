package com.ctbc.boot.lab1.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.ctbc.boot.lab1.calculator.Calculator;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BeanRunner implements CommandLineRunner{
	@Autowired
	private ApplicationContext context; // 所有的bean都可以從context裡面找
	

	@Override
	public void run(String... args) throws Exception {
		log.info("try something about bean in spring");
		int x = 5;
		int y = 6;
		
		// context.getBean(類別.class).類別裡的方法(x, y)
		// add (from com.ctbc.boot.lab1.config)
		log.info("Use ApplicationContext and add bean");
		log.info("{} + {} = {}",x,y,context.getBean("addBean",Calculator.class).calc(x, y));
		
		// subtract (from com.ctbc.boot.lab1.config)
		log.info("Use ApplicationContext and subtract bean");
		log.info("{} - {} = {}",x,y,context.getBean("subtractBean",Calculator.class).calc(x, y));
	}
	

}