package com.analysys.blog.service.impl;

import com.analysys.blog.common.ReturnData;
import com.analysys.blog.entity.Article;
import com.analysys.blog.entity.ArticleTagKey;
import com.analysys.blog.pojo.ArticleParam;
import com.analysys.blog.pojo.ArticlePojo;
import com.analysys.blog.pojo.SimpleArticlePojo;
import com.analysys.blog.repository.ArticleMapper;
import com.analysys.blog.repository.ArticleTagMapper;
import com.analysys.blog.repository.TagMapper;
import com.analysys.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private ArticleTagMapper articleTagMapper;

    @Resource
    private TagMapper tagMapper;

    @Override
    public ReturnData publishArticle(ArticleParam articleParam) {
        Article article = new Article();
        article.setCategoryId(articleParam.getCategoryId());
        article.setTitle(articleParam.getTitle());
        article.setContent(articleParam.getContent());
        article.setUserId(articleParam.getUserId());
        article.setSummary(articleParam.getSummary());

        // 获取第一张图片url
        String content = articleParam.getContent();
        System.out.println(content);
        String imgTagHeader = "<img src=";
        int indexOfFirstImgTag = content.indexOf(imgTagHeader);

        if (indexOfFirstImgTag != -1) {
            // 第一张图片url第一个双引号
            int startIndex = indexOfFirstImgTag + imgTagHeader.length();
            int endIndex = startIndex + 1;
            while (content.charAt(endIndex) != '\"'){
                endIndex++;
            }

            String imgPath = content.substring(startIndex, endIndex + 1);
            article.setImgPath(imgPath);
        }



        articleMapper.insert(article);
        // 获取自增主键
        Integer articleId = article.getArticleId();

        // 添加文章标签记录
        ArticleTagKey articleTagKey = new ArticleTagKey();
        articleTagKey.setArticleId(articleId);
        List<Integer> tagIdList = articleParam.getTagIdList();
        for (Integer tagId: tagIdList) {
            articleTagKey.setTagId(tagId);
            articleTagMapper.insert(articleTagKey);
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
        if (articlePojoList.isEmpty()) {
            return ReturnData.buildFailResult(ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        return ReturnData.buildSuccessResult(articlePojoList);
    }

    @Override
    public ReturnData getNewestArticleByPageNo(Integer pageNo) {
        List<ArticlePojo> articlePojoList =  articleMapper.selectArtilceWithStartIndexAndLimitNum(
                (pageNo - 1) * DEFAULT_NUM_OF_ARTICLE_PER_PAGE, DEFAULT_NUM_OF_ARTICLE_PER_PAGE);
        if (articlePojoList.isEmpty()) {
            return ReturnData.buildFailResult(ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        return ReturnData.buildSuccessResult(articlePojoList);
    }



    @Override
    public ReturnData getArticleByArticleId(Integer articleId) {
        ArticlePojo articlePojo = articleMapper.selectByArticleId(articleId);

        if (articlePojo.getArticleId() == null) {
            ReturnData.buildFailResult(ArticleResult.NO_MATCHING_ARTICLE.toString());
        }



        return ReturnData.buildSuccessResult(articlePojo);
    }


    @Override
    public ReturnData getPopularArticle() {
        List<SimpleArticlePojo> articlePojoList = articleMapper.selectPopularArticleWithLimitNum(DEFAULT_FETCH_NUM_OF_POPULAR_ARTICLE);
        if (articlePojoList.isEmpty()) {
            ReturnData.buildFailResult(ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        return ReturnData.buildSuccessResult(articlePojoList);
    }


    @Override
    public ReturnData getArticleByCategoryIdAndPageNo(Integer categoryId, Integer pageNo) {
        if (pageNo == null || pageNo <= 0) {
            pageNo = 1;
        }

        List<ArticlePojo> articlePojoList =
                articleMapper.selectArtilceByCategoryIdWithStartIndexAndLimitNum(categoryId,
                (pageNo - 1) * DEFAULT_NUM_OF_ARTICLE_PER_PAGE, DEFAULT_NUM_OF_ARTICLE_PER_PAGE);
        if (articlePojoList.isEmpty()) {
            return ReturnData.buildFailResult(ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        return ReturnData.buildSuccessResult(articlePojoList);
    }


    @Override
    public ReturnData getNewestArticleByTagId(Integer tagId) {
        List<ArticlePojo> articlePojoList = articleMapper.selectArtilceByTagIdWithStartIndexAndLimitNum(tagId, 0, DEFAULT_NUM_OF_ARTICLE_PER_PAGE);
        if (articlePojoList.isEmpty()) {
            return ReturnData.buildFailResult(ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        tagMapper.addOneToCallNumByTagId(tagId);

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
        return ReturnData.buildSuccessResult(totalNumOfArticle);
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
