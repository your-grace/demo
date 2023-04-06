package com.liqiubo.example.demo.util;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("添加用户成功");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户成功");
    }
}
