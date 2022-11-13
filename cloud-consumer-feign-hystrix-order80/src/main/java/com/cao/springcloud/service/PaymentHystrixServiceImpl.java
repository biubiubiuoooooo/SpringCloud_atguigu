package com.cao.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService{


    @Override
    public String paymentInfo_OK(Integer id) {
        return "Impl_ok异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "Impl_timeout异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
