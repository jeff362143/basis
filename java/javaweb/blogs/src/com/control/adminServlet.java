package com.control;

import com.google.gson.Gson;
import com.pojo.*;
import com.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class adminServlet extends HttpServlet {
    private BlogListService blogListService = new BlogListService();
    private BlogService blogService = new BlogService();
    private ExpertService expertService = new ExpertService();
    private UserService userService = new UserService();
    private CommentService commentService = new CommentService();
    private MessageService messageService = new MessageService();
    private InformService informService = new InformService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Content-type", "text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        Gson gson = new Gson();
        String action = req.getParameter("action");

//        增加标签
        if(action.equals("addLabel")) {
            String label = req.getParameter("labelName");
            String createTime = req.getParameter("createTime");
            blogService.adminAddLabel(label,createTime);
        }

//        删除标签
        if(action.equals("deleteLabel")) {
            String labelName = req.getParameter("labelName");
            blogService.adminDeleteLabel(labelName);
        }

//        获取推荐博客和非推荐博客
        if(action.equals("getRecoBlog")) {
            String flag = req.getParameter("flag");
            List<BlogDetails> recoBlogService = blogService.getRecoBlogService(flag);
            String json = gson.toJson(recoBlogService);
            resp.getWriter().write(json);
        }

//     修改专家列表信息
        if(action.equals("updateExpert")) {
            String username = req.getParameter("username");
            String desc = req.getParameter("desc");
            String formerUsername = req.getParameter("formerUsername");
            expertService.updateExpertService(formerUsername,username,desc);
            resp.getWriter().write("true");
        }

//        获取用户留言以及根据日期获取
        if(action.equals("getMessage")) {
            String scope1, scope2, flag = "";
            scope1 = req.getParameter("scope1");
            scope2 = req.getParameter("scope2");
            flag = req.getParameter("flag");
            if (flag != "") {
                List<UserMessage> userMessages2 = messageService.userMessagesByScope(scope1, scope2);
                String str2 = gson.toJson(userMessages2);
                resp.getWriter().write(str2);
            } else {
                List<UserMessage> userMessages = messageService.userMessages();
                String str = gson.toJson(userMessages);
                resp.getWriter().write(str);
            }
        }

//     获取全部用户的个人信息
        if(action.equals("getAllUserInfo")) {
            List<User> users = userService.getAllUserInfo();
            String usersJson = gson.toJson(users);
            resp.getWriter().write(usersJson);
        }

//        获取用户全部动态
        if(action.equals("getUserActions")) {
            String json = gson.toJson(userService.getUserActions());
            resp.getWriter().write(json);
        }

//  查找一个用户的个人信息
        if(action.equals("queryByUsername")) {
            String username = req.getParameter("username");
            List<User> user = userService.getUserInfoByUsername(username);
            String usersJson = gson.toJson(user);
            resp.getWriter().write(usersJson);
        }

//   管理举报信息
        if(action.equals("manageSite")) {
            List<ComplainBlog> complainBlogService = blogService.getComplainBlogService();
            String json = gson.toJson(complainBlogService);
            resp.getWriter().write(json);
        }

//        获取数据库中全部博客内容
        if(action.equals("getAllBlogs")) {
            List<BlogDetails> blogs = blogService.adminGetAllBlogDetails();
            String json = gson.toJson(blogs);
            resp.getWriter().write(json);
        }

//        判断是否推荐
        if(action.equals("judgeReco")) {
            String jsonId = req.getParameter("id");
            int id = Integer.parseInt(jsonId);
            if(blogService.JudgeRecoService(id) == 1) {
                resp.getWriter().write("true");
            }else {
                resp.getWriter().write("false");
            }
        }

//        推荐和取消推荐博客
        if(action.equals("setReco")) {
            String flag = req.getParameter("flag");
            String id = req.getParameter("id");
            int blogId = Integer.parseInt(id);
            blogService.setRecoService(flag,blogId);
            resp.getWriter().write("true");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Content-type", "text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        Gson gson = new Gson();
        String action = req.getParameter("action");

//        管理员登录
        if(action.equals("adminLogin")) {
            String json = req.getParameter("json");
            User user = gson.fromJson(json,User.class);
            if(userService.adminLogin(user) != null){
                resp.getWriter().write("true");
            } else {
                resp.getWriter().write("error");
            }
        }

//        保存用户新的账号密码
        if(action.equals("saveNewUserInfo")) {
            String json = req.getParameter("json");
            User user = gson.fromJson(json,User.class);
            userService.updateTableUser(user.getId(),user.getUsername(),user.getPassword());
        }

//        保存新闻
        if(action.equals("saveNews")) {
            String json = req.getParameter("json");
            Blog blog = gson.fromJson(json,Blog.class);
            blogService.updateNews(blog.getTitle(),blog.getContent(),blog.getCreateTime(),blog.getId());
        }

    }
}
