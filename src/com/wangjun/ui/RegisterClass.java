package com.wangjun.ui;

import com.wangjun.bean.User;
import com.wangjun.service.UserService;
import com.wangjun.service.impl.UserServiceImpl;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 9:49
 * 要熟记用户界面的作用
 * 1.用户界面仅仅只是用来收集数据的
 * 2.要将数据传给业务层处理
 * 3.然后存入数据库
 */
public class RegisterClass extends BaseClass{
    //注册 (如果注册失败，这个错误是运行时异常，那么就要自定义一个异常)
    public static void register() throws BusinessException{
        println(getString("input.username"));
        String username = input.next();
        println(getString("input.password"));
        String password = input.next();
        User user = new User(username,password);
        //将对象传递给业务层处理代码
        UserService userService = new UserServiceImpl();

        try {
//            userService.register(user); //存入文件中
            userService.registerDB(user);
        } catch (BusinessException e) {
            println(getString(e.getMessage()));
        }
    }
}
