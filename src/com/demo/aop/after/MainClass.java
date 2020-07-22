package com.demo.aop.after;

import com.demo.aop.after.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        System.out.println("===== Before findAccounts()");
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("===== After findAccounts()\n\n");

        System.out.println(accounts);

        context.close();
    }
}
