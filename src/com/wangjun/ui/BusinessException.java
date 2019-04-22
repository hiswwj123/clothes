package com.wangjun.ui;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 10:00
 * 自定义异常，一般项目中的错误提示，都需要一个异常来管理
 */
public class BusinessException extends RuntimeException{
    public BusinessException() {
        super();
    }

    public BusinessException(String errorMessage) {
        super(errorMessage);
    }
}
