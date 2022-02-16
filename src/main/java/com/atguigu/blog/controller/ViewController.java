package com.atguigu.blog.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @create 2022-02-10 19:44
 */
@Controller
public class ViewController {

    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
    @RequestMapping("/blog.html/{id}")
    public String blog(@PathVariable("id") String id, Model model){
        model.addAttribute("id",id);
        return "blog";
    }
    @RequestMapping("/blog.html")
    public String blog(){
        return "blog";
    }
    @RequestMapping("/tags.html")
    public String tags(){
        return "tags";
    }
    @RequestMapping("/types.html")
    public String types(){
        return "types";
    }
    @RequestMapping("/archives.html")
    public String archives(){
        return "archives";
    }
    @RequestMapping("/about.html")
    public String about(){
        return "about";
    }
    @RequestMapping("/search.html")
    public String search(){
        return "search";
    }
    @RequestMapping("/search.html/{searchData}")
    public String search(@PathVariable("searchData") String searchData, Model model){
        model.addAttribute("searchData",searchData);
        return "search";
    }


}
