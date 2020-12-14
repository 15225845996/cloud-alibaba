package com.zs.shoporder.server.impl;

import com.zs.common.entry.order.ShopOrder;
import com.zs.shoporder.mapper.OrderMapper;
import com.zs.shoporder.server.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ShopOrder save(ShopOrder order) {
        ShopOrder save = orderMapper.save(order);
        return save;
    }
}
