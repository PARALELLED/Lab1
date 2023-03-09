package com.ctbc.boot.lab1.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ctbc.boot.lab1.bean.CourseForm;


import lombok.extern.slf4j.Slf4j;

@Controller // 1
@Slf4j
public class CourseController implements WebMvcConfigurer{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results"); // url,name
	}
	
	@GetMapping("/course") // 2
	public String showCourse(CourseForm courseForm) { // CourseForm courseform 
//		courseForm.setCourseId("POOP");
//		courseForm.setCourseName("Python物件導向實務");
//		courseForm.setDuration(35);
		return "course";
	}
	
	@PostMapping("/course")
	public String checkCourse(@Valid CourseForm y, BindingResult bindingResult) {
		log.info("get course from HTML form : {}",y);
		if (bindingResult.hasErrors()) {
			log.info("validation got errors, need to fix");
			return "course";
		}
		return "redirect:/results"; // 這邊應該是個成功網頁的URL		
	}
	

}