package com.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>> @Before advice on addAccount");
    }

    @Before("execution(public void com.demo.aop.dao.AccountDAO.addAccount())")
    public void onlyBeforeAccountDaoAdvice() {
        System.out.println("\n==========>>> @Before advice on AccountDAO addAccount");
    }

    @Before("execution(public void add*())")
    public void beforeAddAdvice() {
        System.out.println("\n==========>>> @Before advice on add*");
    }

    @Before("execution(public * add*())")
    public void beforeAnyAddAdvice() {
        System.out.println("\n==========>>> @Before advice on add* returned anything");
    }
}
