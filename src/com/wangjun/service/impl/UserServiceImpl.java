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
    //ע��,�����ݴ浽�ļ���
    @Override
    public void register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        //������浽������
        userIO.add(user);
        //������д�뵽�ļ���
        userIO.wrieObject();

    }
    //ע�Ὣ���ݴ浽���ݿ���
    @Override
    public void registerDB(User user) throws BusinessException {
        DataBaseUtils dataBaseUtils = new DataBaseUtils();
        Connection conn = dataBaseUtils.getConn();
        UserIO userIO = new UserIO();
        //������浽������
        userIO.add(user);
        DaoService daoService = new DaoImpl();
        daoService.insert(userIO.users,conn);
        dataBaseUtils.closeSql(conn);
    }

    //��¼
    @Override
    public User login(User user) throws BusinessException {
        //����һ���ж�Ϊ�յĹ�����
        EmptyUtils emptyUtils = new EmptyUtils();
        //�ж��û����Ƿ�Ϊ�ջ���Ϊ���ַ���
        if(emptyUtils.isEmpty(user.getUserName())){
            throw new BusinessException("username.notnull");
        }
        //�ж������ǲ���Ϊ�ջ���Ϊ���ַ���
        if(emptyUtils.isEmpty(user.getPassWord())){
            throw new BusinessException("password.notnull");
        }

        UserIO userIO = new UserIO();
        //�ж�������û��Ƿ�Ϊ�ļ������е��û�
        User userList = userIO.findUserByList(user.getUserName(), user.getPassWord());
        return userList;

//        DataBaseUtils dataBaseUtils = new DataBaseUtils();
//        User userByDatabase = dataBaseUtils.findUserByDatabase(user.getUserName(), user.getPassWord());
//        return userByDatabase;
    }
}
