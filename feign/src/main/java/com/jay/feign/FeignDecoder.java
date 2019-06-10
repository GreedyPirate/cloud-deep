package com.jay.feign;

import com.jay.web.mvc.ResponseModel;
import feign.FeignException;
import feign.Response;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

import static com.jay.web.mvc.ResponseModel.RIGHT_CODE;

/**
 *
 *
 * @author yangjie
 * @since 1.0.0
 * @createTime 2019/5/31
 */
public class FeignDecoder extends SpringDecoder{

    public FeignDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        super(messageConverters);
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        Object result = super.decode(response, type);
        if(result instanceof ResponseModel) {
            validate(result);
        }
        return result;
    }

    private void validate(Object result) {
        ResponseModel response = (ResponseModel) result;
        if(response.getCode().equals(RIGHT_CODE)) {
            throw new CodeableFeignException(new ExceptionEnums() {
                @Override
                public Integer getCode() {
                    return response.getCode();
                }

                @Override
                public String getMessage() {
                    return response.getMessage();
                }
            });
        }
    }
}
