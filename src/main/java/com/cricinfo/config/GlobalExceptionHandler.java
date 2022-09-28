package com.cricinfo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String handleException(Exception exception, Model model) {

        String message = exception != null ? exception.getLocalizedMessage() : "Something Went Wrong";
        log.error("Exception : ", exception);
        model.addAttribute("status", HttpStatus.BAD_REQUEST.value());
        model.addAttribute("message", message);

        return "error";
    }

}
