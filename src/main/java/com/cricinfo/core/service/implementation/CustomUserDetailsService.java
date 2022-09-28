package com.cricinfo.core.service.implementation;

import com.cricinfo.core.domain.User;
import com.cricinfo.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        CustomUserDetails customUserDetails = null;
        if (user != null) {
            customUserDetails = new CustomUserDetails();
            customUserDetails.setUser(user);
        } else {
            throw new UsernameNotFoundException("User doesn't exist with the username: " + username);
        }
        return customUserDetails;
    }

}
