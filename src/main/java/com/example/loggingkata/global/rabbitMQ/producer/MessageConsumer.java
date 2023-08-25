package com.example.loggingkata.global.rabbitMQ.producer;

import com.example.loggingkata.global.logging.dto.LogRequest;
import com.example.loggingkata.global.logging.repository.LogRepository;
import com.example.loggingkata.global.rabbitMQ.dto.LogEventMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageConsumer {
    private final LogRepository logRepository;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${spring.rabbitmq.queue.name}")
    public void receive(String request) throws JsonProcessingException {
        LogRequest logRequest = objectMapper.readValue(request, LogRequest.class);
        log.info("Received message: {}", logRequest.toString());
//        LogRequest logRequest = convertFromString(logEventMessage.getPayload().toString());
        logRepository.save(logRequest.toEntity());
    }

    public static LogRequest convertFromString(String input) {
        int endIdx = input.indexOf("}");
        input = input.substring(0, endIdx);
        // 입력된 String을 파싱하여 필요한 정보 추출
        String logId = extractValue(input, "logId=");
        Integer executeTime = Integer.parseInt(extractValue(input, "executeTime="));
        String methodName = extractValue(input, "methodName=");
        String exceptionMessage = extractValue(input, "exceptionMessage=");

        // 추출한 정보로 LogRequest 객체 생성
        return new LogRequest(logId, executeTime, methodName, exceptionMessage);
    }

    private static String extractValue(String input, String key) {
        int startIndex = input.indexOf(key) + key.length();
        int endIndex = input.indexOf(",", startIndex);
        if (endIndex == -1) {
            endIndex = input.length();
        }
        return input.substring(startIndex, endIndex).trim();
    }
}
