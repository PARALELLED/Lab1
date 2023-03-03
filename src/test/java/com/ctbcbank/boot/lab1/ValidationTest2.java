package com.ctbcbank.boot.lab1;

import com.ctbcbank.boot.lab1.bean.NormalUser2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest2 {
    private static Validator validtor;
    @BeforeAll
    public static void setupValidatorInstance(){
        validtor = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // @NotEmpty
    // -----------------------------------------------------------------------------------------------------------------
    @Test
    public void doSomeTestFirst() {
        NormalUser2 user = new NormalUser2(null);
        Set<ConstraintViolation<NormalUser2>> violations = validtor.validate(user);
        assertThat(violations.size()).isEqualTo(1); // NotEmpty，但給的參數為null。所以預期會有1個錯誤

    }
    @Test
    public void dodoAnOtherTest() {
        NormalUser2 user = new NormalUser2("");
        Set<ConstraintViolation<NormalUser2>> violations = validtor.validate(user);
        assertThat(violations.size()).isEqualTo(1); // NotEmpty，但給的參數為""(空白)。所以預期會有1個錯誤
    }

    @Test
    public void doElseTest() {
        NormalUser2 user = new NormalUser2("  ");
        Set<ConstraintViolation<NormalUser2>> violations = validtor.validate(user);
        assertThat(violations.size()).isEqualTo(0); // NotEmpty，給的參數為"  "。所以預期會有0個錯誤
    }
}
