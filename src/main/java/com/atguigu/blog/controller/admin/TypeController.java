package com.atguigu.blog.controller.admin;

import com.atguigu.blog.pojo.Type;
import com.atguigu.blog.servier.TypeService;
import com.atguigu.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @create 2022-01-24 16:15
 */
@RestController
@RequestMapping("/admin/types")
public class TypeController {

    @Autowired
    TypeService typeService;

    /**
     * 创建分类
     */
    @PostMapping()
    public R create(@RequestBody Type type){

        boolean flag = typeService.create(type);

        return new R(flag);
    }
    /**
     * 查询分类
     */
    @GetMapping()
    public R select(){

        List<Type> typeList = typeService.select();

        return new R(true,typeList);
    }
    /**
     * 修改分类
     */
    @PutMapping()
    public R update(@RequestBody Type type){

        boolean flag = typeService.update(type);

        return new R(flag);
    }

    /**
     * 删除分类
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") String id){

        boolean flag = typeService.delete(id);

        return new R(flag);
    }
}
