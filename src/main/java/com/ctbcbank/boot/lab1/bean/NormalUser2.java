package com.ctbcbank.boot.lab1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Data
public class NormalUser2 {
	@NotEmpty(message = "Name　should not be null")
	private String name;

}
