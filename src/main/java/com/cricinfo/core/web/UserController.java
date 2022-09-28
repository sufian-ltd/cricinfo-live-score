package com.cricinfo.core.web;

import com.cricinfo.core.domain.User;
import com.cricinfo.core.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/reset-password")
    public void resetPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user != null) {
            user.setPassword(password);
            userService.resetPassword(user);
        }
        response.sendRedirect("/logout");
    }
}
