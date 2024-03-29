package com.liqiubo.example.demo.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class FileServiceImpl implements FileService{

    //拦截的url，虚拟路径
    public String pathPattern = "files";

    //自己设置的目录
    private static final String fileDir = "fileStorage";

    //上传文件存放目录  =  工作目录绝对路径 + 自己设置的目录，也可以直接自己指定服务器目录
    //windows本地测试
    //绝对路径: D:\develop\work\project\myblog\myblog-file-upload\fileStorage\202302021010345680.jpg
    //System.getProperty("user.dir")   D:\develop\work\project\myblog\myblog-file-upload
    //fileDir                          fileStorage
    //fileName                         202302021010345680.jpg
    public String filePath = System.getProperty("user.dir") + File.separator + fileDir + File.separator;

    private static final AtomicInteger SUFFIX = new AtomicInteger(0);

    @Value(value = "${file.upload.suffix:jpg,jpeg,png,bmp,xls,xlsx,pdf}")
    private String fileUploadSuffix;

    public FileUploadResponse upload(MultipartFile file) {
        FileUploadResponse result = new FileUploadResponse();
        if (file.isEmpty()) {
            log.error("the file to be uploaded is empty");
            return result;
        }
//        List<String> suffixList = Lists.newArrayList(fileUploadSuffix.split(","));
        List<String> suffixList = new ArrayList<>(Arrays.asList(fileUploadSuffix.split(",")));

        try {
            //校验文件后缀
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            if (!suffixList.contains(suffix)) {
                log.error("unsupported file format");
                return result;
            }

            //首次需生成目录
            File folder = new File(filePath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String fileName = timeFormat(System.currentTimeMillis()) + SUFFIX.getAndIncrement() + "." + suffix;
            String absolutePath = filePath + fileName;
            log.info("absolutePath is {}", absolutePath);
            file.transferTo(new File(absolutePath));

            String separator = "/";
            String path = separator + pathPattern + separator + fileName;
            result.setPath(path);
            result.setFileName(fileName);
        } catch (Exception e) {
            log.error("the file upload error occurred. e ", e);
        }
        return result;
    }

    public static String timeFormat(Long time) {
        if (Objects.isNull(time)) {
            return null;
        }
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(time);
    }

}


