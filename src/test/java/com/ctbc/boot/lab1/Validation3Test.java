package com.ctbc.boot.lab1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ctbc.boot.lab1.bean.NormalUser1;
import com.ctbc.boot.lab1.bean.NormalUser2;
import com.ctbc.boot.lab1.bean.NormalUser3;

public class Validation3Test {
	// validator
	private static Validator validator;
	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		
	}
	
	@Test
	public void doSomeTestFirst() {
		//Assertions.fail("確定會在這exception");
		NormalUser3 user = new NormalUser3(null);
		// 錯誤會記在裡面
		Set<ConstraintViolation<NormalUser3>> violations =  validator.validate(user);
		assertThat(violations.size()).isEqualTo(1); // null，所以有一個錯
	}
	
	@Test
	public void doAnotherTest() {
		NormalUser3 user = new NormalUser3("");
		Set<ConstraintViolation<NormalUser3>> violations =  validator.validate(user);
		assertThat(violations.size()).isEqualTo(1);// 空字串 -> 1(有錯誤)
	}
	
	@Test
	public void doElseTest() {
		NormalUser3 user = new NormalUser3("  ");
		Set<ConstraintViolation<NormalUser3>> violations =  validator.validate(user);
		assertThat(violations.size()).isEqualTo(1); // 多個空白 -> 視為有字串 -> 0(沒有錯誤)
	}
}
