package com.analysys.blog.repository;

import com.analysys.blog.entity.Article;
import com.analysys.blog.pojo.ArticlePojo;
import com.analysys.blog.pojo.SimpleArticlePojo;

import java.util.List;

public interface ArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Sun May 26 17:44:56 CST 2019
     */
    int deleteByPrimaryKey(Integer articleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Sun May 26 17:44:56 CST 2019
     */
    int insert(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Sun May 26 17:44:56 CST 2019
     */
    int insertSelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Sun May 26 17:44:56 CST 2019
     */
    Article selectByPrimaryKey(Integer articleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Sun May 26 17:44:56 CST 2019
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Sun May 26 17:44:56 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Sun May 26 17:44:56 CST 2019
     */
    int updateByPrimaryKey(Article record);


    /**
     * 根据文章id获取完整文章
     *
     * @param articleId 文章id
     * @return article_id 为 articleId 的文章
     */
    ArticlePojo selectByArticleId(Integer articleId);


    /**
     * 获取最新文章
     *
     * @param limitNum 获取文章数量上限
     * @return 最新文章列表
     */
    List<ArticlePojo> selectNewestArticleWithLimitNum(Integer limitNum);


    /**
     * 获取热门文章，只含articleId和title
     *
     * @param limitNum 获取文章数量上限
     * @return 热门文章列表
     */
    List<SimpleArticlePojo> selectPopularArticleWithLimitNum(Integer limitNum);


    /**
     * 根据类别id获取文章
     *
     * @param categoryId 类别id
     * @param startIndex 查询记录起始下标
     * @param limitNum 获取文章数量上限
     * @return 文章列表
     */
    List<ArticlePojo> selectArtilceByCategoryIdWithStartIndexAndLimitNum(Integer categoryId, int startIndex, Integer limitNum);


    /**
     * 根据标签id获取最新文章
     *
     * @param tagId 标签id
     * @param limitNum 获取文章数量上限
     * @return 文章列表
     */
    List<ArticlePojo> selectArtilceByTagIdWithStartIndexAndLimitNum(Integer tagId, int startIndex, Integer limitNum);


    /**
     * 不带标签根据下标和页码获取最新文章
     *
     * @param
     * @return
     */
    List<ArticlePojo> selectArtilceWithStartIndexAndLimitNum(int startIndex, Integer limitNum);


    /**
     * 根据标签id、类别id和当前文章id获取取上一篇文章的id和title
     *
     * @param
     * @return 上一篇文章的id和title
     */
    SimpleArticlePojo selectPreviousArticle(Integer tagId, Integer categoryId, Integer articleId);


    /**
     * 根据标签id、类别id和当前文章id获取取下一篇文章的id和title
     *
     * @param
     * @return 下一篇文章的id和title
     */
    SimpleArticlePojo selectNextArticle(Integer tagId, Integer categoryId, Integer articleId);



    /**
     * 根据标签id或类别id或两者都无，获取文章总数
     *
     * @param
     * @return 
     */
    Integer selectTotalNumOfArticleByCategoryIdOrTagId(Integer categoryId, Integer tagId);
}