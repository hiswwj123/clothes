package com.wangjun.service;

import com.wangjun.bean.User;
import com.wangjun.ui.BusinessException;

import java.sql.Connection;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/18 0018 11:58
 */
public interface DaoService {
    public void insert(List<User> users, Connection conn) throws BusinessException;
    public void select(User user,Connection conn)throws BusinessException;
}
