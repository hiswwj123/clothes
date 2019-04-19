package com.wangjun.service;

import com.wangjun.bean.User;
import com.wangjun.ui.BusinessException;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 9:56
 */
public interface UserService {
    //用户注册
    public User register(User user) throws BusinessException;
    //用户注册，注册到数据库中
    public void registerDB(User user)throws BusinessException;
    //用户登录
    public User login(String username,String pasword) throws BusinessException;
}
