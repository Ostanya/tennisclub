package com.tennisclub.service.implementation;

import com.tennisclub.service.TennisClubService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TennisClubServiceImplementation implements TennisClubService {

    @Override
    public String loginAdmin() {
        return "admin-login";
    }
}
