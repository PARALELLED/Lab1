package com.ctbcbank.boot.lab1.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServices {
    public String greet(){
        return "[waiting]...這是在service中的值，是abcde12345";
    }

}
