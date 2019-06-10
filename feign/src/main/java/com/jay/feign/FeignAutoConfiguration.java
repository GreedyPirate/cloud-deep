package com.jay.feign;

import feign.Logger;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FeignProperties.class)
public class FeignAutoConfiguration {

    @Bean
    public Decoder decoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        return new FeignDecoder(messageConverters);
    }

    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.FULL;
    }
}
