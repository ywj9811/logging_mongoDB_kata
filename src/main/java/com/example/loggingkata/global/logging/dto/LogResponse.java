package com.example.loggingkata.global.logging.dto;

import com.example.loggingkata.global.logging.entity.Log;
import com.example.loggingkata.global.logging.entity.LogType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LogResponse {
    private final String id;
    private final String logId;
    private final Integer executeTime;
    private final String methodName;
    private final String exceptionMessage;
    private final LocalDateTime logDate;
    private final LogType logType;

    public static LogResponse from(Log log) {
        return LogResponse.builder()
                .id(log.getId())
                .logId(log.getLogId())
                .executeTime(log.getExecuteTime())
                .methodName(log.getMethodName())
                .exceptionMessage(log.getExceptionMessage())
                .logDate(log.getLogDate())
                .logType(log.getLogType())
                .build();
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
