package com.zsq.service;

import com.zsq.pojo.Category;

import java.util.List;

public interface CategoryService {
    //新增文章分类
    void add(Category category);

    //列表查询
    List<Category> list();

    //根据id查询分类信息
    Category findById(Integer id);

    //更新分类信息
    void update(Category category);

    //删除某个分类信息
    void delete(Integer id);
}
