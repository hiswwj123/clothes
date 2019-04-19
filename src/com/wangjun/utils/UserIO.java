package com.wangjun.utils;

import com.wangjun.bean.User;
import com.wangjun.ui.BusinessException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 10:10
 * 由于之前没有学习数据库知识，这里将数据先一步存入文件中
 */
public class UserIO {
    public static List<User> users = new ArrayList<>(); //存放user的list集合
    public static String USER_FILE = "user.obj"; //存放users集合的文件名

    /**
     * 写入数据对象
     * @return
     * @throws BusinessException 自定义异常
     */
    public  boolean wrieObject() throws BusinessException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(USER_FILE));
            out.writeObject(users);
            out.close();
            return true;
        } catch (IOException e) {
            throw new BusinessException("io.write.error");
        }

    }

    /**
     *读取文件中的内容
     * @return
     * @throws BusinessException
     */
    public static boolean readObject() throws BusinessException{
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(USER_FILE));
            users = (List<User>) in.readObject();
            in.close();
            return true;
        } catch (IOException | ClassNotFoundException e) {
           throw new BusinessException("io.read.error");
        }
    }

    /**
     * 把user对象存到集合中
     * @param user user对象
     */
    public void add(User user){
      user.setId(users.size()+1); //设置userid,用于标识每个用户都是唯一的
      users.add(user);
    }

    /**
     * 从文件中查找相应的用户信息与输入用户信息匹对
     * @param username
     * @param password
     * @return
     */
    public User findUserByList(String username,String password){
            for(User u:users){
                if(username.equals(u.getUserName()) && password.equals(u.getPassWord())){
                    return u;
                }
            }
        return null;
    }

}
