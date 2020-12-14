package com.zs.common.entry.order;

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
@Entity(name="shop_order")
public class ShopOrder{


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer oid;

    private Integer uid;

    private String username;

    private Integer pid;

    private String pname;

    private BigDecimal pprice;

    private Integer number;


}
