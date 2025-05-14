package com.tennisclub.controller;

import com.tennisclub.service.TennisClubService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class TennisClubController {

    private final TennisClubService tennisClubService;

    TennisClubController(TennisClubService tennisClubService) {
        this.tennisClubService = tennisClubService;
    }

    @GetMapping("/admin-login")
    public String message() {
        return tennisClubService.loginAdmin();
    }
}
