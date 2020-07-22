package com.demo.aop.before.aspect;

import com.demo.aop.before.dao.AccountDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
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

    @Before("allMethods() && !getters()")
    public void forAllMethodsExceptGetters(JoinPoint joinPoint) {
        System.out.println("this is not a getter method");

        //display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display method arguments

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof AccountDAO) {
                System.out.println("this is an account");
            }
        }
    }
}