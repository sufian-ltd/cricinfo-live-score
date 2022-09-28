package com.cricinfo.core.service;

import com.cricinfo.core.domain.User;

public interface UserService {

    User save(User user);

    long countTotalUser();

    void resetPassword(User user);

    User findByUsername(String username);

}
