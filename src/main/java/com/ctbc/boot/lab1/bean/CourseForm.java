package com.ctbc.boot.lab1.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CourseForm {
	
	// 加上限制
	@NotEmpty // @ 含有interface的概s念
	@Size(min=5,max=30)
	private String courseId;
	@NotEmpty
	private String courseName;
	@NotNull
	@Min(7)
	private Integer duration;
	

}
