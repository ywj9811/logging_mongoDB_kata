package com.example.loggingkata.global.logging.dto;

import com.example.loggingkata.global.logging.entity.LogType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response {
    private final String id;
    private final String logId;
    private final Integer executeTime;
    private final String methodName;
    private final String exceptionMessage;
    private final LocalDateTime logDate;
    private final LogType logType;

    @Builder
    public Response(String id, String logId, Integer executeTime, String methodName,
                    String exceptionMessage, LocalDateTime logDate, LogType logType) {
        this.id = id;
        this.logId = logId;
        this.executeTime = executeTime;
        this.methodName = methodName;
        this.exceptionMessage = exceptionMessage;
        this.logDate = logDate;
        this.logType = logType;
    }

    @Override
    public String toString() {
        return "InfoLogResponse[" +
                "id=" + id + ", " +
                "logId=" + logId + ", " +
                "executeTime=" + executeTime + ", " +
                "methodName=" + methodName + ", " +
                "exceptionMessage=" + exceptionMessage + ", " +
                "logDate=" + logDate + ", " +
                "logType=" + logType + ']';
    }
}
