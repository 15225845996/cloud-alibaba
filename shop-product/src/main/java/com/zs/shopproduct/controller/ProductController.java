package com.zs.shopproduct.controller;

import com.alibaba.fastjson.JSON;
import com.zs.common.entry.product.ShopProduct;
import com.zs.shopproduct.server.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zs
 * @Date: 2020/9/1 11:42
 * @Description:
 */
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/product/{pid}")
    public ShopProduct product(@PathVariable("pid") Integer pid) {
        ShopProduct product = productService.findById(pid);
        log.info("查询到商品:" + JSON.toJSONString(product));
        return product;
    }

    @GetMapping("/reduceInventory")
    public Object reduceInventory(Integer pid,Integer num) {
        boolean b = productService.reduceInventory(pid, num);
        log.info("扣库存:" + b);
        return b;
    }



    @GetMapping("/create/{name}")
    //@GlobalTransactional
    public ShopProduct create(@PathVariable("name") String name) {
        ShopProduct product = new ShopProduct();
        product.setPname(name);
        productService.save(product);
        log.info("创建商品:" + JSON.toJSONString(product));
        return product;
    }
}
