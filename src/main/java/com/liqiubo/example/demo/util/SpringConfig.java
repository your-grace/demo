package com.liqiubo.example.demo.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.liqiubo.example.demo.util"})
@EnableAspectJAutoProxy
public class SpringConfig {
}
