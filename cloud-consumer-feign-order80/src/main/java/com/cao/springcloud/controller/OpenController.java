package com.cao.springcloud.controller;

import com.cao.springcloud.entities.CommonResult;
import com.cao.springcloud.entities.Payment;
import com.cao.springcloud.service.FeignSer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("payment")
public class OpenController {

    @Resource
    private FeignSer feign;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id){
        return feign.selectOne(id);
    }

}
