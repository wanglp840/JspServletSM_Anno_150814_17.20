/**
 * @Author: Administrator
 * @Time: 2015/4/1.
 */
package com.wanglp.web.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        String url = ctx.getInitParameter("mySqlUrl");
        String name = ctx.getInitParameter("mySqlUserName");
        String password = ctx.getInitParameter("mySqlPassword");

        Connection connection;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace() ;
        }
        try{
            new com.mysql.jdbc.Driver();
            connection = DriverManager.getConnection(url, name, password);
            ctx.setAttribute("connection",connection);
        } catch(SQLException e){
            e.printStackTrace() ;
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
