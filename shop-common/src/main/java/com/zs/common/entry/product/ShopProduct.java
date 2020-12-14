package com.zs.common.entry.product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author zs
 * @since 2020-09-01
 */
@Data
@Entity(name="shop_product")
public class ShopProduct {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer pid;

    private String pname;

    private BigDecimal pprice;

    private Integer stock;


}
