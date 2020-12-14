package com.zs.shoporder.controller;

import com.alibaba.fastjson.JSON;
import com.zs.common.entry.order.ShopOrder;
import com.zs.common.entry.product.ShopProduct;
import com.zs.shoporder.client.ProductClient;
import com.zs.shoporder.server.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: zs
 * @Date: 2020/9/1 11:42
 * @Description:
 */
@RestController
@Slf4j
@CrossOrigin
@RefreshScope
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductClient productClient;


    @GetMapping("/order/prod/{pid}")
    @GlobalTransactional
    public ShopOrder order(@PathVariable("pid") Integer pid) {
        log.info(">>客户下单,这时候要调用商品微服务查询商品信息");
        //通过fegin调用商品微服务
        ShopProduct product = productClient.findByPid(pid);
        log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));
        ShopOrder order = new ShopOrder();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.save(order);
        log.info(">>扣库存=================");
        productClient.reduceInventory(pid,1);
        return order;
    }

    @RequestMapping("/order/message")
    public String message() {
        return "高并发下的问题测试";
    }




    @RequestMapping("/create/{name}")
    public String create(@PathVariable("name") String name) {
        ShopProduct product = productClient.create(name);

        ShopOrder order = new ShopOrder();
        order.setUid(1);
        order.setUsername(name);
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.save(order);

        int i = 10/0;
        return JSON.toJSONString(order);
    }
}
