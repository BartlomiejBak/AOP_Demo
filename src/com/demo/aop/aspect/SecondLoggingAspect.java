package com.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class SecondLoggingAspect {


    //Pointcut for all getters
    @Pointcut("execution(void get*(..))")
    private void getters(){};

    //Pointcut for all methods
    @Pointcut("execution(* *(..))")
    public void allMethods(){};

    @Before("allMethods()")
    public void forAllMethods() {
        System.out.println("new method =========================");
    }
}