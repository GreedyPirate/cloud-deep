package com.jay.producer.dto;

import lombok.Data;

import java.util.List;

@Data
public class BatchUserInfoRequest {

    private List<Long> ids;
}
