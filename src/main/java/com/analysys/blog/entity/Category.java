package com.analysys.blog.entity;

public class Category {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.category_id
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.category_name
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    private String categoryName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.category_id
     *
     * @return the value of category.category_id
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.category_id
     *
     * @param categoryId the value for category.category_id
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.category_name
     *
     * @return the value of category.category_name
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.category_name
     *
     * @param categoryName the value for category.category_name
     *
     * @mbg.generated Sun May 26 17:07:11 CST 2019
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}