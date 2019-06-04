package com.analysys.blog.pojo;

import com.analysys.blog.entity.Tag;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhaofeng
 * @date 2019/5/28
 */

public class ArticleParam {

    private Integer categoryId;

    private String title;

    private String content;

    private Integer userId;

    private String summary;

    /**
     * 标签列表
     */
    private List<Integer> tagIdList;

    private List<String> newTagList;

    public List<String> getNewTagList() {
        return newTagList;
    }

    public void setNewTagList(List<String> newTagList) {
        this.newTagList = newTagList;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Integer> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<Integer> tagIdList) {
        this.tagIdList = tagIdList;
    }
}
