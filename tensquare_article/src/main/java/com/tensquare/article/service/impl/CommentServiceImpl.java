package com.tensquare.article.service.impl;

import com.tensquare.article.pojo.vo.Comment;
import com.tensquare.article.repository.CommentDao;
import com.tensquare.article.repository.CommentRepository;
import com.tensquare.article.service.CommentService;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/10 18:01
 * @Version: 0.0.1
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Comment findById(String id) {
        return commentDao.findById(id).get();
    }

    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    public void save(Comment comment) {
        String id = idWorker.nextId() + "";
        comment.set_id(id);

        //初始化数据
        comment.setPublishdate(new Date());
        comment.setThumbup(0);

        commentDao.save(comment);
    }

    public void update(Comment comment) {
        commentDao.save(comment);
    }

    public void deleteById(String id) {
        commentDao.deleteById(id);
    }

    public List<Comment> findByarticleId(String articleId) {
        return commentDao.findByArticleid(articleId);
    }

    public void thumbup(String id) {
        ////查询评论
        //Comment comment = commentDao.findById(id).get();
        ////修改点赞数
        //comment.setThumbup(comment.getThumbup() + 1);
        //commentDao.save(comment);

        //修改条件
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        //修改的数据
        Update update = new Update();
        //在原来的基础上加一
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "comment");
    }

}
