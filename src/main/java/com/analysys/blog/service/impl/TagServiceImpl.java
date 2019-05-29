package com.analysys.blog.service.impl;

import com.analysys.blog.common.ReturnData;
import com.analysys.blog.entity.Tag;
import com.analysys.blog.repository.TagMapper;
import com.analysys.blog.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhaofeng
 * @date 2019/5/24
 */

@Service
public class TagServiceImpl implements TagService {

    private static final Integer DEFAULT_FETCH_NUM_OF_POPULAR_TAG = 20;

    @Resource
    private TagMapper tagMapper;

    @Override
    public ReturnData getTagByTagId(Integer tagId) {

        Tag tag = tagMapper.selectByPrimaryKey(tagId);
        if (tag == null) {
            return ReturnData.buildFailResult("失败");
        }

        return ReturnData.buildSuccessResult(tag);
    }

    @Override
    public ReturnData getPopularTag() {
        List<Tag> tagList = tagMapper.selectPopularTagWithLimitNum(DEFAULT_FETCH_NUM_OF_POPULAR_TAG);

        if (tagList == null || tagList.isEmpty()) {
            return ReturnData.buildFailResult("标签获取失败");
        }

        return ReturnData.buildSuccessResult(tagList);
    }

    @Override
    public ReturnData addTag(String tagName) {
        Tag tag = new Tag();
        tag.setTagName(tagName);
        tagMapper.insert(tag);
        return ReturnData.buildSuccessResult(tag);
    }
}
