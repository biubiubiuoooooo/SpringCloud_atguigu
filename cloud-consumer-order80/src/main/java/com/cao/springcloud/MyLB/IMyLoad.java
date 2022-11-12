package com.cao.springcloud.MyLB;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface IMyLoad {
    public ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
