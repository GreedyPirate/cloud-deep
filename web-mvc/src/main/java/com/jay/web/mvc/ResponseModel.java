package com.jay.web.mvc;

import lombok.Data;

@Data
public class ResponseModel<T> {

    public static final int RIGHT_CODE = 0;

    private T data;
    private Integer code;
    private String message;
}
