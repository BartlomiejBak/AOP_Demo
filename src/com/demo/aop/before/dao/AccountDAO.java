package com.demo.aop.before.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": doing stuff\n");
    }
    public void addAccount(AccountDAO accountDAO) {
        System.out.println(getClass() + ": doing stuff\n");
    }



    public boolean addAccounts() {
        System.out.println(" weird method \n");
        return true;
    }
}
