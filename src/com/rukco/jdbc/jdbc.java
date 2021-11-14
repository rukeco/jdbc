package com.rukco.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc {
    public static void main(String[] args) throws Exception{
        //数据库路径
        String url="jdbc:mysql://localhost:3306/db1";
        //用户名
        String user="root";
        //密码
        String password="root";

        //1,导入驱动jar包
        //2,注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库对象
        Connection conn=DriverManager.getConnection(url,user,password);
        //4。定义数据库语句
        String sql="update stu set name='赵三' where id=1";
        //5,获取执行sql的对象Statement
        Statement stmt=conn.createStatement();
        //6,执行sql
        int cout=stmt.executeUpdate(sql);
        //7，处理结果
        System.out.println(cout);
        //8，释放资源
        stmt.close();
        conn.close();
        System.out.println(stmt);
        System.out.println(conn);

    }
}
