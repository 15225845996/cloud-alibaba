package com.zs.shoporder.server;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.api.IShopOrderService;
import com.zs.entry.ShopOrder;
import com.zs.shoporder.mapper.ShopOrderMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zs
 * @since 2020-09-01
 */
@Service
public class ShopOrderServiceImpl extends ServiceImpl<ShopOrderMapper, ShopOrder> implements IShopOrderService {

}
