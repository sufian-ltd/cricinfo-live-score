package com.cricinfo.core.service.implementation;

import com.cricinfo.core.domain.User;
import com.cricinfo.core.repository.UserRepository;
import com.cricinfo.core.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public long countTotalUser() {
        return userRepository.count();
    }

    @Override
    public void resetPassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword().trim()));
        userRepository.save(user);
        log.info("| PASSWORD RESET BY {}", user.getUsername());
    }

}
