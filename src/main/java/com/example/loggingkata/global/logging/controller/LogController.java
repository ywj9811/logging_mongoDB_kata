package com.example.loggingkata.global.logging.controller;

import com.example.loggingkata.global.logging.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
public class LogController {
    private final LogService logService;

    @GetMapping("/info")
    public List<String> getInfo() {
        return logService.getInfo();
    }

    @GetMapping("/warn")
    public List<String> getWarn() {
        return logService.getWarn();
    }

    @GetMapping("/error")
    public List<String> getError() {
        return logService.getError();
    }
}
