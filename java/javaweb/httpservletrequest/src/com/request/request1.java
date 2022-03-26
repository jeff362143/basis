package com.request;
//request1 请求重定向到了request2
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class request1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("地址已搬迁");
//        这是第一种重定向的方法
//        resp.setStatus(302);
//        resp.setHeader("Location","http://localhost:8080/httpServletRequest/request2");

//        推荐使用第二种重定向方法，更简洁(因为状态码已经固定了)
        resp.sendRedirect("http://localhost:8080/httpServletRequest/request2");
    }
}
