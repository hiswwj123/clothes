package com.wangjun.ui;

import com.wangjun.bean.User;
import com.wangjun.utils.UserIO;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/16 0016 17:56
 */
public class WelcomeClass extends BaseClass {
    /**
     * 开始类
     */
    public static void start(){
        println(getString("info.welcome"));
        UserIO userIO = new UserIO();
        userIO.readObject();
        boolean flag = true; //控制循环条件的标记
        loop:while(flag){
            println(getString("info.login.reg"));
            println(getString("info.select"));
            int select = input.nextInt();
            switch(select){
                case 1:
                    flag = false;
                    try {
                        User user = LoginClass.login();
                        println(getString("login.success"));
                        //登录界面
                        HomeClass.show();
                    } catch (BusinessException e) {
                        println(getString(e.getMessage()));
                        flag =true;
                    }
                    break;
                case 2:
                    flag = false;
                    //注册是一个单独的类
                    try {
                        RegisterClass.register();
                        println(getString("reg.success"));
                    } catch (BusinessException e) {
                        println(getString("reg.error"));
                    }
                    break loop;
                default:
                    println(getString("input.error"));
                    flag = true;
                    break;
            }
        }

    }
}
