package com.wangjun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/21 0021 17:18
 */
public class DateUtils {
    /**
     * ��ȡϵͳʱ��
     * @param date ϵͳʱ��
     * @return
     */
    public String toDate(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
}
