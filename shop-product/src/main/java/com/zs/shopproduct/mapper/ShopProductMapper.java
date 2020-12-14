package com.zs.shopproduct.mapper;

import com.zs.common.entry.product.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zs
 * @since 2020-09-01
 */
public interface ShopProductMapper extends JpaRepository<ShopProduct, Integer> {

}
