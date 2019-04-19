package com.wangjun.ui;

import com.wangjun.bean.User;
import com.wangjun.service.UserService;
import com.wangjun.service.impl.UserServiceImpl;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 9:49
 * Ҫ����û����������
 * 1.�û��������ֻ�������ռ����ݵ�
 * 2.Ҫ�����ݴ���ҵ��㴦��
 * 3.Ȼ��������ݿ�
 */
public class RegisterClass extends BaseClass{
    //ע�� (���ע��ʧ�ܣ��������������ʱ�쳣����ô��Ҫ�Զ���һ���쳣)
    public static void register() throws BusinessException{
        println(getString("input.username"));
        String username = input.next();
        println(getString("input.password"));
        String password = input.next();
        User user = new User(username,password);
        //�����󴫵ݸ�ҵ��㴦�����
        UserService userService = new UserServiceImpl();

        try {
//            userService.register(user); //�����ļ���
            userService.registerDB(user);
        } catch (BusinessException e) {
            println(getString(e.getMessage()));
        }
    }
}
