package com.liqiubo.example.demo.domain.base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

abstract class BaseFileReader {
    protected Path FilePath;
    protected BaseFileReader(Path filePath) {
        this.FilePath  = filePath;
    }
    public List<String> readFile() throws IOException {
        return Files.lines(FilePath).map(this::mapFileLine).collect(Collectors.toList());
    }
    protected abstract String mapFileLine(String line);
}

