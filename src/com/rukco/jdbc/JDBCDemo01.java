package com.rukco.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//往数据库表中添加一条数据
public class JDBCDemo01 {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql:///db1";
        String user="root";
        String password="root";
        Connection conn=null;
        Statement stmt=null;
       //1,注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2，定义sql
            String sql="insert into stu values(5,'李四')";
            //3.获取Connection对象
            conn=DriverManager.getConnection(url,user,password);
            //4，获取执行sql的对象Statement
            stmt=conn.createStatement();
            //5，执行sql
            int count=stmt.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if(count>0){

                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }

            //conn.close();
            //stmt.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //stmt.close();
            // 7.释放资源
            //避免空指针异常
            if (stmt!=null){

                try{
                    stmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }

            if (conn!=null){

                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }

            }

        }

    }
}
