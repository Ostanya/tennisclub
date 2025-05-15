package com.tennisclub.service.implementation;

import com.tennisclub.repository.entity.AdminUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final AdminUserRepository adminUserRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("loadUser: start to load the user");

        OAuth2User user = new DefaultOAuth2UserService().loadUser(userRequest);
        String username = user.getAttribute("username");

        if (username == null || adminUserRepository.findByUsername(username).isEmpty()) {
            throw new OAuth2AuthenticationException("Unauthorized admin");
        }

        return user;
    }
}
