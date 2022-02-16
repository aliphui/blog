package com.atguigu.blog.controller.admin;

import com.atguigu.blog.pojo.Tag;
import com.atguigu.blog.servier.TagService;
import com.atguigu.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @create 2022-01-24 16:15
 */
@RestController
@RequestMapping("/admin/tags")
public class TagController {

    @Autowired
    TagService tagService;

    /**
     * 查询标签
     */
    @GetMapping()
    public R select(){

        List<Tag> tagList = tagService.select();

        return new R(true,tagList);
    }
    /**
     * 修改标签
     */
    @PutMapping()
    public R update(@RequestBody Tag tag){

        boolean flag = tagService.update(tag);

        return new R(flag);
    }

    /**
     * 删除标签
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") String id){

        boolean flag = tagService.delete(id);

        return new R(flag);
    }
    /**
     * 创建标签
     */
    @PostMapping()
    public R create(@RequestBody Tag tag){

        boolean flag = tagService.create(tag);

        return new R(flag);
    }



}
