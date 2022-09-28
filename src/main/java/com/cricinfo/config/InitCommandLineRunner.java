package com.cricinfo.config;

import com.cricinfo.core.domain.User;
import com.cricinfo.core.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class InitCommandLineRunner implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) {
        if (userService.countTotalUser() == 0) {
            User user = new User();
            user.setUsername("admin@gmail.com");
            user.setPassword("12345");
            userService.save(user);
            log.info("| NEW USER ADDED:, EMAIL: {}", user.getUsername());
        }
        log.warn("A DUMMY USER CREATED WITH EMAIL: 'admin@gmail.com' AND PASSWORD: '12345'");
    }

}
