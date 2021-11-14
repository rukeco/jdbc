package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        System.out.println("HELLO world!");
        //1，导入jar包
        //2,注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3,获取数据库连接对象
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
        //4,定义sql语句
        String sql="update stu set name='钱七' where id=3";
        //5,获取执行sql的对象Statement
        Statement stmt=conn.createStatement();
        //6,执行sql
        int cout=stmt.executeUpdate(sql);
        //7,处理结果
        System.out.println(cout);
        //8,释放资源
        stmt.close();
        conn.close();



    }
}
