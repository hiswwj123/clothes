package com.wangjun.ui;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 10:00
 * �Զ����쳣��һ����Ŀ�еĴ�����ʾ������Ҫһ���쳣������
 */
public class BusinessException extends RuntimeException{
    public BusinessException() {
        super();
    }

    public BusinessException(String errorMessage) {
        super(errorMessage);
    }
}
