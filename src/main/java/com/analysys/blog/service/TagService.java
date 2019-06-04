package com.analysys.blog.service;

import com.analysys.blog.common.JsonResult;

/**
 * @author zhaofeng
 * @date 2019/5/24
 */

public interface TagService {
    
    /**
     * 根据标签id获取标签
     *
     * @param
     * @return 
     */
    JsonResult getTagByTagId(Integer tagId);


    /**
     * 获取热门标签
     *
     * @param
     * @return 
     */
    JsonResult getPopularTag();


    /**
     * 添加标签
     *
     * @param
     * @return
     */
    JsonResult addTag(String tagName);
}
