package com.zs.shoporder.controller;

import com.alibaba.fastjson.JSON;
import com.zs.api.IShopOrderService;
import com.zs.api.IShopProductService;
import com.zs.entry.ShopOrder;
import com.zs.entry.ShopProduct;
import com.zs.shoporder.client.ProductClient;
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
    private IShopOrderService orderService;
    @Autowired
    private ProductClient productClient;

    @Value("${text.content}")
    private String textContent;


    @GetMapping("/order/prod/{pid}")
    public ShopOrder order(@PathVariable("pid") Integer pid) {
        log.info(">>客户下单,这时候要调用商品微服务查询商品信息");
        //通过fegin调用商品微服务
        ShopProduct product = productClient.findByPid(pid);
        log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));
        //模拟一次网络延时
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ShopOrder order = new ShopOrder();
        order.setUid(1);
        order.setUsername("测试用户"+textContent);
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.save(order);
        return order;
    }

    @RequestMapping("/order/message")
    public String message() {
        return "高并发下的问题测试";
    }




    @RequestMapping("/create/{name}")
    @GlobalTransactional
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
