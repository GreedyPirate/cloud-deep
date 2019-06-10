package com.jay.consumer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jay.consumer.dto.UserOrderListRequest;
import com.jay.consumer.dto.UserOrderListResponse;
import com.jay.consumer.service.UserOrderService;
import com.jay.consumer.third.ProducerClient;
import com.jay.consumer.third.vo.BatchUserInfoRequest;
import com.jay.consumer.third.vo.UserInfoRequest;
import com.jay.consumer.third.vo.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private ProducerClient producerClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public UserOrderListResponse userOrderCenter(UserOrderListRequest request) {
        UserInfoResponse userInfo = producerClient.getUserInfo(UserInfoRequest.of(request.getUserId()));
        return UserOrderListResponse.of(userInfo);
    }

    @Override
    public List<UserInfoResponse> batchUserInfos(BatchUserInfoRequest request) {
        return producerClient.batchUserInfos(request);
    }

    @Override
    public Boolean combina(UserOrderListRequest request) {
        try {
            UserInfoResponse userInfo = producerClient.getUserInfo(UserInfoRequest.of(request.getUserId()));
            return true;
        }catch (Exception e) {
            BatchUserInfoRequest param = new BatchUserInfoRequest();
            List<Long> ids = new ArrayList<>();
            ids.add(request.getUserId());
            param.setIds(ids);
            List<UserInfoResponse> userInfoResponses = producerClient.batchUserInfos(param);
            try {
                String ret = objectMapper.writeValueAsString(userInfoResponses);
                System.out.println("ret = " + ret);
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            }
            return false;
        }
    }
}
