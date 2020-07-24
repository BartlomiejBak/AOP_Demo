package com.demo.aop.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class AroundAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.demo.aop.around.service.TrafficFortuneService.getService())")
    public Object aroundTrafficFortuneServiceGetService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Starting @Around " + method);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Execution lasts " + duration/1000 + " seconds");
        return result;
    }

    //handling exception
    @Around("execution(* com.demo.aop.around.service.TrafficFortuneService.getService(*))")
    public Object aroundHandlingException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Starting @Around " + method);
        long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
             logger.warning(e.getMessage());
             result = "Major accident";
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Execution lasts " + duration/1000 + " seconds");
        return result;
    }

    //throwing exception
    @Around("execution(* com.demo.aop.around.service.TrafficFortuneService.getService(*))")
    public Object aroundThrowingException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Starting @Around " + method);
        long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Execution lasts " + duration/1000 + " seconds");
        return result;
    }
}
