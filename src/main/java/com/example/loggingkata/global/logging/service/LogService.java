package com.example.loggingkata.global.logging.service;

import com.example.loggingkata.global.logging.dto.Request;
import com.example.loggingkata.global.logging.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public void save(Request request) {
        log.info("log save");
        logRepository.save(request.toEntity());
    }
}
