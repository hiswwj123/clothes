package com.wangjun.utils;

import com.wangjun.bean.User;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 17:00
 */
public class EmptyUtils {
    /**
     * �ж��ַ����Ƿ�Ϊ��
     * @param s �ַ���
     * @return
     */
    public Boolean isEmpty(String s){
        if(s ==null && "".equals(s)){
            return true;
        }else{
            return false;
        }
    }
}
