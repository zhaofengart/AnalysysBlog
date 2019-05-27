package com.analysys.blog.service;

import com.analysys.blog.common.ReturnData;

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
    ReturnData getTagByTagId(Integer tagId);


    /**
     * 获取热门标签
     *
     * @param
     * @return 
     */
    ReturnData getPopularTag();
}