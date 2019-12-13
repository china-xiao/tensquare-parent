package com.tensquare.article.repository;

import com.tensquare.article.pojo.vo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/10 17:59
 * @Version: 0.0.1
 **/
public interface CommentRepository extends MongoRepository<Comment, String> {
}
