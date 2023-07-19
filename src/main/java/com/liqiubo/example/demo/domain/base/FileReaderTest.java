package com.liqiubo.example.demo.domain.base;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ZipUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL location = FileReaderTest.class.getResource("/static/helloworld.txt");
        Console.log(location);
        Path path = Paths.get(location.toURI());
        Console.log(path);
        BaseFileReader lowerCaseFileReader = new LowercaseFileReader(path);
        BaseFileReader uppercaseFileReader = new UppercaseFileReader(path);
        System.out.println(lowerCaseFileReader.readFile());
        System.out.println(uppercaseFileReader.readFile());
        ZipUtil.zip("static/helloworld.txt", "helloworld.zip");
        ZipUtil.unzip("helloworld.zip", "static/js");
    }
}
