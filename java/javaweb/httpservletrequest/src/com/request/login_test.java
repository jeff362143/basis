package com.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class login_test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURL());
        String s = req.getParameter("user");
        System.out.println(s);
        String s1 = "xzjeff";
        if(s.equals(s1)){
            resp.getWriter().write("welecome,my com.web friend!");
        }
        else {
            resp.getWriter().write("error!");
        }
    }
}
