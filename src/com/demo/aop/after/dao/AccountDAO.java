package com.demo.aop.after.dao;

import com.demo.aop.after.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String code;

    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();

        Account temp1 = new Account("John", "mid");
        Account temp2 = new Account("Johnny", "junior");
        Account temp3 = new Account("Johnie", "senior");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }

    public void addAccount() {
        System.out.println(getClass() + ": doing stuff\n");
    }
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": doing stuff\n");
    }
}
