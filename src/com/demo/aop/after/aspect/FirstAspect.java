package com.demo.aop.after.aspect;

import com.demo.aop.after.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class FirstAspect {

    @AfterReturning(
                    pointcut = "execution(* com.demo.aop.after.dao.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("+++++++++ @AfterReturning //");

        String method = joinPoint.getSignature().toShortString();
        System.out.println("+++++++++ short string method: " + method);

        System.out.println("+++++++++ result is: " + result);

        //modification of result
        convertAccountNamesToUppercase(result);

    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }
}
