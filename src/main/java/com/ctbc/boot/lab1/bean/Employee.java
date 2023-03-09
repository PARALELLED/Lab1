package com.ctbc.boot.lab1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 所有參數的建構子
@NoArgsConstructor // 對Spring Boot很重要
@Data
public class Employee {
	private String serial;
	private String name;
	private int grade;
	

}