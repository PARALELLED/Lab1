package com.ctbc.boot.lab1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {
    @GetMapping("/info")

    public String getInfo(){
        return "info";
    }
}
