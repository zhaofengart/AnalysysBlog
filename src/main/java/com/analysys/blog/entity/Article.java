package com.analysys.blog.entity;

import java.util.Date;

public class Article {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.article_id
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    private Integer articleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.category_id
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.title
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.user_id
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.issue_time
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    private Date issueTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.scan_num
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    private Integer scanNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.img_path
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    private String imgPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.summary
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    private String summary;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.content
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.article_id
     *
     * @return the value of article.article_id
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.article_id
     *
     * @param articleId the value for article.article_id
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.category_id
     *
     * @return the value of article.category_id
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.category_id
     *
     * @param categoryId the value for article.category_id
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.title
     *
     * @return the value of article.title
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.title
     *
     * @param title the value for article.title
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.user_id
     *
     * @return the value of article.user_id
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.user_id
     *
     * @param userId the value for article.user_id
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.issue_time
     *
     * @return the value of article.issue_time
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public Date getIssueTime() {
        return issueTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.issue_time
     *
     * @param issueTime the value for article.issue_time
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.scan_num
     *
     * @return the value of article.scan_num
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public Integer getScanNum() {
        return scanNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.scan_num
     *
     * @param scanNum the value for article.scan_num
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public void setScanNum(Integer scanNum) {
        this.scanNum = scanNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.img_path
     *
     * @return the value of article.img_path
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.img_path
     *
     * @param imgPath the value for article.img_path
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.summary
     *
     * @return the value of article.summary
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public String getSummary() {
        return summary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.summary
     *
     * @param summary the value for article.summary
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.content
     *
     * @return the value of article.content
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.content
     *
     * @param content the value for article.content
     *
     * @mbg.generated Sun May 26 17:43:23 CST 2019
     */
    public void setContent(String content) {
        this.content = content;
    }
}