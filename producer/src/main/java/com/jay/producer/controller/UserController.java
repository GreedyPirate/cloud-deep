package com.jay.producer.controller;

import com.jay.producer.dto.BatchUserInfoRequest;
import com.jay.producer.dto.UserInfoRequest;
import com.jay.producer.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("user")
@RestController
public class UserController {

    @PostMapping("info")
    public User getInfo(@RequestBody UserInfoRequest request) {
        if (request.getUserId() == 1L) {
            throw new IllegalArgumentException("错误的参数");
        }
        return User.of(request.getUserId(), "jay");
    }

    @PostMapping("infos")
    public List<User> getInfos(@RequestBody BatchUserInfoRequest request) {
        return request.getIds().stream().map(t -> {
            User r = new User();
            r.setId(t);
            r.setName("jay" + t);
            return r;
        }).collect(Collectors.toList());
    }
}
