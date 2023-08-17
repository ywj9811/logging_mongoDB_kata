package com.example.loggingkata.global.logging.dto;

import com.example.loggingkata.global.logging.entity.Log;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Request {
    private String logId;
    private Integer executeTime;
    private String methodName;
    private String exceptionMessage;

    public Log toEntity() {
        return new Log(logId, executeTime, methodName, exceptionMessage);
    }
}
