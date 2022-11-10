package com.cao.springcloud.controller;

import com.cao.springcloud.entities.CommonResult;
import com.cao.springcloud.entities.Payment;
import com.cao.springcloud.service.PaymentService;
import com.cao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * (Payment)表控制层
 */
@RestController
@RequestMapping("payment")
public class PaymentController {
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    //    服务发现
//   private DiscoveryClient discoveryClient;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        return new CommonResult<Payment>(200, "select success， serverPort：" + serverPort, payment);
    }

    @PostMapping("create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int insert = paymentService.insert(payment);
        if(insert>0){
            return new CommonResult(200, "insert success， serverPort：" + serverPort, insert);
        }else {
            return new CommonResult(404,"出错啦");
        }


    }


}