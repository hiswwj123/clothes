package com.wangjun.utils;

import com.wangjun.bean.User;
import com.wangjun.ui.BaseClass;
import com.wangjun.ui.BusinessException;

import java.sql.*;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/17 0017 22:09
 */
public class DataBaseUtils extends BaseClass {
    public static PreparedStatement pst = null; //�������ݿ�洢����
    /**
     * ��ȡ���ݿ�����
     * @return �������ݿ����Ӷ���
     * @throws BusinessException �Զ����쳣
     */
    public static Connection getConn() throws BusinessException{
        String driver = getDbConfig("jdbc.driver");
        String url = getDbConfig("jdbc.url");
        String username = getDbConfig("jdbc.username");
        String password = getDbConfig("jdbc.password");
        //ע��jdbc����
        Connection conn = null;
        try {
            Class.forName(driver);
            //������
            conn = DriverManager.getConnection(url,username,password);
            println(getString("sql.start"));
        } catch (ClassNotFoundException |SQLException e) {
          e.printStackTrace();
        }
        return conn;
    }

    /**
     * �ر����ݿ�����
     * @param conn ���ݿ����Ӷ���
     * @throws BusinessException �Զ����쳣
     */
    public static void closeSql(Connection conn)throws BusinessException{
        if(conn != null){
            try {
                conn.close();
                println(getString("sql.close"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ����������������ݿ�
     * @param conn ���ݿ����Ӷ���
     * @param id �û�id
     * @param name �û�����
     * @param password �û�����
     * @throws BusinessException �Զ����쳣
     */
    public static void batchInserts(Connection conn,int id,String name,String password)throws BusinessException{
        //����һ��sql���
        String sql = "insert into userinfo(id,username,password) values(?,?,?)";

        try {
            //����jdbc�Ĵ洢����
            pst = conn.prepareStatement(sql);
            // ��ѭ����������ӵ�sqlģ����
                pst.setInt(1,id);
                pst.setString(2, name);
                pst.setString(3, password);
                pst.addBatch();
            // ��sql��䷢�͵�mysql��
                pst.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * ��ȡ���ݿ��е�����
     * @param username
     * @param password
     * @throws BusinessException
     */
    public static User findUserByDatabase(String username,String password) throws BusinessException{
        User user = new User(username,password);
        ResultSet rs = null;
        //����һ����ѯ���ݿ��sql���
        String sql = "select id,username,password from userinfo";
        try {
            rs = pst.executeQuery(sql); //ͨ��executeQuery()�������ж�ȡ���ݿ�
            while (rs.next()){
                String userName = rs.getString("username");
                String passWord = rs.getString("password");

                if(username.equals(userName) && password.equals(passWord)){
                    return user;
                }
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
