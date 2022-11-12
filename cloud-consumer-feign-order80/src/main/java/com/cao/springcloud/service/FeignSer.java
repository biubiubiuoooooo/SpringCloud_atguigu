package com.cao.springcloud.service;

import com.cao.springcloud.entities.CommonResult;
import com.cao.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(value = "cloud-payment-service")
public interface FeignSer {
    @GetMapping("payment/get/{id}")
    CommonResult<Payment> selectOne(@PathVariable("id") Long id);
}
