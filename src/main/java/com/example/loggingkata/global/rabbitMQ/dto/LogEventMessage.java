package com.example.loggingkata.global.rabbitMQ.dto;

import lombok.*;
import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor
public class LogEventMessage {
    private String messageId;
    private Object payload;

    public LogEventMessage(Object payload) {
        this.payload = payload;
        this.messageId = UUID.randomUUID().toString();
    }
}