package com.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class httpServletRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      这两个都是HttpServletRequest类的常用方法
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        String name = req.getParameter("user");
        String password = req.getParameter("password");
//      值得注意的是，hobby存在多个值，要使用数组存储
        String []hobby = req.getParameterValues("hobby");
        System.out.println("用户账号是"+name);
        System.out.println("用户密码是"+password);
        System.out.println("用户爱好有"+ Arrays.asList(hobby));



//       但是由于字符集问题，出现乱码
        System.out.println(resp.getCharacterEncoding());
//        我们需要设置服务器端的字符编码，还要设置客户端的字符编码
//         resp.setCharacterEncoding("UTF-8");
//         resp.setHeader("Content-Type","text/html;charset=UFT-8");

//      可以同时设置服务器和客户端的字符编码
        resp.setContentType("text/html;charset=UTF-8");

        //      HttpServletResponse类的使用
        PrintWriter writer = resp.getWriter();
        writer.write("it's a response（回应）!!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
