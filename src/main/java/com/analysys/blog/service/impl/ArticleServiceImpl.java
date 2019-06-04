package com.analysys.blog.service.impl;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.common.RtCode;
import com.analysys.blog.entity.Article;
import com.analysys.blog.entity.ArticleTagKey;
import com.analysys.blog.entity.Tag;
import com.analysys.blog.pojo.ArticleParam;
import com.analysys.blog.pojo.ArticlePojo;
import com.analysys.blog.pojo.SimpleArticlePojo;
import com.analysys.blog.repository.ArticleMapper;
import com.analysys.blog.repository.ArticleTagMapper;
import com.analysys.blog.repository.TagMapper;
import com.analysys.blog.service.ArticleService;
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

    @Resource
    private ArticleTagMapper articleTagMapper;

    @Resource
    private TagMapper tagMapper;

    @Override
    public JsonResult publishArticle(ArticleParam articleParam) {
        Article article = new Article();
        article.setCategoryId(articleParam.getCategoryId());
        article.setTitle(articleParam.getTitle());
        article.setContent(articleParam.getContent());
        article.setUserId(articleParam.getUserId());
        article.setSummary(articleParam.getSummary());

        getUrlOfFirstImage(articleParam, article);

        articleMapper.insert(article);

        addArticleTagRecord(articleParam, article);

        return new JsonResult();
    }

    private void getUrlOfFirstImage(ArticleParam articleParam, Article article) {
        // 获取第一张图片url
        String content = articleParam.getContent();
        System.out.println(content);

        String imgTagHeader = "<img src=";
        int indexOfFirstImgTag = content.indexOf(imgTagHeader);

        if (indexOfFirstImgTag != -1) {
            // 第一张图片url第一个双引号
            int startIndex = indexOfFirstImgTag + imgTagHeader.length() + 1;
            int endIndex = startIndex;
            while (content.charAt(endIndex) != '\"'){
                endIndex++;
            }

            String imgPath = content.substring(startIndex, endIndex);
            article.setImgPath(imgPath);
        }
    }


    private void addArticleTagRecord(ArticleParam articleParam, Article article) {
        // 获取自增主键
        Integer articleId = article.getArticleId();
        List<Integer> tagIdList = articleParam.getTagIdList();

        // 新增标签
        List<String> newTagList = articleParam.getNewTagList();
        if (newTagList != null) {
            System.out.println("标签添加");
            Tag tag = new Tag();
            for(String item: newTagList) {
                System.out.println("标签内容" + item);
                tag.setTagId(null);
                tag.setTagName(item);
                tagMapper.insert(tag);
                tagIdList.add(tag.getTagId());
            }
        }



        // 添加文章标签记录
        ArticleTagKey articleTagKey = new ArticleTagKey();
        articleTagKey.setArticleId(articleId);

        for (Integer tagId: tagIdList) {
            articleTagKey.setTagId(tagId);
            articleTagMapper.insert(articleTagKey);
        }
    }


    @Override
    public JsonResult update(Article article) {
        articleMapper.updateByPrimaryKey(article);
        return new JsonResult();
    }


    @Override
    public JsonResult getNewestArticle() {
            List<ArticlePojo> articlePojoList = articleMapper.selectNewestArticleWithLimitNum(DEFAULT_NUM_OF_ARTICLE_PER_PAGE);

            return new JsonResult<>(articlePojoList);
    }


    @Override
    public JsonResult getNewestArticleByTagIdAndPageNo(Integer tagId, Integer pageNo) {
        List<ArticlePojo> articlePojoList = articleMapper.selectArtilceByTagIdWithStartIndexAndLimitNum(
                tagId, (pageNo - 1) * DEFAULT_NUM_OF_ARTICLE_PER_PAGE, DEFAULT_NUM_OF_ARTICLE_PER_PAGE );
        if (articlePojoList.isEmpty()) {
            return new JsonResult(RtCode.BadRequest, ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        tagMapper.addOneToCallNumByTagId(tagId);

        return new JsonResult(articlePojoList);
    }

    @Override
    public JsonResult getNewestArticleByPageNo(Integer pageNo) {
        List<ArticlePojo> articlePojoList =  articleMapper.selectArtilceWithStartIndexAndLimitNum(
                (pageNo - 1) * DEFAULT_NUM_OF_ARTICLE_PER_PAGE, DEFAULT_NUM_OF_ARTICLE_PER_PAGE);
        if (articlePojoList.isEmpty()) {
            return new JsonResult<>(RtCode.BadRequest, ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        return new JsonResult<>(articlePojoList);
    }



    @Override
    public JsonResult getArticle(Integer tagId, Integer categoryId, Integer articleId) {
        ArticlePojo article = articleMapper.selectByArticleId(articleId);
        SimpleArticlePojo previous = articleMapper.selectPreviousArticle(tagId, categoryId, articleId);
        SimpleArticlePojo next = articleMapper.selectNextArticle(tagId, categoryId, articleId);

        if (article == null) {
            return new JsonResult(RtCode.BadRequest, ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        articleMapper.addOneToScanNumByArticleId(articleId);

        Map<String, Object> map = new HashMap<>();
        map.put("article", article);
        map.put("previous", previous);
        map.put("next", next);

        return new JsonResult<>(map);
    }


    @Override
    public JsonResult getPopularArticle() {
        List<SimpleArticlePojo> articlePojoList = articleMapper.selectPopularArticleWithLimitNum(DEFAULT_FETCH_NUM_OF_POPULAR_ARTICLE);
        if (articlePojoList.isEmpty()) {
            return new JsonResult(RtCode.DBERROR, ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        return new JsonResult<>(articlePojoList);
    }


    @Override
    public JsonResult getArticleByCategoryIdAndPageNo(Integer categoryId, Integer pageNo) {
        if (pageNo == null || pageNo <= 0) {
            pageNo = 1;
        }

        List<ArticlePojo> articlePojoList =
                articleMapper.selectArtilceByCategoryIdWithStartIndexAndLimitNum(categoryId,
                (pageNo - 1) * DEFAULT_NUM_OF_ARTICLE_PER_PAGE, DEFAULT_NUM_OF_ARTICLE_PER_PAGE);
        if (articlePojoList.isEmpty()) {
            return new JsonResult(RtCode.BadRequest, ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        return new JsonResult(articlePojoList);
    }


    @Override
    public JsonResult getNewestArticleByTagId(Integer tagId) {
        List<ArticlePojo> articlePojoList = articleMapper.selectArtilceByTagIdWithStartIndexAndLimitNum(tagId, 0, DEFAULT_NUM_OF_ARTICLE_PER_PAGE);
        if (articlePojoList.isEmpty()) {
            return new JsonResult(RtCode.BadRequest, ArticleResult.NO_MATCHING_ARTICLE.toString());
        }

        tagMapper.addOneToCallNumByTagId(tagId);

        return new JsonResult(articlePojoList);
    }


    @Override
    public JsonResult getTotalNumOfArticleByCategoryIdOrTagId(Integer categoryId, Integer tagId) {
        Integer totalNumOfArticle = articleMapper.selectTotalNumOfArticleByCategoryIdOrTagId(categoryId, tagId);
        return new JsonResult(totalNumOfArticle);
    }



    enum ArticleResult {

        PUBLISH_FAILURE("文章发布失败"),
        NO_MATCHING_ARTICLE("没有匹配的文章");

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
