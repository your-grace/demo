package com.liqiubo.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    FileServiceImpl fileService;
    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //将匹配上/files/**虚拟路径的url映射到文件上传到服务器的目录，获取静态资源
        registry.addResourceHandler("/" + fileService.pathPattern + "/**").addResourceLocations("file:" + fileService.filePath);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
