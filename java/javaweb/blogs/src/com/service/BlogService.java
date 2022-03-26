package com.service;

import com.dao.imple.BaseDao;
import com.dao.imple.BlogDao;
import com.pojo.Blog;
import com.pojo.BlogDetails;
import com.pojo.BlogList;
import com.pojo.ComplainBlog;
import org.junit.Test;
import java.util.List;

public class BlogService extends BlogDao {
    private BlogDao blogDao = new BlogDao();

//    返回不同表的全部blogContent内容
    public List<Blog> queryAllBlogByTableName(String table) {
        return queryBlogs(table);
    }

//  用户写博客
    public int UserWriteBlog(Object ...args) {
        return addBlogToAllBlogs(args);
    }

//  根据用户名和id判断该用户是否收藏了该博客
    public Object judgeByUserAndID(String username,int id) {
        String sql = "select id from " + username + " where collblogid = ?";
        return queryForSingleValue(sql,id);
    }

//   根据博客id判断是否被推荐
    public int JudgeRecoService(int id) {
        String sql = "select reco from allblogs where id = ?";
        Object o = queryForSingleValue(sql, id);
        int value = Integer.parseInt(o.toString());
        return  value;
    }

//  获取新闻信息
    public List<BlogDetails> getNewsDetail() {
        return blogDao.queryNews();
    }

//    admin更新新闻信息
    public void updateNews(String title,String content,String createTime,int id) {
        blogDao.updateNewsById(title,content,createTime,id);
    }

//    用户修改自己博客信息
    public void updateBlogForUser(String title,String content,String createTime,String marked,int id) {
        blogDao.updateBlogById(title,content,createTime,marked,id);
    }

//    新增label
    public void adminAddLabel(String label,String createTime) {
        blogDao.addLabel(label,createTime);
    }

//   删除博客
    public void adminDeleteLabel(String labelName) {
        blogDao.deleteLabelForlabelName(labelName);
    }

//    admin获取全部用户博客
    public List<Blog> adminGetAllBlogs() {
         return blogDao.getAllUserBlogs();
    }

    public List<BlogDetails> adminGetAllBlogDetails() {
        return blogDao.getAllUserBlogDetail();
    }


    public List<BlogDetails> getRecoBlogService(String flag) {
        return blogDao.getRecoBlogOrNoReco(flag);
    }

    public void setRecoService(String flag,int id) {
        blogDao.setRecoOrCancel(flag,id);
    }

    public void deleteBlogService(int id) {
        blogDao.deleteBlogById(id);
    }





//   获取今日推荐
    public List<BlogDetails> getTodayReco() {
        return blogDao.queryTodayReco();
    }



//    根据id获取博客内容
     public Blog getBlogInfo(int id) {
         return blogDao.getBlogById(id);
     }

//     根据id获取博客详细信息
    public BlogDetails getBlogDetails(int id) {
        return blogDao.getBlogDetails(id);
    }

//    博客的收藏总数加1
    public void addblogCollCount(int id) {
        blogDao.addCollCount(id);
    }

//    博客的收藏总数减1
    public void subBlogCollCount(int id) {
        blogDao.subCollCount(id);
    }

//    博客点赞数+1
    public void addLikedCountService(int id) {
        blogDao.addLikedCount(id);
    }

//    博客点赞数-1
    public void subLikedCountService(int id) {
        blogDao.subLikedCount(id);
    }

//    获取用户的点赞博客
    public List<Blog> getLikeBlogService(String username) {
        return blogDao.getLikeBlogByUsername(username);
    }

    public void complainBlogService(String blogId,String title,String username,String blogAuthor,String time) {
        complainBlog(blogId,title,username,blogAuthor,time);
    }

    public List<ComplainBlog> getComplainBlogService() {
        return adminGetComplainBlog();
    }

//    @Test
//    public void test() {
//        System.out.println(queryAllBlogByTableName("java"));
//    }
}
