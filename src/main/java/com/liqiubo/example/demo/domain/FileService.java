package com.liqiubo.example.demo.domain;

import org.springframework.web.multipart.MultipartFile;
public interface FileService {
    FileUploadResponse upload(MultipartFile file);
}
