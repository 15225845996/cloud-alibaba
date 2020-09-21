package com.zs.shoporder.client.fallback;

import com.zs.entry.ShopProduct;
import com.zs.shoporder.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Auther: zs
 * @Date: 2020/9/2 11:45
 * @Description:
 */
@Component
@Slf4j
public class ProductClientFallback implements ProductClient {
    @Override
    public ShopProduct findByPid(Integer pid) {
        ShopProduct shopProduct = new ShopProduct();
        shopProduct.setPid(pid*-1);
        return shopProduct;
    }

    @Override
    public ShopProduct create(String name) {
        ShopProduct shopProduct = new ShopProduct();
        shopProduct.setPid(-1);
        shopProduct.setPname("创建异常");
        return shopProduct;
    }
}
