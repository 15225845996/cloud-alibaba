package com.zs.shopproduct.server.impl;

import com.zs.common.entry.product.ShopProduct;
import com.zs.shopproduct.mapper.ShopProductMapper;
import com.zs.shopproduct.server.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ShopProductMapper shopProductMapper;

    @Override
    public ShopProduct findById(Integer id) {
        Optional<ShopProduct> byId = shopProductMapper.findById(id);
        return byId.isPresent()?byId.get():null;
    }

    @Override
    public ShopProduct save(ShopProduct product) {
        ShopProduct save = shopProductMapper.save(product);
        return save;
    }

    @Override
    public boolean reduceInventory(Integer pid, int num) {
        ShopProduct product = shopProductMapper.findById(pid).get();
        product.setStock(product.getStock() - num);
        shopProductMapper.save(product);
        int i = 10/0;
        return true;
    }
}
