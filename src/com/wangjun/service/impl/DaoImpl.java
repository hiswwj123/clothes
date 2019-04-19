package com.wangjun.service.impl;

import com.wangjun.bean.User;
import com.wangjun.service.DaoService;
import com.wangjun.ui.BusinessException;
import com.wangjun.utils.DataBaseUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/18 0018 12:00
 */
public class DaoImpl implements DaoService {
    /**
     * 将数据入库
     * @param users 存放用户的集合
     * @param conn 数据库连接对象
     * @throws BusinessException 自定义异常
     */
    @Override
    public void insert(List<User> users, Connection conn) throws BusinessException {
        //遍历user集合,循环拿到username,password
        for (User user:users) {
            String userName = user.getUserName();
            String passWord = user.getPassWord();
            int id = user.getId();
            //调用插入数据库的方法，这个在工具类中
            DataBaseUtils dataBaseUtils = new DataBaseUtils();
            dataBaseUtils.batchInserts(conn,id,userName,passWord);
        }
    }

    @Override
    public void select(User user, Connection conn) throws BusinessException {

    }
}
