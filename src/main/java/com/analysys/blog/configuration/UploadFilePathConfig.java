package com.analysys.blog.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhaofeng
 * @date 2019/5/28
 */

@Configuration
public class UploadFilePathConfig extends WebMvcConfigurerAdapter {

//    @Value("${file.staticAccessPath}")
//    private String staticAccessPath;
//    @Value("${file.uploadFolder}")
//    private String uploadFolder;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
//    }
}
