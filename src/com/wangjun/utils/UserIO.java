package com.wangjun.utils;

import com.wangjun.bean.User;
import com.wangjun.ui.BusinessException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 10:10
 * ����֮ǰû��ѧϰ���ݿ�֪ʶ�����ｫ������һ�������ļ���
 */
public class UserIO {
    public static List<User> users = new ArrayList<>(); //���user��list����
    public static String USER_FILE = "user.obj"; //���users���ϵ��ļ���

    /**
     * д�����ݶ���
     * @return
     * @throws BusinessException �Զ����쳣
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
     *��ȡ�ļ��е�����
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
     * ��user����浽������
     * @param user user����
     */
    public void add(User user){
      user.setId(users.size()+1); //����userid,���ڱ�ʶÿ���û�����Ψһ��
      users.add(user);
    }

    /**
     * ���ļ��в�����Ӧ���û���Ϣ�������û���Ϣƥ��
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
