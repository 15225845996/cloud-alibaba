package com.zs.shopuser.controller;

import com.zs.common.entry.user.ShopUser;
import com.zs.shopuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo/{id}")
    public ShopUser getUserInfo(@PathVariable("id")Integer id) throws InterruptedException {
        Thread.sleep(500);
        return userService.findById(id);
    }
}
