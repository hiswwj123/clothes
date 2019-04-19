package com.wangjun.bean;

import java.io.Serializable;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/15 0015 22:34
 * �û���
 */
public class User implements Serializable {
    private int id; //�û�id
    private String userName; //��¼��
    private String passWord; //����

    public User(int id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
