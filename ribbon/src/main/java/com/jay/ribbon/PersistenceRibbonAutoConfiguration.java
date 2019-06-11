package com.jay.ribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "persistence-ribbon.enable", havingValue = "true", matchIfMissing = false)
@EnableConfigurationProperties(PersistenceRibbonProperties.class)
public class PersistenceRibbonAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public IRule iRule(PersistenceRibbonProperties properties) {
        PersistenceRule persistenceRule = new PersistenceRule(properties);
        return persistenceRule;
    }
}
