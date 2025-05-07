package com.tennisclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class TennisClubController {

    @GetMapping("/login")
    public String message() {
        return "Hello Tania!";
    }
}
