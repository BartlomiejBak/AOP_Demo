package com.demo.aop;

import com.demo.aop.dao.AccountDAO;
import com.demo.aop.dao.MembershipDAO;
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

        membershipDAO.getThisName();

        context.close();
    }
}
