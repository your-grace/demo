package com.liqiubo.example.demo.domain.base;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.util.ReflectUtil;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public class HuTool {
    private int id;
    public HuTool(){
        System.out.println("构造方法");
    }
    public void print(){
        System.out.println("我是沉默小李");
    }
    public static void main(String[] args) throws IllegalAccessException, UnsupportedEncodingException {
        // 设置控制台的字符编码为UTF-8
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.toString()));
        String zodiac = DateUtil.getZodiac(Month.SEPTEMBER.getValue(), 15);
        System.out.println(zodiac);

        // 构建对象
        HuTool HutoolDemo = ReflectUtil.newInstance(HuTool.class);
        // 获取构造方法
        Constructor[] constructors = ReflectUtil.getConstructors(HuTool.class);
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

        // 获取字段
        Field field = ReflectUtil.getField(HuTool.class, "id");
        field.setInt(HutoolDemo, 10);
        // 获取字段值
        System.out.println(ReflectUtil.getFieldValue(HutoolDemo, field));

        // 获取所有方法
        Method[] methods = ReflectUtil.getMethods(HuTool.class);
        for (Method m : methods) {
            System.out.println(m.getName());
        }

        // 获取指定方法
        Method method = ReflectUtil.getMethod(HuTool.class, "print");
        System.out.println(method.getName());


        // 执行方法
        ReflectUtil.invoke(HutoolDemo, "print");
    }
}
