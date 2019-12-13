package com.tensquare.article.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/10 17:30
 * @Version: 0.0.1
 **/
@Service
public interface ArticleService {

    public List<Article> findAll();

    public Article findById(String id);

    void add(Article article);

    void update(Article article);

    void delete(String id);

    Page search(Map map, int page, int size);
}
