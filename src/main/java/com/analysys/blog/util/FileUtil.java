package com.analysys.blog.util;

import com.analysys.blog.common.ReturnData;
import com.analysys.blog.pojo.WangEditor;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhaofeng
 * @date 2019/5/25
 */

public class FileUtil {
    public static ReturnData upload(MultipartFile multipartFile, String realPath, String tempUrl){

        try{
            InputStream inputStream = multipartFile.getInputStream();
            String uploadPath = realPath + "upload";

            // 获取文件名称
            String filename = multipartFile.getOriginalFilename();

            // 将文件上传的服务器根目录下的upload文件夹
            File file = new File(uploadPath, filename);
            FileUtils.copyInputStreamToFile(inputStream, file);

            // 返回图片访问路径
            String url = tempUrl+ filename;

            System.out.println(url);
//            String [] str = {url};
//            return url;
//            WangEditor we = new WangEditor(str);
//            return we;

            return ReturnData.buildSuccessResult(url);
        } catch (IOException e) {
    //            log.error("上传文件失败", e);
            System.out.println("上传失败");
        }
            return null;
    }

}
