package com.wangjun.test;

import com.wangjun.bean.Clothes;
import com.wangjun.utils.DateUtils;
import com.wangjun.utils.PraseProductXmlUtils;
import com.wangjun.utils.UserIO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/19 0019 17:46
 */
public class Test {
    @org.junit.Test
    public void test(){
        List<Clothes> colthes = PraseProductXmlUtils.getColthes();
        System.out.println(Arrays.toString(colthes.toArray()));
    }

    @org.junit.Test
    public void test1(){
        DateUtils dateUtils = new DateUtils();
        System.out.println(dateUtils.toDate(new Date()));
    }
}
