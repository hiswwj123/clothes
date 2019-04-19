package com.wangjun.service.impl;

import com.wangjun.bean.User;
import com.wangjun.service.DaoService;
import com.wangjun.service.UserService;
import com.wangjun.ui.BusinessException;
import com.wangjun.utils.DataBaseUtils;
import com.wangjun.utils.EmptyUtils;
import com.wangjun.utils.UserIO;

import java.sql.Connection;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 10:05
 */
public class UserServiceImpl implements UserService {
    //注册,将数据存到文件中
    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        //将对象存到集合中
        userIO.add(user);
        //将数据写入到文件中
        userIO.wrieObject();
        return user;
    }
    //注册将数据存到数据库中
    @Override
    public void registerDB(User user) throws BusinessException {
        DataBaseUtils dataBaseUtils = new DataBaseUtils();
        Connection conn = dataBaseUtils.getConn();
        UserIO userIO = new UserIO();
        //将对象存到集合中
        userIO.add(user);
        DaoService daoService = new DaoImpl();
        daoService.insert(userIO.users,conn);
        dataBaseUtils.closeSql(conn);
    }

    //登录
    @Override
    public User login(String username,String password) throws BusinessException {
        //创建一个判断为空的工具类
        EmptyUtils emptyUtils = new EmptyUtils();
        //判断用户名是否为空或者为空字符串
        if(emptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        //判断密码是不是为空或者为空字符串
        if(emptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }

        UserIO userIO = new UserIO();
        //判断输入的用户是否为文件中已有的用户
        User userList = userIO.findUserByList(username, password);
        return userList;

//        DataBaseUtils dataBaseUtils = new DataBaseUtils();
//        User userByDatabase = dataBaseUtils.findUserByDatabase(user.getUserName(), user.getPassWord());
//        return userByDatabase;
    }
}
