package com.ctbc.boot.lab1.bean;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class NormalUser1 {
	@NotNull(message="Name should not be null")
	private String name;
	

}