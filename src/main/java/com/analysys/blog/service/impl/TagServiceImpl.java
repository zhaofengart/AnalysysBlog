package com.analysys.blog.service.impl;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.common.RtCode;
import com.analysys.blog.entity.Tag;
import com.analysys.blog.repository.TagMapper;
import com.analysys.blog.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
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
    public JsonResult getTagByTagId(Integer tagId) {

        Tag tag = tagMapper.selectByPrimaryKey(tagId);
        if (tag == null) {
            return new JsonResult(RtCode.BAD_REQUEST, "参数错误");
        }

        return new JsonResult(tag);
    }

    @Override
    public JsonResult getPopularTag() {
        List<Tag> tagList = tagMapper.selectPopularTagWithLimitNum(DEFAULT_FETCH_NUM_OF_POPULAR_TAG);

        if (tagList == null || tagList.isEmpty()) {
            return new JsonResult<>(RtCode.DB_ERROR, "数据库错误");
        }

        for (int i = 0; i < tagList.size(); i++) {
            Tag tag = tagList.get(i);
            if (i < 5) {
                tag.setSize("28px");
                continue;
            }
            if (i < 9) {
                tag.setSize("22px");
                continue;
            }
            if (i < 17) {
                tag.setSize("16px");
                continue;
            }
            if (i < 20) {
                tag.setSize("12px");
                continue;
            }
        }

        Collections.shuffle(tagList);


        return new JsonResult<>(tagList);
    }

    @Override
    public JsonResult getAllTag() {
        List<Tag> tagList = tagMapper.selectPopularTagWithLimitNum(null);

        if (tagList == null || tagList.isEmpty()) {
            return new JsonResult<>(RtCode.DB_ERROR, "数据库错误");
        }

        return new JsonResult<>(tagList);
    }

    @Override
    public JsonResult addTag(String tagName) {
        Tag tag = new Tag();
        tag.setTagName(tagName);
        tagMapper.insert(tag);
        return new JsonResult(tag);
    }
}
