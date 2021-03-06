package com.jay.ribbon.rule;

import com.jay.ribbon.OverridedRibbonProperties;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@NoArgsConstructor
@Slf4j
public class PersistenceRule extends AbstractLoadBalancerRule implements InitializingBean {

    @Value("${ribbon.eager-load.enabled:true}")
    private boolean eager;

    private ConcurrentMap<String, InstanceInfo> cache = new ConcurrentHashMap<>();

    private OverridedRibbonProperties properties;

    public PersistenceRule(OverridedRibbonProperties properties) {
        this.properties = properties;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    private Server choose(ILoadBalancer lb, Object key) {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(eager) {

        }
    }

    private List<InstanceInfo> selectAllInstance() {
        return null;
    }
}
