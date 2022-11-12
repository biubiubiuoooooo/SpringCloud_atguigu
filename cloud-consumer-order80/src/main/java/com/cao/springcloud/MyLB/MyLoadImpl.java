package com.cao.springcloud.MyLB;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public class MyLoadImpl implements IMyLoad{

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        return null;
    }
}
