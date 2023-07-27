package com.liqiubo.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileServiceImpl fileService;

    @PostMapping("/upload")
    public FileUploadResponse upload(MultipartHttpServletRequest request) {
        MultipartFile file = request.getFile("file");
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        return fileService.upload(file);
    }
//    public FileUploadResponse upload(@RequestParam("file") MultipartFile file) {
//        return fileService.upload(file);
//    }
}

