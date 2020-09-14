package com.zs.shoporder.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zs
 * @Date: 2020/9/1 13:49
 * @Description:
 */
@RestController
@Slf4j
public class OrderController3 {

    @RequestMapping("/order/message1")
    //@SentinelResource(value="hi")
    public String message1() {
        return "message1";
    }
    @RequestMapping("/order/message2")
    public String message2() {
        return "message2";
    }

}
