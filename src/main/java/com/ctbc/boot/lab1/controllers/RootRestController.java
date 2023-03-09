package com.ctbc.boot.lab1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctbc.boot.lab1.bean.CourseForm;

@RestController // 1
public class RootRestController {
	@RequestMapping("/api")
	String apiHome() {
		return "Hello api home";
	}
	
	@RequestMapping("/api/course/0")
	CourseForm getCourse() {
		CourseForm courseForm = new CourseForm();
		courseForm.setCourseId("POOP");
		courseForm.setCourseName("Python");
		courseForm.setDuration(35);
		return courseForm;
	}
}
