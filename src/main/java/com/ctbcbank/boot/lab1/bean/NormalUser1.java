package com.ctbcbank.boot.lab1.bean;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NormalUser1 {
	@NotNull(message = "Name should not be null")
	private String name;
	

}
