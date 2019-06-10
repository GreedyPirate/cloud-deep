package com.jay.consumer.third.vo;

import lombok.Data;

import java.util.List;

@Data
public class BatchUserInfoRequest {

    private List<Long> ids;
}
