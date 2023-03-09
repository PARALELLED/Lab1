package com.ctbc.boot.lab1.config;

// 設定檔

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ctbc.boot.lab1.calculator.AddCalculator;
import com.ctbc.boot.lab1.calculator.Calculator;
import com.ctbc.boot.lab1.calculator.SubCalculator;

@Configuration
public class AppConfig {
	// 直接使用interface
	// 一個介面只能有1個Bean
	@Bean("addBean")
	public Calculator calculator1 () {
		return new AddCalculator();
	}
	@Bean("subtractBean")
	public Calculator calculator2() {
		return new SubCalculator();
	}

}
