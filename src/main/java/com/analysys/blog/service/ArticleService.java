package com.analysys.blog.service;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.entity.Article;
import com.analysys.blog.pojo.ArticleParam;

import java.util.List;
import java.util.Map;

/**
 * @author zhaofeng
 * @date 2019/5/24
 */

public interface ArticleService {

    /**
     * 发布文章
     *
     * @param
     * @return
     */
    JsonResult publishArticle(ArticleParam articleParam);
    /**
     * 修改文章
     *
     * @param
     * @return
     */
    JsonResult update(Article article);


    /**
     * 获取最新文章
     *
     * @param
     * @return
     */
    JsonResult getNewestArticle();


    /**
     * 根据标签id和页码获取最新文章
     *
     * @param
     * @return
     */
    JsonResult getNewestArticleByTagIdAndPageNo(Integer tagId, Integer pageNo);


    /**
     * 不带标签根据页码获取最新文章
     *
     * @param
     * @return
     */
    JsonResult getNewestArticleByPageNo(Integer pageNo);


    /**
     * 根据文章id查找文章全部内容
     *
     * @param articleId 文章id
     * @return
     */
    JsonResult getArticle(Integer tagId, Integer categoryId, Integer articleId);


    /**
     *  获取指定数量的热门文章
     *
     * @param
     * @return
     */
    JsonResult getPopularArticle();


    /**
     * 根据类别、起始位置和数量获取文章
     *
     * @param
     * @return
     */
    JsonResult getArticleByCategoryIdAndPageNo(Integer categoryId, Integer pageNo);



    /**
     * 根据标签id获取最新文章
     *
     * @param
     * @return
     */
    JsonResult getNewestArticleByTagId(Integer tagId);


    /**
     * 根据文章类别id和标签id获取文章总数
     *
     * @param
     * @return 
     */
    JsonResult getTotalNumOfArticleByCategoryIdOrTagId(Integer categoryId, Integer tagId);


    /**
     *
     *
     * @return
     */
    JsonResult getRelatedRecommendationArticles(Integer articleId);
}
