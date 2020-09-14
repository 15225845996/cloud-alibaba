package com.zs.shopproduct.controller;

import com.alibaba.fastjson.JSON;
import com.zs.api.IShopProductService;
import com.zs.entry.ShopProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private IShopProductService productService;


    @GetMapping("/product/{pid}")
    public ShopProduct product(@PathVariable("pid") Integer pid) {
        ShopProduct product = productService.getById(pid);
        log.info("查询到商品:" + JSON.toJSONString(product));
        return product;
    }
}
