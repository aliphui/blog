package com.atguigu.blog.servier.impl;

import com.atguigu.blog.dao.TagMapper;
import com.atguigu.blog.pojo.Tag;
import com.atguigu.blog.servier.TagService;
import com.atguigu.blog.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2022-01-24 16:21
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    /**
     * 新增标签
     * @param tag
     * @return
     */
    @Override
    public boolean create(Tag tag) {

        //查询此标签名是否可用
        List<Tag> tagList = tagMapper.selectByName(tag.getName());
        if (tagList != null && tagList.size() != 0){
            return false;
        }

        //标签名可用，添加标签
        //生成id
        tag.setId(UUIDUtils.getId());
        //添加标签
        int count2 = tagMapper.insert(tag);

        if (count2 < 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        int count = tagMapper.deleteByPrimaryKey(id);
        if (count < 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Tag tag) {
        int count = tagMapper.updateByPrimaryKey(tag);
        if (count < 1){
            return false;
        }
        return true;
    }

    @Override
    public List<Tag> select() {
        List<Tag> tagList = tagMapper.selectByExample(null);

        return tagList;
    }
}
