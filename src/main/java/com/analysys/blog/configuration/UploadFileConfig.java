package com.analysys.blog.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @author zhaofeng
 * @date 2019/5/28
 */

@Configuration
public class UploadFileConfig {

//    @Value("${file.uploadFolder}")
//    private String uploadFolder;
//
//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation(uploadFolder);
//        //文件最大
//        factory.setMaxFileSize("5MB");
//        // 设置总上传数据总大小
//        factory.setMaxRequestSize("10MB");
//        return factory.createMultipartConfig();
//    }
}