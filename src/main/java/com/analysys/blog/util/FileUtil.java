package com.analysys.blog.util;

import com.analysys.blog.common.ReturnData;
import com.analysys.blog.entity.Category;
import com.analysys.blog.pojo.WangEditor;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhaofeng
 * @date 2019/5/25
 */

public class FileUtil {



    public static WangEditor upload(MultipartFile multipartFile, HttpServletRequest request){

        try{
            // 获取项目路径
            InputStream inputStream = multipartFile.getInputStream();
            String uploadPath = request.getSession().getServletContext().getRealPath("") + "upload";
            System.out.println(uploadPath);

            // 获取文件名称
            String filename = generateFileName(multipartFile);

            // 将文件上传的服务器根目录下的upload文件夹
            File file = new File(uploadPath, filename);
            FileUtils.copyInputStreamToFile(inputStream, file);

            // 返回图片访问路径
            String url = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/upload/" + filename;

            System.out.println(url);

            String data[] = {url};
            return new WangEditor(data);
//            return ReturnData.buildSuccessResult(url);
        } catch (IOException e) {
    //            log.error("上传文件失败", e);
            System.out.println("上传失败");
        }
            return null;
    }

    // 根据时间生成文件名
    private static String generateFileName(MultipartFile file){
        String originalFileName = file.getOriginalFilename();
        String suffix = originalFileName.substring(originalFileName.lastIndexOf('.'));
        Calendar calendar = Calendar.getInstance();
        return String.format("%d%02d%02d%02d%02d%02d%02d%s", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), calendar.get(Calendar.MILLISECOND), suffix);
    }


}
