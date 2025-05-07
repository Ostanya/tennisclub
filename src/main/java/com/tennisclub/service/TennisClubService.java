package com.tennisclub.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TennisClubService {

    public String getHello() {
        return "login";
    }
}
