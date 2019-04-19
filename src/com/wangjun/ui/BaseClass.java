package com.wangjun.ui;

import com.wangjun.bean.User;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/16 0016 17:32
 * ui展示的类里面都需要用到这些公用的内容，
 * 我们把这些内容抽取到一个类中进行封装，然后让那些类来继承
 * ResourceBundle 这个类是国际化中专门用来读取配置文件用的类
 */
public abstract class BaseClass {
    protected static Scanner input = new Scanner(System.in); //从键盘获取数据的类
    protected static User currUser; //定义一个当前User类对象

    private static ResourceBundle r =
            ResourceBundle.getBundle("com.wangjun.res.r");//读取用户配置文件

    private static ResourceBundle db =
            ResourceBundle.getBundle("com.wangjun.res.db");//读取数据库配置文件
    /**
     * 获取资源文件中的内容
     * @param key 资源文件的键
     * @return
     */
    public static String getString(String key){
        return r.getString(key);
    }

    /**
     * 根据key值获取数据库的配置文件的内容
     * @param key 资源文件的键
     * @return
     */
    public static String getDbConfig(String key){
        return db.getString(key);
    }
    /**
     * 打印内容
     * @param s 打印的内容
     */
    public static void println(String s){
        System.out.println(s);
    }

    /**
     * 打印输出不换行
     * @param s 打印的内容
     */
    public static void print(String s){
        System.out.print(s);
    }


}
