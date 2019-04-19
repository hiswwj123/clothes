package com.wangjun.ui;

import com.wangjun.bean.User;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/16 0016 17:32
 * uiչʾ�������涼��Ҫ�õ���Щ���õ����ݣ�
 * ���ǰ���Щ���ݳ�ȡ��һ�����н��з�װ��Ȼ������Щ�����̳�
 * ResourceBundle ������ǹ��ʻ���ר��������ȡ�����ļ��õ���
 */
public abstract class BaseClass {
    protected static Scanner input = new Scanner(System.in); //�Ӽ��̻�ȡ���ݵ���
    protected static User currUser; //����һ����ǰUser�����

    private static ResourceBundle r =
            ResourceBundle.getBundle("com.wangjun.res.r");//��ȡ�û������ļ�

    private static ResourceBundle db =
            ResourceBundle.getBundle("com.wangjun.res.db");//��ȡ���ݿ������ļ�
    /**
     * ��ȡ��Դ�ļ��е�����
     * @param key ��Դ�ļ��ļ�
     * @return
     */
    public static String getString(String key){
        return r.getString(key);
    }

    /**
     * ����keyֵ��ȡ���ݿ�������ļ�������
     * @param key ��Դ�ļ��ļ�
     * @return
     */
    public static String getDbConfig(String key){
        return db.getString(key);
    }
    /**
     * ��ӡ����
     * @param s ��ӡ������
     */
    public static void println(String s){
        System.out.println(s);
    }

    /**
     * ��ӡ���������
     * @param s ��ӡ������
     */
    public static void print(String s){
        System.out.print(s);
    }


}
