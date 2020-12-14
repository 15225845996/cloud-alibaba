package com.zs.shoporder.server;

import com.zs.common.entry.order.ShopOrder;

public interface OrderService {

    ShopOrder save(ShopOrder order);
}
