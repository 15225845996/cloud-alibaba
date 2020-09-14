package com.zs.shoporder.client;

import com.zs.entry.ShopProduct;
import com.zs.shoporder.client.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: zs
 * @Date: 2020/9/1 12:11
 * @Description:
 */
@FeignClient(name = "server-product",fallback = ProductClientFallback.class)
public interface ProductClient {

    @GetMapping(value = "/product/{pid}")
    ShopProduct findByPid(@PathVariable("pid") Integer pid);
}
