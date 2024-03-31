package com.ChenHao.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    String driver, url, username, password;
    private Connection connection;

    public void init(ServletConfig config) {
        driver = config.getServletContext().getInitParameter("driver");
        url = config.getServletContext().getInitParameter("url");
        username = config.getServletContext().getInitParameter("username");
        password = config.getServletContext().getInitParameter("password");

        // 在此处创建数据库连接
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            // 将 connection 对象存储在类的字段中，以便在其他方法中使用
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        try{
        String sql = "SELECT * FROM usertable WHERE username = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);

        // 执行查询
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            // 用户存在
            out.println("Login Success!!!");
            out.println("Welcome,username");
        } else {
            // 用户不存在
            out.println("Login ERROR!!!");
        }

        // 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        out.println("SQLException: " + e.getMessage());
    }
}
}




