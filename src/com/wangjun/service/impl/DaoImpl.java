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
     * ���������
     * @param users ����û��ļ���
     * @param conn ���ݿ����Ӷ���
     * @throws BusinessException �Զ����쳣
     */
    @Override
    public void insert(List<User> users, Connection conn) throws BusinessException {
        //����user����,ѭ���õ�username,password
        for (User user:users) {
            String userName = user.getUserName();
            String passWord = user.getPassWord();
            int id = user.getId();
            //���ò������ݿ�ķ���������ڹ�������
            DataBaseUtils dataBaseUtils = new DataBaseUtils();
            dataBaseUtils.batchInserts(conn,id,userName,passWord);
        }
    }

    @Override
    public void select(User user, Connection conn) throws BusinessException {

    }
}
