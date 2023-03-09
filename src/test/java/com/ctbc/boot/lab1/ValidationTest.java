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

public class ValidationTest {
	// validator
	private static Validator validator;
	@BeforeAll
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		
	}
	
	@Test
	public void doSomeTestFirst() {
		//Assertions.fail("確定會在這exception");
		NormalUser1 user = new NormalUser1(null);
		// 錯誤會記在裡面
		Set<ConstraintViolation<NormalUser1>> violations =  validator.validate(user);
		assertThat(violations.size()).isEqualTo(1); // null，所以有一個錯
	}
	
	@Test
	public void doAnotherTest() {
		NormalUser1 user = new NormalUser1("");
		Set<ConstraintViolation<NormalUser1>> violations =  validator.validate(user);
		assertThat(violations.size()).isEqualTo(0); // 沒有錯，所以寫0是正確的
	}
	
	@Test
	public void doElseTest() {
		NormalUser1 user = new NormalUser1("  ");
		Set<ConstraintViolation<NormalUser1>> violations =  validator.validate(user);
		assertThat(violations.size()).isEqualTo(0); // 沒有錯，所以寫0是正確的
	}
}