package com.liqiubo.example.demo.domain;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/formData")
    public ResponseEntity<Object> formData(MultipartHttpServletRequest request) {
        String instanceId = request.getParameter("instanceId");
        String type = request.getParameter("type");
        String userId = request.getParameter("userId");
        MultipartFile file = request.getFile("file");
        String fileName = file.getOriginalFilename();
        // 创建JSON对象
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("instanceId", instanceId);
        jsonObject.put("type", type);
        jsonObject.put("userId", userId);
        jsonObject.put("fileName", fileName);

        return ResponseEntity.ok(jsonObject);
    }
}
/**
 * POST http://127.0.0.1:8887/file/formData
 * Content-Type: multipart/form-data; boundary=WebAppBoundary
 *
 * --WebAppBoundary
 * Content-Disposition: form-data; name="instanceId"
 * Content-Type: text/plain
 *
 * 155
 * --WebAppBoundary
 * Content-Disposition: form-data; name="type"
 * Content-Type: text/plain
 *
 * 1
 * --WebAppBoundary
 * Content-Disposition: form-data; name="userId"
 * Content-Type: text/plain
 *
 * 9de90ca4048141caaba1ec4e3afa868e
 * --WebAppBoundary
 * Content-Disposition: form-data; name="file"; filename="sakura.png"
 * Content-Type: image/png
 *
 * < C:\Users\liqiubo\Downloads\sakura.png
 * --WebAppBoundary--
 */
