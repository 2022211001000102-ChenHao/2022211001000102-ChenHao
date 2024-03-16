package com.ChenHao.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//now it's just a java class
//extend HttpServlet
public class helloworldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //when client request method is Get - here - inside doGet()
        //we want to send Hello to client
        //we need write Hello in response
        //get write - java.io
        PrintWriter writer = response.getWriter();
        writer.println("Name: ChenHao");
        writer.println("ID:2022211001000102");
        writer.println("Date and time: Sun Mar 10 18:00:32 CST 2024");//that's all
        //next we need to tell about this servlet to tomcat - how ? - web.xml
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
