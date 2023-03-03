package com.ctbcbank.boot.lab1;

import com.ctbcbank.boot.lab1.bean.NormalUser1;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

// import static
import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {
    private static Validator validtor;
    @BeforeAll
    public static void setupValidatorInstance(){
        validtor = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // @NotNull
    // -----------------------------------------------------------------------------------------------------------------
    @Test
    public void doSomeTestFirst() {
        NormalUser1 user = new NormalUser1(null);
        Set<ConstraintViolation<NormalUser1>> violations = validtor.validate(user);
        assertThat(violations.size()).isEqualTo(1); // NotNull，但給的參數為null。所以預期會有1個錯誤

    }
    @Test
    public void doAnOtherTest() {
        NormalUser1 user = new NormalUser1("");
        Set<ConstraintViolation<NormalUser1>> violations = validtor.validate(user);
        assertThat(violations.size()).isEqualTo(0); // NotNull，有給參數為""。所以預期會有0個錯誤
    }

    @Test
    public void doElseTest() {
        NormalUser1 user = new NormalUser1("  ");
        Set<ConstraintViolation<NormalUser1>> violations = validtor.validate(user);
        //assertThat(violations.size()).isEqualTo(1);// NotNull，給的參數為"  "。所以預期會有0個錯誤
        assertThat(violations.size()).isEqualTo(0);// NotNull，有給參數為"  "。所以預期會有0個錯誤
    }


}
