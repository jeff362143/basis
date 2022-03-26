package com.control;

import com.google.gson.Gson;
import com.pojo.*;
import com.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class userServlet extends HttpServlet {
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

//        获取博客列表
        if (action.equals("getBlogList")) {
            List<BlogList> allBlogList = blogListService.getAllBlogList();
            String json = gson.toJson(allBlogList);
            resp.getWriter().write(json);
        }

//        根据标签名获取博客
        if (action.equals("getBlog")) {
            String userJson = req.getParameter("json");
            List<Blog> blogs = blogService.queryAllBlogByTableName(userJson);
            String jsonBlog = gson.toJson(blogs);
            resp.getWriter().write(jsonBlog);
        }

//        获取首页轮播图新闻
        if (action.equals("getNews")) {
            List<BlogDetails> news = blogService.getNewsDetail();
            String json = gson.toJson(news);
            resp.getWriter().write(json);
        }

//        获取今日推荐
        if (action.equals("getTodayReco")) {
            List<BlogDetails> todayReco = blogService.getTodayReco();
            String json = gson.toJson(todayReco);
            resp.getWriter().write(json);
        }

//        获取专家
        if (action.equals("getExpert")) {
            List<Expert> expertInfo = expertService.getExpertInfo();
            String s = gson.toJson(expertInfo);
            resp.getWriter().write(s);
        }

//       获取用户全部个人博客
        if (action.equals("getUserBlogByUsername")) {
            String username = req.getParameter("username");
            List<Blog> blogs = userService.getUserALLSelfBlog(username);
            String blogJson = gson.toJson(blogs);
            resp.getWriter().write(blogJson);
        }

//        获取用户全部点赞博客
        if (action.equals("getUserLikeBlog")) {
            String username = req.getParameter("username");
            List<Blog> blogs = blogService.getLikeBlogService(username);
            String json = gson.toJson(blogs);
            resp.getWriter().write(json);
        }

//        获取收藏博客
        if (action.equals("getMyCollBlog")) {
            String username = req.getParameter("username");
            List<Blog> blogs = userService.getUserCollBlog(username);
            String collBlogJson = gson.toJson(blogs);
            resp.getWriter().write(collBlogJson);
        }

//      用户主页获取用户个人信息
        if (action.equals("getOneUserAction")) {
            String username = req.getParameter("username");
            UserAction userActions = userService.getOneAction(username);
            String json = gson.toJson(userActions);
            resp.getWriter().write(json);
        }

//        用户主页判断是否关注用户
        if (action.equals("judgeFollow")) {
            String user = req.getParameter("username");
            String author = req.getParameter("blogauthor");
            if (userService.judgeFollowService(user, author) != null) {
                resp.getWriter().write("true");
            } else {
                resp.getWriter().write("false");
            }
        }

//        关注和取消关注
        if (action.equals("followedUser")) {
            String username = req.getParameter("username");
            String blogauthor = req.getParameter("blogauthor");
            String flagJson = req.getParameter("flag");
            int flag = Integer.parseInt(flagJson);
            if (flag == 1) {
                userService.cancaelFollowService(username, blogauthor);
                resp.getWriter().write("true");
            } else {
                userService.followedService(username, blogauthor);
                resp.getWriter().write("true");
            }
        }

//        判断点赞
        if (action.equals("judgeLike")) {
            String jsonId = req.getParameter("id");
            String username = req.getParameter("username");
            int id = Integer.parseInt(jsonId);
            if (userService.judgeLikeService(username, id) != null) {
                resp.getWriter().write("true");
            } else {
                resp.getWriter().write("false");
            }
        }

//       点赞和取消点赞
        if (action.equals("showLike")) {
            String blogid = req.getParameter("blogId");
            String username = req.getParameter("username");
            String jsonFlag = req.getParameter("flag");
            int id = Integer.parseInt(blogid);
            int flag = Integer.parseInt(jsonFlag);
            if (flag == 1) {
                blogService.subLikedCountService(id);
                userService.cancelShowLikeService(username, id);
                resp.getWriter().write("true");
            } else {
                blogService.addLikedCountService(id);
                userService.showLikeService(username, id);
                resp.getWriter().write("true");
            }
        }



//            获取博客详细信息
        if (action.equals("getBlogDetailsById")) {
            String jsonId = req.getParameter("id");
            int id1 = Integer.parseInt(jsonId);
            BlogDetails blogDetails = blogService.getBlogDetails(id1);
            List<Comment> comments = commentService.GetCommentsById(id1);
            BlogDetails blogDetails1 = new BlogDetails(blogDetails.getId(), blogDetails.getTitle(), blogDetails.getContent(), blogDetails.getCreateTime(), blogDetails.getAuthor(), comments, blogDetails.getLikedCount(), blogDetails.getCollCount());
            String json = gson.toJson(blogDetails1);
            resp.getWriter().write(json);
        }

//         判断收藏
        if (action.equals("JudgeColl")) {
            String user = req.getParameter("username");
            String jsonId = req.getParameter("id");
            int id = Integer.parseInt(jsonId);
            if (blogService.judgeByUserAndID(user, id) != null) {
                resp.getWriter().write("true");
            } else {
                resp.getWriter().write("false");
            }
        }

//        收藏与取消收藏
        if (action.equals("collectBlog")) {
            System.out.println("test");
            String username = req.getParameter("username");
            String Jsonflag = req.getParameter("flag");
            String jsonId = req.getParameter("id");
            int id = Integer.parseInt(jsonId);
            int flag = Integer.parseInt(Jsonflag);
            if (flag == 1) {
                blogService.subBlogCollCount(id);
                userService.deleteBlog(username, id);
                resp.getWriter().write("true");
            } else {
                blogService.addblogCollCount(id);
                userService.collBlog(username, id);
                resp.getWriter().write("true");
            }
        }

//     获取关注我的和我关注的用户
        if (action.equals("getFollowedUser")) {
            String username = req.getParameter("username");
            String flag = req.getParameter("flag");
            if (flag.equals("")) {
                List<User> allFollowUserService = userService.getAllFollowUserService(username);
                String json = gson.toJson(allFollowUserService);
                resp.getWriter().write(json);
            } else {
                List<User> allFollowMeUserByUsernameService = userService.getAllFollowMeUserByUsernameService(username);
                String json2 = gson.toJson(allFollowMeUserByUsernameService);
                resp.getWriter().write(json2);
            }
        }

//      获取用户全部个人评论
        if (action.equals("getUserComments")) {
            String username = req.getParameter("username");
            List<Comment> commentsByUsernameService = commentService.getCommentsByUsernameService(username);
            String json = gson.toJson(commentsByUsernameService);
            resp.getWriter().write(json);
        }

//      用户个人中心详细信息
        if (action.equals("getUserInfo")) {
            String username = req.getParameter("username");
            List<User> oneUserInfo = userService.getUserInfoByUsername(username);
            String json = gson.toJson(oneUserInfo);
            resp.getWriter().write(json);
        }

//       修改用户个人签名
        if (action.equals("reviseUserSelfDesc")) {
            String username = req.getParameter("username");
            String selfDesc = req.getParameter("selfDesc");
            userService.deviseSelfDescService(selfDesc, username);
        }

//      举报博客
        if (action.equals("compainReport")) {
            String title = req.getParameter("title");
            String blogAuthor = req.getParameter("blogAuthor");
            String username = req.getParameter("username");
            String blogId = req.getParameter("blogId");
            String time = req.getParameter("time");
            blogService.complainBlogService(blogId, title, username, blogAuthor, time);
        }

//        搜索博客
        if (action.equals("getSearchBlogs")) {
            List<Blog> blogs = new ArrayList<>();
            String researchValue = req.getParameter("value");
            List<Blog> allBlogs = blogService.adminGetAllBlogs();
            for (int i = 0; i < allBlogs.size(); i++) {
                if (allBlogs.get(i).getTitle().indexOf(researchValue) > -1) {
                    blogs.add(allBlogs.get(i));
                }
            }
            String json = gson.toJson(blogs);
            resp.getWriter().write(json);
        }

//        获取个人消息
        if (action.equals("getSelfInform")) {
            String username = req.getParameter("username");
            List<Inform> informs = informService.getInformService(username);
            String json = gson.toJson(informs);
            resp.getWriter().write(json);
        }

//        获取消息数量
        if (action.equals("getInfoCount")) {
            String username = req.getParameter("username");
            int informCountService = informService.getInformCountService(username);
            String jsonCount = Integer.toString(informCountService);
            resp.getWriter().write(jsonCount);
        }

//    删除博客
        if(action.equals("deleteBlog")) {
            String id = req.getParameter("id");
            int blogId = Integer.parseInt(id);
            blogService.deleteBlogService(blogId);
            resp.getWriter().write("true");
        }

//        删除评论
        if(action.equals("deleteComment")) {
            String commentId = req.getParameter("commentId");
            int id = Integer.parseInt(commentId);
            commentService.deleteCommentService(id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Content-type","text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        Gson gson = new Gson();

//        登录
        if(action.equals("login")) {
            String userJson = req.getParameter("json");
            User user = gson.fromJson(userJson,User.class);
            if(userService.login(user) != null){
                resp.getWriter().write(user.getUsername());
            } else {
                resp.getWriter().write("error");
            }
        }

//        注册
        if(action.equals("register")) {
            String json = req.getParameter("json");
            User user = gson.fromJson(json, User.class);
            if(userService.judgeRegister(user.getUsername())) {
                resp.getWriter().write("false");
            }else {
                userService.register(user.getPassword(),user.getUsername(),user.getTime());
                userService.createForUser(user.getUsername());   //  创建用户动态表存储动态信息
                resp.getWriter().write("true");
            }
        }

//  保存用户博客
        if(action.equals("userSaveBlog")) {
            String json = req.getParameter("json");
            Blog blog = gson.fromJson(json, Blog.class);
            blogService.UserWriteBlog(blog.getTitle(),blog.getContent(),blog.getCreateTime(),blog.getAuthor(),blog.getMarked());
        }

//        更改用户博客
        if(action.equals("userUpdateBlog")) {
            String json = req.getParameter("json");
            Blog blog = gson.fromJson(json,Blog.class);
            blogService.updateBlogForUser(blog.getTitle(),blog.getContent(),blog.getCreateTime(),blog.getMarked(),blog.getId());
        }

//        修改个人信息
        if(action.equals("reviseUserInfo")) {
            String json = req.getParameter("json");
            User user = gson.fromJson(json, User.class);
            userService.reviseUserInfoService(user.getName(),user.getMajor(),user.getCompany(),user.getJob(),user.getGraduateSchool(),user.getUsername());
        }

//     保存用户留言反馈
        if(action.equals("saveMessage")) {
            String json = req.getParameter("json");
            UserMessage userMessage = gson.fromJson(json, UserMessage.class);
            messageService.Update("UserMessage",userMessage.getUser(),userMessage.getMessage(), userMessage.getTime());
        }

//    保存用户留言
        if(action.equals("saveComment")) {
            String json = req.getParameter("json");
            Comment comment = gson.fromJson(json,Comment.class);
            commentService.saveComment(comment.getId(),comment.getUsername(),comment.getComment(),comment.getCommentTime());
        }

//        点赞后发送消息给对方
        if(action.equals("sendLikeInform")) {
            String json = req.getParameter("json");
            Inform inform = gson.fromJson(json, Inform.class);
            informService.sendLikeInfoService(inform);
        }

    }

}
