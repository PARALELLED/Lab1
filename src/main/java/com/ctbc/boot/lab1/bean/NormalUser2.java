package com.ctbc.boot.lab1.bean;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NormalUser2 {
	@NotEmpty(message = "Name should not be empty")
	private String name;

}
