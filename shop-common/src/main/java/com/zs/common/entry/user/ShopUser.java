package com.zs.common.entry.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>
 * 
 * </p>
 *
 * @author zs
 * @since 2020-09-01
 */
@Data
@Entity(name="shop_user")
public class ShopUser {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer uid;

    private String username;

    private String password;

    private String telephone;



}
