package com.liqiubo.example.demo.domain.base;

import java.nio.file.Path;

class UppercaseFileReader extends BaseFileReader{
    protected UppercaseFileReader(Path filePath) {
        super(filePath);
    }

    @Override
    protected String mapFileLine(String line) {
        return line.toUpperCase();
    }
}
