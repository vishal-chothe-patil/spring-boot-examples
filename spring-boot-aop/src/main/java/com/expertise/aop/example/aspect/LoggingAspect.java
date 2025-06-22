package com.expertise.aop.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.expertise.aop.example.service.*.*(..))")
    public void beforeServiceMethod(JoinPoint joinPoint) {
        logger.info("Before: {}", joinPoint.getSignature());
    }

    @After("execution(* com.expertise.aop.example.service.*.*(..))")
    public void afterServiceMethod(JoinPoint joinPoint) {
        logger.info("After: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.expertise.aop.example.service.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Returned from: {} with result: {}", joinPoint.getSignature(), result);
    }
}