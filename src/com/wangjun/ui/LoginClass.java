package com.wangjun.ui;

import com.wangjun.bean.User;
import com.wangjun.service.UserService;
import com.wangjun.service.impl.UserServiceImpl;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 16:54
 */
public class LoginClass extends BaseClass {

    public static User login()throws BusinessException{
        println(getString("input.username"));
        String username = input.next();
        println(getString("input.password"));
        String password = input.next();
        User user = new User(username,password);

        UserService userService = new UserServiceImpl();
        User login = userService.login(username,password);

        if(login != null){
            currUser = login;
        }else {
            throw new BusinessException("login.error");
        }
        return login;
    }
}
