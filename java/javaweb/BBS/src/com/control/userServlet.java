package com.control;

import com.google.gson.Gson;
import com.pojo.*;
import com.service.IssueCommentService;
import com.service.IssueService;
import com.service.MessageService;
import com.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class userServlet extends HttpServlet {
    private UserService userService = new UserService();
    private IssueService issueService = new IssueService();
    private IssueCommentService issueCommentService = new IssueCommentService();
    private MessageService messageService = new MessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Content-type","text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        Gson gson = new Gson();

            if(action.equals("getIssue")) {
            String sort = req.getParameter("sort");
            List<Issue> issues = issueService.getIssue(sort);
            String issuesJson = gson.toJson(issues);
            resp.getWriter().write(issuesJson);
        }

            if(action.equals("getIssueList")) {
                List<IssueList> issueLists = issueService.getIssueListService();
                String json = gson.toJson(issueLists);
                resp.getWriter().write(json);
            }

        if(action.equals("getIssueById")) {
            String id = req.getParameter("id");
            int Id = Integer.parseInt(id);
            Issue issueByIdService = issueService.getIssueByIdService(Id);
            String json = gson.toJson(issueByIdService);
            resp.getWriter().write(json);
        }

        if(action.equals("getCommentById")) {
            String id = req.getParameter("id");
            int Id = Integer.parseInt(id);
            List<IssueComments> issueCommentService = this.issueCommentService.getIssueCommentService(Id);
            String json = gson.toJson(issueCommentService);
            resp.getWriter().write(json);
        }

        if(action.equals("search")) {
            List<Issue> issues = issueService.getAllIssueService();
            List<Issue> issueList = new ArrayList<>();
            String researchValue = req.getParameter("value");
            for (int i = 0; i < issues.size(); i++) {
                if (issues.get(i).getTitle().indexOf(researchValue) > -1) {
                    issueList.add(issues.get(i));
                }
            }
            String json = gson.toJson(issueList);
            resp.getWriter().write(json);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Content-type","text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        Gson gson = new Gson();

        if(action.equals("login")) {
            String json = req.getParameter("json");
            User user = gson.fromJson(json, User.class);
            if(userService.userLogin(user.getUsername(),user.getPassword()) == 1) {
                resp.getWriter().write(user.getUsername());
            } else {
                resp.getWriter().write("error");
            }
        }

        if(action.equals("register")) {
            String json = req.getParameter("json");
            User user = gson.fromJson(json, User.class);
            if(userService.queryExit(user.getUsername()) == -1) {
                userService.userRegister(user.getUsername(),user.getPassword(),user.getCreateTime());
                resp.getWriter().write("true");
            }else {
                resp.getWriter().write("false");
            }
        }

        if(action.equals("saveComment")) {
            String commentInfo = req.getParameter("json");
            IssueComments issueComments = gson.fromJson(commentInfo,IssueComments.class);
            issueCommentService.insertIntoIssueService(issueComments);
        }

        if(action.equals("saveIssue")) {
            String issueInfo = req.getParameter("json");
            Issue issue = gson.fromJson(issueInfo,Issue.class);
            issueService.insertIntoIssueService(issue);
        }

        if(action.equals("saveMessage")) {
            String json = req.getParameter("json");
            UserMessage userMessage = gson.fromJson(json, UserMessage.class);
            messageService.saveMessageService(userMessage.getUser(),userMessage.getMessage(),userMessage.getTime());
        }

    }
}
