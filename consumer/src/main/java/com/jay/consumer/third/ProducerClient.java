package com.jay.consumer.third;

import com.jay.consumer.third.vo.BatchUserInfoRequest;
import com.jay.consumer.third.vo.UserInfoRequest;
import com.jay.consumer.third.vo.UserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "producer", path = "user")
public interface ProducerClient {

    @RequestMapping(value = "info", method = RequestMethod.POST)
    UserInfoResponse getUserInfo(@RequestBody UserInfoRequest request);

    @RequestMapping(value = "infos", method = RequestMethod.POST)
    List<UserInfoResponse> batchUserInfos(@RequestBody BatchUserInfoRequest request);
}
