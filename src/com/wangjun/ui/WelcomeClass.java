package com.wangjun.ui;

import com.wangjun.bean.User;
import com.wangjun.utils.UserIO;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/16 0016 17:56
 */
public class WelcomeClass extends BaseClass {
    /**
     * ��ʼ��
     */
    public static void start(){
        println(getString("info.welcome"));
        UserIO userIO = new UserIO();
        userIO.readObject();
        boolean flag = true; //����ѭ�������ı��
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
                        //��¼����
                        HomeClass.show();
                    } catch (BusinessException e) {
                        println(getString(e.getMessage()));
                        flag =true;
                    }
                    break;
                case 2:
                    flag = false;
                    //ע����һ����������
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
