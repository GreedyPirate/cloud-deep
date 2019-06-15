package com.jay.ribbon;

import com.jay.ribbon.rule.PersistenceRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OverridedRibbonProperties.class)
public class OverridedRibbonAutoConfiguraion {

    @Bean
    @ConditionalOnMissingBean
    public IRule iRule(OverridedRibbonProperties properties) {
        PersistenceRule persistenceRule = new PersistenceRule(properties);
        return persistenceRule;
    }
}
