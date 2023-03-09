package com.ctbc.boot.lab1.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServices {
	public String greet() { // Spring 最小單位為物件，
		
		return "[waiting...] 這是在service中的值，是abcde12345";
	}
	
}