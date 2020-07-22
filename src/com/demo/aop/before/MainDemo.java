package com.demo.aop.before;

import com.demo.aop.before.dao.AccountDAO;
import com.demo.aop.before.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        accountDAO.addAccount();
        accountDAO.addAccounts();
        membershipDAO.addAccount();
        membershipDAO.addSomething();
        accountDAO.addAccount(accountDAO);
        membershipDAO.getThisName();

        context.close();
    }
}
