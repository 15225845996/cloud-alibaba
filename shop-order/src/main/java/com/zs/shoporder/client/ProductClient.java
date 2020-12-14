package com.zs.shoporder.client;

import com.zs.common.entry.product.ShopProduct;
import com.zs.shoporder.client.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: zs
 * @Date: 2020/9/1 12:11
 * @Description:
 */
@FeignClient(name = "server-product",fallback = ProductClientFallback.class)
public interface ProductClient {

    @GetMapping(value = "/product/{pid}")
    ShopProduct findByPid(@PathVariable("pid") Integer pid);

    @GetMapping(value = "/reduceInventory")
    boolean reduceInventory(@RequestParam("pid") Integer pid, @RequestParam("num") Integer num);



    @GetMapping(value = "/create/{name}")
    ShopProduct create(@PathVariable("name") String name);
}
