package com.demo.aop.before.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

    /*
    General rule:
        execution(modifiers-pattern? return-type-pattern declaring-type-pattern?
            method-name-pattern(param-pattern) throws-pattern?)


        method() - only noArg method
        method(*) - only oneArg method
        method(..) - all method
        method(fully qualified class or type name) - only specified type of arg
     */

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    //Method for reusing pointcut expression
    @Pointcut("execution(public void com.demo.aop.before.dao.AccountDAO.addAccount())")
    private void forAccountDAOAddAccount() {};

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>> @Before any addAccount() class that returns void");
    }

    @Before("forAccountDAOAddAccount()")
    public void onlyBeforeAccountDaoAdvice() {
        System.out.println("\n==========>>> @Before AccountDAO.addAccount() class that returns void");
    }

    @Before("execution(public void add*())")
    public void beforeAddAdvice() {
        System.out.println("\n==========>>> @Before any add* class that returns void");
    }

    @Before("execution(public * add*())")
    public void beforeAnyAddAdvice() {
        System.out.println("\n==========>>> @Before any add* class that returns anything");
    }
}
