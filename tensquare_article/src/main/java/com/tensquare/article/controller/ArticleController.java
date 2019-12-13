package com.tensquare.article.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/10 17:33
 * @Version: 0.0.1
 **/
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List list = articleService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        Article article = articleService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", article);
    }

    //新增标签数据接口
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article) {
        articleService.add(article);

        return new Result(true, StatusCode.OK, "添加成功");
    }

    //修改标签数据接口
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody Article article) {
        article.setId(id);
        articleService.update(article);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    //删除文章数据接口
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        articleService.delete(id);

        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value="/search/{page}/{size}", method = RequestMethod.POST)
    public Result search(@RequestBody Map map, @PathVariable int page, @PathVariable int size) {
        Page page1 = articleService.search(map, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult((long) page1.getTotal(), page1.getRecords()));
    }

    @RequestMapping(value="/exception", method = RequestMethod.GET)
    public Result exception() throws Exception {
        throw new Exception("测试统一异常处理");
    }

}
