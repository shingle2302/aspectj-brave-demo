package com.shingle.aspectj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {

     private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(* com.shingle.aspectj.service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) {
        try {
            log.info("start {}.{}", joinPoint.getTarget().getClass(), joinPoint.getSignature());
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            log.info("end {}.{}", joinPoint.getTarget().getClass(), joinPoint.getSignature());

        }
    }

    public static LogAspect aspectOf(){
        return new LogAspect();
    }

}
