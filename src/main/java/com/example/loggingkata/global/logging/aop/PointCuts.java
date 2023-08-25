package com.example.loggingkata.global.logging.aop;

import org.aspectj.lang.annotation.Pointcut;

//AOP사용
public class PointCuts {

    // 언제 실행될 것인지 지정
    @Pointcut("execution(* com.example.loggingkata.domain..controller..*(..))")
    public void allController() {}
    @Pointcut("execution(* com.example.loggingkata.domain..service..*(..))")
    public void allService() {}
}
