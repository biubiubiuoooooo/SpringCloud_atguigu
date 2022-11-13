package com.cao.springcloud.controller;

import com.cao.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
//        int a =10/0;
     return paymentHystrixService.paymentInfo_OK(id);

    }
    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")

    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        try { TimeUnit.MILLISECONDS.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
       return paymentHystrixService.paymentInfo_TimeOut(id);
    }
    public String paymentInfo_TimeOutHandler(Integer id)
    {
        return "我是消费者8003"+"线程池:  "+Thread.currentThread().getName()+" id:  "+id+"\t"+"/(ㄒoㄒ)/~~";
    }

    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }

}
