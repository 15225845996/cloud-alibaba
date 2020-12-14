package com.zs.shoporder.mapper;

import com.zs.common.entry.order.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zs
 * @since 2020-09-01
 */
public interface OrderMapper extends JpaRepository<ShopOrder,Integer> {

}
