package com.jay.feign;

import feign.FeignException;

public class CodeableFeignException extends FeignException {

    private ExceptionEnums exceptionEnums;

    protected CodeableFeignException(String message, Throwable cause) {
        super(message, cause);
    }

    protected CodeableFeignException(String message) {
        super(message);
    }

    public CodeableFeignException(ExceptionEnums exceptionEnums) {
        super(exceptionEnums.getMessage());
    }

}
