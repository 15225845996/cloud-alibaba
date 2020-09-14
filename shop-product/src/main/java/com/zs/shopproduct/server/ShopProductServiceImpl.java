package com.zs.shopproduct.server;

import com.zs.api.IShopProductService;
import com.zs.entry.ShopProduct;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.shopproduct.mapper.ShopProductMapper;
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
public class ShopProductServiceImpl extends ServiceImpl<ShopProductMapper, ShopProduct> implements IShopProductService {

}
