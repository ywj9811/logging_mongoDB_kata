package com.example.loggingkata.global.logging.service;

import com.example.loggingkata.global.logging.dto.LogRequest;
import com.example.loggingkata.global.logging.dto.LogResponse;
import com.example.loggingkata.global.logging.entity.Log;
import com.example.loggingkata.global.logging.entity.LogType;
import com.example.loggingkata.global.logging.repository.LogRepository;
import com.example.loggingkata.global.rabbitMQ.dto.LogEventMessage;
import com.example.loggingkata.global.rabbitMQ.producer.MessageProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.loggingkata.global.logging.entity.LogType.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
    private final MessageProducer messageProducer;

    public void save(LogRequest logRequest) throws JsonProcessingException {
        log.info("log save");
        messageProducer.sendMessage(logRequest);
//        logRepository.save(logRequest.toEntity());
    }

    public List<String> getInfo() {
        List<Optional<Log>> allByLogType = logRepository.findAllByLogType(INFO.name());
        List<String> response = new ArrayList<>();
        for (Optional<Log> logInfo : allByLogType) {
            response.add(
                    LogResponse.from(logInfo.orElseThrow())
                    .toString()
            );
        }
        return response;
    }

    public List<String> getWarn() {
        List<Optional<Log>> allByLogType = logRepository.findAllByLogType(WARN.name());
        List<String> response = new ArrayList<>();
        for (Optional<Log> logInfo : allByLogType) {
            response.add(
                    LogResponse.from(logInfo.orElseThrow())
                            .toString()
            );
        }
        return response;
    }

    public List<String> getError() {
        List<Optional<Log>> allByLogType = logRepository.findAllByLogType(ERROR.name());
        List<String> response = new ArrayList<>();
        for (Optional<Log> logInfo : allByLogType) {
            response.add(
                    LogResponse.from(logInfo.orElseThrow())
                            .toString()
            );
        }
        return response;
    }
}
