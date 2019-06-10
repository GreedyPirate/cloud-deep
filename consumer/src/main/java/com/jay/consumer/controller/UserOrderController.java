package com.jay.consumer.controller;

import com.jay.consumer.dto.UserOrderListRequest;
import com.jay.consumer.dto.UserOrderListResponse;
import com.jay.consumer.service.UserOrderService;
import com.jay.consumer.third.vo.BatchUserInfoRequest;
import com.jay.consumer.third.vo.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("order")
@RestController
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @PostMapping("test")
    public String test() {
        return "ok";
    }

    @PostMapping("user/center")
    public UserOrderListResponse userOrderCenter(@RequestBody UserOrderListRequest request) {
        return userOrderService.userOrderCenter(request);
    }

    @PostMapping("users")
    List<UserInfoResponse> batchUserInfos(@RequestBody BatchUserInfoRequest request) {
        return userOrderService.batchUserInfos(request);
    }

    @PostMapping("combina")
    public Boolean combina(@RequestBody UserOrderListRequest request) {
        return userOrderService.combina(request);
    }
}
