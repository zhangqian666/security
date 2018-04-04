package com.zq.web.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Aspect
@Slf4j
//@Component
public class TImeAspect {


    @Around("execution(* UserController.*(..))")
    public Object HandlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        log.info("time aspect start");

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            log.info("arg is " + arg);
        }

        long start = new Date().getTime();

        Object object = pjp.proceed();
        log.info("time aspect 耗时:" + (new Date().getTime() - start));

        log.info("time aspect end");
        return object;
    }
}
