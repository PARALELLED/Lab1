package com.ctbc.boot.lab1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	private static final String NAME = "nameHTML";
	private static final String PROMPT = "promptHTML";
	
	@RequestMapping("/hello") // 輸入 http://localhost:8080/hello 即可查看
	public String doGreet(
			@RequestParam(value = "name",required = false,defaultValue = "Brain") String name,
			@RequestParam(value = "prompt",required = false,defaultValue = "hello") String prompt,
			Model model) {
		//name = "Mark";
		model.addAttribute(NAME,name);
		model.addAttribute(PROMPT,prompt);
		return "greeting";
	}

}
