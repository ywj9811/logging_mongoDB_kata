package com.example.loggingkata.global.logging.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Document(collection = "log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Log {
    @Id
    private String id;
    private String logId;
    private Integer executeTime;
    private String methodName;
    private String exceptionMessage;
    private LogType logType;
    @Indexed(expireAfterSeconds = 60)
    private LocalDateTime logDate = LocalDateTime.now();

    public Log(String logId, Integer executeTime, String methodName, String exceptionMessage) {
        this.logId = logId;
        this.executeTime = executeTime;
        this.methodName = methodName;
        checkExceptionMessage(exceptionMessage);
    }

    private void checkExceptionMessage(String exceptionMessage){
        if(exceptionMessage.equals("null")){
            this.logType = LogType.INFO;
            this.exceptionMessage="";
        }else{
            this.logType = LogType.ERROR;
            this.exceptionMessage=exceptionMessage;
        }
    }
}
