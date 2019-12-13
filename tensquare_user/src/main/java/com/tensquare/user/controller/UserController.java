package com.tensquare.user.controller;

import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/11 9:58
 * @Version: 0.0.1
 **/
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        User result = userService.login(user);

        if (result != null) {
            return new Result(true, StatusCode.OK, "登录成功", result);
        }

        return new Result(false, StatusCode.OK, "登录失败");
    }

    @GetMapping(value="/{id}")
    public Result findOne(@PathVariable String id) {
        User result = userService.findOne(id);

        if (result != null) {
            return new Result(true, StatusCode.OK, "查询成功", result);
        }

        return new Result(false, StatusCode.OK, "查询失败");
    }



}
