package com.ctbc.boot.lab1.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.bytebuddy.asm.Advice.Return;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbc.boot.lab1.services.GreetingServices;

@Controller
public class MainController {
	@GetMapping("/") // 根目錄 "/"
	public String home1(Model model) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd --> HH:mm:ss");
		LocalDateTime now = LocalDateTime.now(); // 拿到server的時間
		String message = String.format("現在時刻 : %s", formatter.format(now));
		model.addAttribute("messageHTML",message);
		return "home"; // 此處需return html的檔名
	}

	@Autowired // 別人已經初始化了 // 1
	private GreetingServices service;
	@RequestMapping("/greeting")
	public @ResponseBody String greeting(){ // 2
		return service.greet();
	}


}
