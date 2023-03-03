package com.ctbcbank.boot.lab1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data

public class NormalUser3 {
    @NotBlank(message = "Name may not be blank")
    private String name;


}
