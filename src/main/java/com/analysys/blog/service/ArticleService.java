package com.analysys.blog.service;

import com.analysys.blog.common.ReturnData;
import com.analysys.blog.entity.Article;
import com.analysys.blog.pojo.ArticleParam;

import java.util.List;

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
    ReturnData publishArticle(ArticleParam articleParam);
    /**
     * 修改文章
     *
     * @param
     * @return
     */
    ReturnData update(Article article);


    /**
     * 获取最新文章
     *
     * @param
     * @return
     */
    ReturnData getNewestArticle();


    /**
     * 根据标签id和页码获取最新文章
     *
     * @param
     * @return
     */
    ReturnData getNewestArticleByTagIdAndPageNo(Integer tagId, Integer pageNo);


    /**
     * 不带标签根据页码获取最新文章
     *
     * @param
     * @return
     */
    ReturnData getNewestArticleByPageNo(Integer pageNo);


    /**
     * 根据文章id查找文章全部内容
     *
     * @param articleId 文章id
     * @return
     */
    ReturnData getArticleByArticleId(Integer articleId);


    /**
     *  获取指定数量的热门文章
     *
     * @param
     * @return
     */
    ReturnData getPopularArticle();


    /**
     * 根据类别、起始位置和数量获取文章
     *
     * @param
     * @return
     */
    ReturnData getArticleByCategoryIdAndPageNo(Integer categoryId, Integer pageNo);



    /**
     * 根据标签id获取最新文章
     *
     * @param
     * @return
     */
    ReturnData getNewestArticleByTagId(Integer tagId);



    /**
     * 根据标签id、类别id和当前文章id获取取上一篇文章的id和title
     *
     * @param
     * @return
     */
    ReturnData getPreviousArticle(Integer tagId, Integer categoryId, Integer articleId);


    /**
     * 根据标签id、类别id和当前文章id获取取下一篇文章的id和title
     *
     * @param
     * @return
     */
    ReturnData getNextArticle(Integer tagId, Integer categoryId, Integer articleId);


    /**
     * 根据文章类别id和标签id获取文章总数
     *
     * @param
     * @return 
     */
    ReturnData getTotalNumOfArticleByCategoryIdOrTagId(Integer categoryId, Integer tagId);
    
    
    
    

}
