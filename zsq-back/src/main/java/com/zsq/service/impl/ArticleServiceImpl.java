package com.zsq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zsq.mapper.ArticleMapper;
import com.zsq.pojo.Article;
import com.zsq.pojo.PageBean;
import com.zsq.service.ArticleService;
import com.zsq.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void add(Article article) {
        //补充article属性值
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        article.setCreateUser(id);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        //1.创建PageBean对象
        PageBean<Article> pageBean = new PageBean<>();

        //2.开启分页查询 Mybatis插件PageHelper，需导入相应的坐标
        PageHelper.startPage(pageNum, pageSize);

        //3.调用mapper
        // 需要传递哪些参数？
        // 有了pageHelper后，就不需要再传递pageNum和pageSize
        //由于用户只能查看自己的文章列表，所以还要传id
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> as = articleMapper.list(userId,categoryId,state);
        //page中提供了方法，可以获取PageHelper分页查询后，得到的总记录条数和当前页数据
        Page<Article> p = (Page<Article>) as;
        //把数据填充到Pagebean对象方法中
        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());
        return pageBean;
    }
}
