package com.example.loggingkata.global.logging.dto;

import com.example.loggingkata.global.logging.entity.Log;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class LogRequest {
    private String logId;
    private Integer executeTime;
    private String methodName;
    private String exceptionMessage;
    public LogRequest(String logId, Integer executeTime, String methodName) {
        this.logId = logId;
        this.executeTime = executeTime;
        this.methodName = methodName;
    }
    public Log toEntity() {
        if (exceptionMessage == null)
            exceptionMessage = "";
        return new Log(logId, executeTime, methodName, exceptionMessage);
    }
}
