package com.liqiubo.example.demo.domain.base;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderTest {
    @Test
    public void demo() throws URISyntaxException, IOException {
//        URL location = getClass().getClassLoader().getResource("/static/helloworld.txt");
        URL location = getClass().getResource("/static/helloworld.txt");
        System.out.println(location);
        Path path = Paths.get(location.toURI());
        BaseFileReader lowerCaseFileReader = new LowercaseFileReader(path);
        BaseFileReader uppercaseFileReader = new UppercaseFileReader(path);
        System.out.println(lowerCaseFileReader.readFile());
        System.out.println(uppercaseFileReader.readFile());
    }
}
