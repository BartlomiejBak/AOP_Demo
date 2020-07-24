package com.demo.aop.around;

import com.demo.aop.around.aspect.AroundAspect;
import com.demo.aop.around.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MainClass {

    private static Logger logger = Logger.getLogger(MainClass.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main program @Around demo");
        System.out.println("Calling getService() ...");
        String service = trafficFortuneService.getService();
        System.out.println(service);

        System.out.println("Main program @Around exception: ");
        service = trafficFortuneService.getService(true);
        System.out.println(service);

        System.out.println("Main program @Around throwing exception");
        service = trafficFortuneService.getServ(true);
        System.out.println(service);
        context.close();
    }
}
