package com.analysys.blog.service.impl;

import com.analysys.blog.common.ReturnData;
import com.analysys.blog.entity.Article;
import com.analysys.blog.pojo.ArticlePojo;
import com.analysys.blog.pojo.SimpleArticlePojo;
import com.analysys.blog.repository.ArticleMapper;
import com.analysys.blog.service.ArticleService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaofeng
 * @date 2019/5/24
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Integer DEFAULT_NUM_OF_ARTICLE_PER_PAGE = 10;
    private static final Integer DEFAULT_FETCH_NUM_OF_POPULAR_ARTICLE = 5;


    @Resource
    private ArticleMapper articleMapper;


    @Override
    public ReturnData insert(Article article) {
        int result = articleMapper.insert(article);
        if (result != 1) {
            return ReturnData.buildFailResult(ArticleResult.PUBLISH_FAILURE.toString());
        }

        return ReturnData.buildSuccessResult(ArticleResult.PUBLISH_SUCCESS.toString());
    }


    @Override
    public ReturnData update(Article article) {
        articleMapper.updateByPrimaryKey(article);
        return ReturnData.buildSuccessResult(ArticleResult.UPDATE_SUCCESS.toString());
    }


    @Override
    public ReturnData getNewestArticle() {
        List<ArticlePojo> articlePojoList = articleMapper.selectNewestArticleWithLimitNum(DEFAULT_NUM_OF_ARTICLE_PER_PAGE);
        return ReturnData.buildSuccessResult(articlePojoList);
    }


    @Override
    public ReturnData getNewestArticleByTagIdAndPageNo(Integer tagId, Integer pageNo) {
        List<ArticlePojo> articlePojoList = articleMapper.selectArtilceByTagIdWithStartIndexAndLimitNum(
                tagId, (pageNo - 1) * DEFAULT_NUM_OF_ARTICLE_PER_PAGE, DEFAULT_NUM_OF_ARTICLE_PER_PAGE );
        if (articlePojoList == null) {
            return ReturnData.buildFailResult("");
        }

        return ReturnData.buildSuccessResult(articlePojoList);
    }

    @Override
    public ReturnData getNewestArticleByPageNo(Integer pageNo) {
        List<ArticlePojo> articlePojoList =  articleMapper.selectArtilceWithStartIndexAndLimitNum(
                (pageNo - 1) * DEFAULT_NUM_OF_ARTICLE_PER_PAGE, DEFAULT_NUM_OF_ARTICLE_PER_PAGE);
        if (articlePojoList == null) {
            return ReturnData.buildFailResult("");
        }

        return ReturnData.buildSuccessResult(articlePojoList);
    }



    @Override
    public ReturnData getArticleByArticleId(Integer articleId) {
        ArticlePojo articlePojo = articleMapper.selectByArticleId(articleId);

        if (articlePojo == null) {
            ReturnData.buildFailResult(ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        Map<String, Object> map = new HashMap<>();
        map.put("article", articlePojo);

        return ReturnData.buildSuccessResult(map);
    }


    @Override
    public ReturnData getPopularArticle() {
        List<SimpleArticlePojo> articlePojoList = articleMapper.selectPopularArticleWithLimitNum(DEFAULT_FETCH_NUM_OF_POPULAR_ARTICLE);
        if (articlePojoList == null) {
            ReturnData.buildFailResult(ArticleResult.NO_MATCHING_ARTICLE.toString());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("articleList", articlePojoList);

        return ReturnData.buildSuccessResult(map);
    }


    @Override
    public ReturnData getArticleByCategoryIdAndPageNo(Integer categoryId, Integer pageNo) {
        if (pageNo == null || pageNo <= 0) {
            pageNo = 1;
        }

        List<ArticlePojo> articlePojoList =
                articleMapper.selectArtilceByCategoryIdWithStartIndexAndLimitNum(categoryId,
                (pageNo - 1) * DEFAULT_NUM_OF_ARTICLE_PER_PAGE, DEFAULT_NUM_OF_ARTICLE_PER_PAGE);
        if (articlePojoList == null) {
            return ReturnData.buildFailResult("");
        }

        return ReturnData.buildSuccessResult(articlePojoList);
    }


    @Override
    public ReturnData getNewestArticleByTagId(Integer tagId) {
        List<ArticlePojo> articlePojoList = articleMapper.selectArtilceByTagIdWithStartIndexAndLimitNum(tagId, 0, DEFAULT_NUM_OF_ARTICLE_PER_PAGE);
        if (articlePojoList == null) {
            return ReturnData.buildFailResult("");
        }

        return ReturnData.buildSuccessResult(articlePojoList);
    }


    @Override
    public ReturnData getPreviousArticle(Integer tagId, Integer categoryId, Integer articleId) {
        SimpleArticlePojo simpleArticlePojo = articleMapper.selectPreviousArticle(tagId, categoryId, articleId);
        return ReturnData.buildSuccessResult(simpleArticlePojo);
    }

    @Override
    public ReturnData getNextArticle(Integer tagId, Integer categoryId, Integer articleId) {
        SimpleArticlePojo simpleArticlePojo = articleMapper.selectNextArticle(tagId, categoryId, articleId);
        return ReturnData.buildSuccessResult(simpleArticlePojo);
    }

    @Override
    public ReturnData getTotalNumOfArticleByCategoryIdOrTagId(Integer categoryId, Integer tagId) {
        Integer totalNumOfArticle = articleMapper.selectTotalNumOfArticleByCategoryIdOrTagId(categoryId, tagId);
        Map<String, Object> map = new HashMap<>();
        ((HashMap) map).put("totalNumOfArticle", totalNumOfArticle);
        return ReturnData.buildSuccessResult(map);
    }


    enum ArticleResult {

        PUBLISH_SUCCESS("文章发布成功"),
        PUBLISH_FAILURE("文章发布失败"),
        NO_MATCHING_ARTICLE("没有匹配的文章"),
        UPDATE_SUCCESS("修改成功");

        private String articleResult;

        ArticleResult(String articleResult) {
            this.articleResult = articleResult;
        }

        @Override
        public String toString() {
            return articleResult;
        }
    }
}
