package com.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    String name = "nejm";

    public void getThisName() {
        System.out.println(name);
    }

    public void addAccount() {
        System.out.println(getClass() + " Doing other stuff \n");
    }

    public void addSomething() {
        System.out.println("Adding something \n");
    }
}
