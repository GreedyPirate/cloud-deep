package com.jay.consumer.dto;

import com.jay.consumer.third.vo.UserInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class UserOrderListResponse {

    private UserInfoResponse userInfo;
}
