package com.jay.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class PersistenceRule extends AbstractLoadBalancerRule {

    private IClientConfig iClientConfig;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        this.iClientConfig = iClientConfig;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    private Server choose(ILoadBalancer lb, Object key) {
        return null;
    }
}
