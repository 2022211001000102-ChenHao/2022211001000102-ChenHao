package com.ChenHao.week4.demo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = "/config",
        initParams = {
                @WebInitParam(name = "name1", value = "ChenHao"),
                @WebInitParam(name = "studentId1", value = "2022211001000102")
        }
)
public class ConfigDemoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletConfig config = getServletConfig();
        String name1 = config.getInitParameter("name1");
        String studentId1 = config.getInitParameter("studentId1");

        out.println("<html><body>");
        out.println("Task1-Get init parameters from @WebServlet:<br/>");
        out.println("Name: " + name1 + "<br/>");
        out.println("Student ID: " + studentId1 + "<br/>");
        out.println("</body></html>");
    }
}
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.ServletException;
//import javax.servlet.ServletConfig;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class ConfigDemoServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        ServletConfig config = getServletConfig();
//
//        // 获取并打印 Servlet 的初始化参数
//        String name = config.getInitParameter("name");
//        String studentId = config.getInitParameter("studentId");
//
//        out.println("<html><body>");
//        out.println("Task1-Get init parameters from web.xml:<br/>");
//        out.println("Name: " + name + "<br/>");
//        out.println("Student ID: " + studentId + "<br/>");
//        out.println("</body></html>");
//    }
//}