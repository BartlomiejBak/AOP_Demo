package com.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + " Doing other stuff");
    }

    public void addSomething() {
        System.out.println("Adding something");
    }
}
