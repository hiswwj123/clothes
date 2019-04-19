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
    public static PreparedStatement pst = null; //创建数据库存储过程
    /**
     * 获取数据库连接
     * @return 返回数据库连接对象
     * @throws BusinessException 自定义异常
     */
    public static Connection getConn() throws BusinessException{
        String driver = getDbConfig("jdbc.driver");
        String url = getDbConfig("jdbc.url");
        String username = getDbConfig("jdbc.username");
        String password = getDbConfig("jdbc.password");
        //注册jdbc驱动
        Connection conn = null;
        try {
            Class.forName(driver);
            //打开链接
            conn = DriverManager.getConnection(url,username,password);
            println(getString("sql.start"));
        } catch (ClassNotFoundException |SQLException e) {
          e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn 数据库连接对象
     * @throws BusinessException 自定义异常
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
     * 批量将数组插入数据库
     * @param conn 数据库连接对象
     * @param id 用户id
     * @param name 用户姓名
     * @param password 用户密码
     * @throws BusinessException 自定义异常
     */
    public static void batchInserts(Connection conn,int id,String name,String password)throws BusinessException{
        //定义一条sql语句
        String sql = "insert into userinfo(id,username,password) values(?,?,?)";

        try {
            //创建jdbc的存储过程
            pst = conn.prepareStatement(sql);
            // 用循环将数据添加到sql模板中
                pst.setInt(1,id);
                pst.setString(2, name);
                pst.setString(3, password);
                pst.addBatch();
            // 将sql语句发送到mysql上
                pst.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取数据库中的内容
     * @param username
     * @param password
     * @throws BusinessException
     */
    public static User findUserByDatabase(String username,String password) throws BusinessException{
        User user = new User(username,password);
        ResultSet rs = null;
        //定义一个查询数据库的sql语句
        String sql = "select id,username,password from userinfo";
        try {
            rs = pst.executeQuery(sql); //通过executeQuery()方法进行读取数据库
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
