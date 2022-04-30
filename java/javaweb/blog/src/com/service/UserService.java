package com.service;

import com.dao.imple.UserDao;
import com.pojo.Blog;
import com.pojo.User;
import com.pojo.UserAction;
import org.junit.Test;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    public User adminLogin(User user) {
        return userDao.queryAdminByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

//  获取用户的博客数量
    public Object getBlogCountByAuthor(String author) {
        return userDao.queryUserByAuthorName(author);
    }

//  获取用户的收藏博客数量
    public Object getCollBlogCount(String table) {
        return userDao.queryBlogCollByAuthor(table);
    }

//    @Test
//    public void test() {
//      System.out.println(login(new User("jeff","362143")).getUsername());
//    }

//   admin获取全部用户博客信息
    public List<User> getAllUserInfo() {
        return userDao.QueryUser();
    }

//    admin根据username返回一个用户
    public List<User> getUserInfoByUsername(String username) {
        return userDao.QueryByUsername(username);
    }

//    admin根据修改后的信心更新user表
    public int updateTableUser(int id,String username,String password) {
        return userDao.UpdateUser(id,username,password);
    }

//    获取用户动态
    public List<UserAction> getUserActions() {
        return userDao.QueryUserAction();
    }

//    获取一个用户动态
    public UserAction getOneAction(String username) {
        return userDao.getUserActionByUsername(username);
    }

//    获取用户全部个人博客
    public List<Blog>  getUserALLSelfBlog(String username) {
        return userDao.getBlogFromAllBlog(username);
    }

//    获取用户个人按点赞数排序
    public List<Blog> getUserBlogByLikedCountService(String username) {
        return userDao.getBlogByLikedCount(username);
    }

//    获取用户收藏全部博客
    public List<Blog> getUserCollBlog(String username) {
        return userDao.queryCollBlogByUsername(username);
    }

//   判断用户是否被注册
    public boolean judgeRegister(String username) {
        return userDao.usernameExit(username);
    }

//    根据用户名和账号注册用户
    public void register(String username,String password,String time) {
        userDao.insertIntoUser(password,username,time);
    }

//   为新注册的用户新建一个表
    public void createForUser(String username) {
        userDao.createTableByTablename(username);
    }

//    为用户收藏博客
    public void collBlog(String username,int id) {
        userDao.collBlogById(username,id);
    }

//   为用户取消收藏博客
    public void deleteBlog(String username,int id) {
        userDao.deleteCollById(username, id);
    }

//   判断是否关注
    public Object judgeFollowService(String username,String author) { return userDao.judgeFollowForUser(username,author); }

//    关注
    public void followedService(String username,String author) {
        userDao.followUser(username,author);
    }

//    取消关注
    public void cancaelFollowService(String username,String author) {
        userDao.cancelFollowed(username,author);
    }

//    判断点赞
    public Object judgeLikeService(String username,int id) {
        return userDao.judgeLikeForUser(username,id);
    }

//    点赞
    public void showLikeService(String username,int id) {
        userDao.showLike(username,id);
    }

//    取消点赞
    public void cancelShowLikeService(String username,int id) {
        userDao.cancelShowLike(username,id);
    }

//    根据username它关注的所有用户的信息
    public List<User> getAllFollowUserService(String username) {
        return userDao.getAllFollowedUserByUsername(username);
    }

//    根据username获取关注他的所有人
    public List<User> getAllFollowMeUserByUsernameService(String username) {
        return userDao.getAllFollowMeUserByUsername(username);
    }

//
    public void deviseSelfDescService(String selfdesc,String username) {
        userDao.deviseSelfDescByUsername(selfdesc,username);
    }

//
    public void reviseUserInfoService(String name,String major,String company,String job,String graduateSchool,String username) {
        userDao.deviseUserInfoByUsername(name,major,company,job,graduateSchool,username);
    }
}
