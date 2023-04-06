package com.liqiubo.example.demo.util;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mytest {
    @Test
    public void demo(){
        System.out.println("javaconfig实现aop");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.addUser();
        userService.deleteUser();
    }
}
