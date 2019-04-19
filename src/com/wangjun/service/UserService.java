package com.wangjun.service;

import com.wangjun.bean.User;
import com.wangjun.ui.BusinessException;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 9:56
 */
public interface UserService {
    //�û�ע��
    public void register(User user) throws BusinessException;
    //�û�ע�ᣬע�ᵽ���ݿ���
    public void registerDB(User user)throws BusinessException;
    //�û���¼
    public User login(User user) throws BusinessException;
}
