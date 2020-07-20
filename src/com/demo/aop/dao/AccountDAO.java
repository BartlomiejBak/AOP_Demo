package com.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": doing stuff");
    }

    public boolean addAccounts() {
        System.out.println(" weird method ");
        return true;
    }
}
