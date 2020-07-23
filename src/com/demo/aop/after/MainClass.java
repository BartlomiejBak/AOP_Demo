package com.demo.aop.after;

import com.demo.aop.after.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        System.out.println("@AFTER RETURNING");
        System.out.println("===== Before findAccounts()");
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("===== After findAccounts()\n\n");
        System.out.println(accounts);

        System.out.println("\n\n\n@AFTER THROWING");
        System.out.println("===== Before ");
        accounts = null;

        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("Main program caught exception: " + e);
        }

        context.close();
    }
}
