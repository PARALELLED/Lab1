package com.ctbc.boot.lab1.bean;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NormalUser3 {
	@NotBlank(message = "Name may not be blank")
	private String name;
}