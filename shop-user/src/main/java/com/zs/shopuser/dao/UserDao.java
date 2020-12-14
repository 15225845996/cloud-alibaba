package com.zs.shopuser.dao;

import com.zs.common.entry.user.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<ShopUser,Integer> {
}
