package com.control;

import com.google.gson.Gson;
import com.pojo.Issue;
import com.pojo.UserMessage;
import com.service.IssueService;
import com.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class adminServlet extends HttpServlet {
    private MessageService messageService = new MessageService();
    private IssueService issueService = new IssueService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Content-type","text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        Gson gson = new Gson();

        if(action.equals("getMessage")) {
            List<UserMessage> userMessageService = messageService.getUserMessageService();
            String json = gson.toJson(userMessageService);
            resp.getWriter().write(json);
        }

        if(action.equals("addLabel")) {
            String label = req.getParameter("label");
            issueService.addLabelService(label);
        }

        if(action.equals("deleteLabel")) {
            String labelName = req.getParameter("labelName");
            issueService.deleteLabelService(labelName);
        }

        if(action.equals("getAllIssues")) {
            List<Issue> issues = issueService.getAllIssueService();
            String json = gson.toJson(issues);
            resp.getWriter().write(json);
        }

        if(action.equals("recoIssue")) {
            String id = req.getParameter("id");
            int Id = Integer.parseInt(id);
            issueService.recoIssueService(Id);
            resp.getWriter().write("true");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Content-type","text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
    }
}
