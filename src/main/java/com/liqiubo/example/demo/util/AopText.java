package com.liqiubo.example.demo.util;

import org.junit.Test;

public class AopText {
    @Test
    public void demo(){
        System.out.println("动态代理实现aop");
        Long start = System.currentTimeMillis();
        UserService userService = MyBeanFactory.CreateUserService();
        userService.addUser();
        userService.deleteUser();
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
