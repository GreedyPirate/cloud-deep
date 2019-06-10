package com.jay.consumer.service;

import com.jay.consumer.dto.UserOrderListRequest;
import com.jay.consumer.dto.UserOrderListResponse;
import com.jay.consumer.third.vo.BatchUserInfoRequest;
import com.jay.consumer.third.vo.UserInfoResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserOrderService {

    UserOrderListResponse userOrderCenter(UserOrderListRequest request);

    List<UserInfoResponse> batchUserInfos(BatchUserInfoRequest request);

    Boolean combina(UserOrderListRequest request);
}
