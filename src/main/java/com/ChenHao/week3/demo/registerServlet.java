package com.ChenHao.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class registerServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 插入数据
        try {
            String insertQuery = "INSERT INTO usertable (id, username, password, email, gender, birthday) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, request.getParameter("id"));
            insertStatement.setString(2, request.getParameter("username"));
            insertStatement.setString(3, request.getParameter("password"));
            insertStatement.setString(4, request.getParameter("email"));
            insertStatement.setString(5, request.getParameter("gender"));
            insertStatement.setString(6, request.getParameter("birthday"));
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 查询数据
        try {
            String selectQuery = "SELECT * FROM usertable";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            // 输出 HTML 表格
            printResultSet(response.getWriter(), resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printResultSet(PrintWriter out, ResultSet resultSet) throws SQLException {
        out.println("<html><body>");
        out.println("<table border='1'>");
        out.println("<tr><th>id</th><th>username</th><th>password</th><th>email</th><th>gender</th><th>birthday</th></tr>");

        while (resultSet.next()) {
            // 读取每行数据并输出到表格中
            out.println("<tr>");
            out.println("<td>" + resultSet.getString("id") + "</td>");
            out.println("<td>" + resultSet.getString("username") + "</td>");
            out.println("<td>" + resultSet.getString("password") + "</td>");
            out.println("<td>" + resultSet.getString("email") + "</td>");
            out.println("<td>" + resultSet.getString("gender") + "</td>");
            out.println("<td>" + resultSet.getString("birthday") + "</td>");
            out.println("</tr>");
        }
        out.println("</table></body></html>");
    }

    public void destroy() {
        // 在销毁 Servlet 时关闭数据库连接
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}