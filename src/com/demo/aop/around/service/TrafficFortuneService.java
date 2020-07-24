package com.demo.aop.around.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getService() {

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Expect heavy traffic";
    }

    public String getService(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Exception");
        } else {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Expect heavy traffic";
        }
    }

    public String getServ(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Exception");
        } else {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Expect heavy traffic";
        }
    }
}
