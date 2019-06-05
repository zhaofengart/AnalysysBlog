package com.analysys.blog.util;

import com.analysys.blog.pojo.WangEditor;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

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

            String[] data = {url};
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

        //获得文件名
        String filename = file.getOriginalFilename();
        //截取文件后缀
        String fileSuffix = filename.substring(filename.lastIndexOf(".")).toLowerCase();
        //时间格式化对象
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        //生成时间戳
        String newFilename = simpleDateFormat.format(new Date());
        //生成新的文件名
        return newFilename + new Random().nextInt(1000) + fileSuffix;
      }


}
