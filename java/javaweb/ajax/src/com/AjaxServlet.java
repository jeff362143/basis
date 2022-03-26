package com;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AjaxServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Content-type", "text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        Person person = new Person(1,"jeff");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"jack"));
        personList.add(new Person(2,"jeff"));
        personList.add(new Person(3,"rose"));
        personList.add(new Person(4,"rose"));
        personList.add(new Person(5,"rose"));
        Gson gson = new Gson();
        String s = gson.toJson(personList);

        resp.getWriter().write(s);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setHeader("Access-Control-Allow-Origin", "*");
//        resp.setHeader("Content-type", "text/html;charset=utf-8");
//        req.setCharacterEncoding("utf-8");
            StringBuffer json = new StringBuffer();
            String line = null;
            try {
                BufferedReader reader = req.getReader();
                while((line = reader.readLine()) != null) {
                    json.append(line);
                }
            }
            catch(Exception e) {
                System.out.println(e.toString());
            }
        System.out.println(json.toString());

    }

}
