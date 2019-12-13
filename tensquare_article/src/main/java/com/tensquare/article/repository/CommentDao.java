package com.tensquare.article.repository;

import com.tensquare.article.pojo.vo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/10 18:07
 * @Version: 0.0.1
 **/
public interface CommentDao extends MongoRepository<Comment, String> {
    //根据文章id查询评论列表
    List<Comment> findByArticleid(String articleId);
}
