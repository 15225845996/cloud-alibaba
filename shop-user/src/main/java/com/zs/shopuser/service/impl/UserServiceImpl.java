package com.zs.shopuser.service.impl;

import com.zs.common.entry.user.ShopUser;
import com.zs.shopuser.dao.UserDao;
import com.zs.shopuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ShopUser findById(Integer id) {
        Optional<ShopUser> optional = userDao.findById(id);
        boolean present = optional.isPresent();
        return present?optional.get():null;
    }
}
