package com.zs.shopproduct.server;

import com.zs.common.entry.product.ShopProduct;
import sun.security.provider.SHA;

public interface ProductService {
    ShopProduct findById(Integer id);
    ShopProduct save(ShopProduct product);
    boolean reduceInventory(Integer pid,int num);
}
