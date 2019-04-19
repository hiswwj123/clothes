package com.wangjun.ui;

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
        try {
            UserIO.readObject();
        } catch (BusinessException e) {
            println(getString(e.getMessage()));
        }
        println(getString("info.welcome"));
        boolean flag = true; //����ѭ�������ı��
        while(flag){
            println(getString("info.login.reg"));
            println(getString("info.select"));
            int select = input.nextInt();
            switch(select){
                case 1:
                    flag = false;
                    try {
                        LoginClass.login();
                        println(getString("login.success"));
                    } catch (BusinessException e) {
                        println(getString("login.error"));
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
                    break;
                default:
                    println(getString("input.error"));
                    flag = true;
                    break;
            }

        }

    }
}
