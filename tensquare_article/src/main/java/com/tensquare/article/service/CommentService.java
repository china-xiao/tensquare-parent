package com.tensquare.article.service;

import com.tensquare.article.pojo.vo.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/10 18:01
 * @Version: 0.0.1
 **/
@Service
public interface CommentService {

    Comment findById(String id);

    List<Comment> findAll();

    void save(Comment comment);

    void update(Comment comment);

    void deleteById(String id);

    List<Comment> findByarticleId(String articleId);

    void thumbup(String id);

}
