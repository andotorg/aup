package org.andot.timing.dao;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ConnDataBase {

    public Integer conMysql(String ip, Integer point, String dbName, String uname, String upwd, Integer dbType) throws SQLException {
        Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
        // 下面语句之前就要先创建javademo数据库
        String url = "jdbc:mysql://"+ip+":"+point+"/"+dbName+"?"
                + "user="+uname+"&password="+upwd+"&useUnicode=true&characterEncoding=UTF8";
        int count = 0;
        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过lass.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
            if(dbType == 1)   //mysql
                Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动

            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = conn.createStatement();
            sql = "SHOW FULL PROCESSLIST";
            ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
            while (rs.next()) {
                count++;
                System.out.print(" | "+rs.getInt(1));// 入如果返回的是int类型可以用getInt()
                System.out.print(" | "+rs.getString(2));// 入如果返回的是int类型可以用getInt()
                System.out.print(" | "+rs.getString(3));// 入如果返回的是int类型可以用getInt()
                System.out.print(" | "+rs.getString(4));// 入如果返回的是int类型可以用getInt()
                System.out.print(" | "+rs.getString(5));// 入如果返回的是int类型可以用getInt()
                System.out.print(" | "+rs.getString(6));// 入如果返回的是int类型可以用getInt()
                System.out.print(" | "+rs.getString(7));// 入如果返回的是int类型可以用getInt()
                System.out.println(" | "+rs.getString(8));// 入如果返回的是int类型可以用getInt()
            }

        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return count;
    }
}
