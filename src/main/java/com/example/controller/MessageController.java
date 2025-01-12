package com.example.controller;

import com.example.config.AppConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final AppConfig appConfig;

    public MessageController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/message")
    public String getMessage() {
        return "Активный профиль: " + activeProfile + "</br>"
                + (appConfig.getMessage() != null ? appConfig.getMessage() : "Message not loaded!");
    }
}
