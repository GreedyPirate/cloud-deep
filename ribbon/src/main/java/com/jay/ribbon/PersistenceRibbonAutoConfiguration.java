package com.jay.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceRibbonAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public IRule iRule(IClientConfig iClientConfig) {
        PersistenceRule persistenceRule = new PersistenceRule();
        persistenceRule.initWithNiwsConfig(iClientConfig);
        return persistenceRule;
    }
}
