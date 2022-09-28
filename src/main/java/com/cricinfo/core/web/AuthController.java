package com.cricinfo.core.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/")
    public String home(Principal principal) {
        if (principal != null) {
            return "redirect:/live-score/list";
        }
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            log.info(String.format("User '%s' attempted to access the protected URL: '%s'", auth.getName(), request.getRequestURI()));
        }
        return "access-denied";
    }

}
