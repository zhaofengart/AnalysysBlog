package com.analysys.blog.controller;

import com.analysys.blog.common.ReturnData;
import com.analysys.blog.entity.Article;
import com.analysys.blog.pojo.ArticleParam;
import com.analysys.blog.pojo.WangEditor;
import com.analysys.blog.service.ArticleService;
import com.analysys.blog.util.FileUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author zhaofeng
 * @date 2019/5/24
 */

@CrossOrigin
@RestController
@RequestMapping("/blog")
public class ArticleController extends BaseController {


    @Autowired
    private ArticleService articleService;


    // 获取最新文章
    @RequestMapping("/")
    public ReturnData getNewestArticle() {
        return articleService.getNewestArticle();
    }


    // 根据文章id获取文章
    @RequestMapping("/{articleId}")
    public ReturnData getArticleByArticleId(@PathVariable("articleId") Integer articleId){
        return articleService.getArticleByArticleId(articleId);
    }


    // 不带标签的最新文章翻页
    @RequestMapping("/page/{pageNo}")
    public ReturnData getNewestArticleByPageNo(@PathVariable("pageNo") Integer pageNo){
        return articleService.getNewestArticleByPageNo(pageNo);
    }


    // 富文本上传
    @RequestMapping("/uploadMutilPartFile")
    public ReturnData uploadMutilPartFile(@RequestParam("myFile") MultipartFile multipartFile,
                                          HttpServletRequest request) {

        // 获取项目路径
        String realPath = request.getSession().getServletContext().getRealPath("");
        String tempUrl = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + "/upload/";
        return FileUtil.upload(multipartFile, realPath, tempUrl);
    }


//    @RequestMapping("/publishArticle")
//    public ReturnData publishArticle(@RequestParam("article") Article article, @RequestParam("tagList") List<Integer> tagList) {
//        System.out.println(tagList);
//        // 前端自行填写img_path
//        return articleService.insert(article, tagList);
//    }

    @PostMapping("/publishArticle")
    public ReturnData publishArticle(@RequestBody ArticleParam articleParam){
        return articleService.publishArticle(articleParam);
    }

    // 测试文章内容
    @RequestMapping("/publishArticleContent")
    public ReturnData publishArticleContent(@RequestBody String content){
        System.out.println(content);
        return null;
    }


    @PostMapping("/getPopularArticle")
    public ReturnData getPopularArticle(){
        return articleService.getPopularArticle();
    }


    @PostMapping("/updateArticle")
    public ReturnData updateArticle(Article article){
        return  articleService.update(article);
    }


    @RequestMapping("/previous")
    public ReturnData getPreviousArticle(Integer tagId, Integer categoryId, Integer articleId){
        return articleService.getPreviousArticle(tagId, categoryId, articleId);
    }


    @RequestMapping("/next")
    public ReturnData getNextArticle(Integer tagId, Integer categoryId, Integer articleId){
        return articleService.getNextArticle(tagId, categoryId, articleId);
    }


    @RequestMapping("/totalNumOfArticle")
    public ReturnData getTotalNumOfArticleByCategoryIdOrTagId(Integer categoryId, Integer tagId) {
        return articleService.getTotalNumOfArticleByCategoryIdOrTagId(categoryId, tagId);
    }


}
