package com.atguigu.blog.servier.impl;

import com.atguigu.blog.dao.TypeMapper;
import com.atguigu.blog.pojo.Type;
import com.atguigu.blog.servier.TypeService;
import com.atguigu.blog.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2022-01-25 17:23
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    /**
     * 新增分类
     * @param type
     * @return
     */
    @Override
    public boolean create(Type type) {

        //查询此分类名是否可用
        List<Type> typeList = typeMapper.selectByName(type.getName());
        if (typeList != null && typeList.size() != 0){
            return false;
        }

        //分类名可用，添加分类
        //生成id
        type.setId(UUIDUtils.getId());
        //添加分类
        int count2 = typeMapper.insert(type);

        if (count2 < 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        int count = typeMapper.deleteByPrimaryKey(id);
        if (count < 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Type type) {
        int count = typeMapper.updateByPrimaryKey(type);
        if (count < 1){
            return false;
        }
        return true;
    }

    @Override
    public List<Type> select() {
        List<Type> typeList = typeMapper.selectByExample(null);

        return typeList;
    }
}
