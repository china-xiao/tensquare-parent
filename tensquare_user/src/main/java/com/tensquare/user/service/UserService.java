package com.tensquare.user.service;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/11 9:57
 * @Version: 0.0.1
 **/
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User login(User user) {
        return userDao.selectOne(user);
//        return user;
    }

    public User findOne(String id) {
        return userDao.selectById(id);
//        User user = new User();
//        user.setId("123456789");
//        user.setNickname("zhanga");
//        return user;
    }
}
