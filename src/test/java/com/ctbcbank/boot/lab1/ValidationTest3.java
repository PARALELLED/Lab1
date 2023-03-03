package com.ctbcbank.boot.lab1;

import com.ctbcbank.boot.lab1.bean.NormalUser3;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest3 {
    private static Validator validtor;
    @BeforeAll
    public static void setupValidatorInstance(){
        validtor = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // @NotBlank
    // -----------------------------------------------------------------------------------------------------------------
    @Test
    public void doSomeTestFirst() {
        NormalUser3 user = new NormalUser3(null);
        Set<ConstraintViolation<NormalUser3>> violations = validtor.validate(user);
        assertThat(violations.size()).isEqualTo(1); // NotBlank，有給參數為null(空值)。所以預期會有1個錯誤

    }
    @Test
    public void dodoAnOtherTest() {
        NormalUser3 user = new NormalUser3("");
        Set<ConstraintViolation<NormalUser3>> violations = validtor.validate(user);
        assertThat(violations.size()).isEqualTo(1); // NotBlank，有給參數為""(空字串)。所以預期會有1個錯誤
    }

    @Test
    public void doElseTest() {
        NormalUser3 user = new NormalUser3("  ");
        Set<ConstraintViolation<NormalUser3>> violations = validtor.validate(user);
        assertThat(violations.size()).isEqualTo(1); // NotBlank，有給參數為"  "(空白)。所以預期會有1個錯誤
    }


}
