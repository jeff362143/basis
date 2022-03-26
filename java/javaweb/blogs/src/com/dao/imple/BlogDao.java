package com.dao.imple;

import com.pojo.Blog;
import com.pojo.BlogDetails;
import com.pojo.BlogList;
import com.pojo.ComplainBlog;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BlogDao extends BaseDao{

//  admin获取全部userblogs的全部博客
//        String sql = "select * from allblogs order by createTime  desc limit 20";
    public List<Blog> getAllUserBlogs() {
        String sql = "select * from allblogs order by createTime  desc";
        return queryForList(Blog.class,sql);
    }

//    admin获取全部userblogs的全部博客，用blogdetails接收，上面的是blog接收，信息更少
    public List<BlogDetails> getAllUserBlogDetail() {
        String sql  = "select * from allblogs order by createTime desc";
        return queryForList(BlogDetails.class,sql);
    }

//    给allBlogs中添加数据
    public int addBlogToAllBlogs(Object ...args) {
        String sql = "insert into allBlogs values(null,?,?,?,?,?,0,0,0)";
        return update(sql,args);
    }

    public List<Blog> queryBlogs(String table) {
        List<Blog> blogs = null;
        if(table.equals("推荐")) {
            String sql = "select * from allblogs where reco = 1 order by createTime desc";
            blogs = queryForList(Blog.class, sql);
        } else {
            String sql = "select * from allblogs where marked = ? order by createTime desc";
            blogs = queryForList(Blog.class, sql, table);
        }
        return blogs;
    }

//    获取推荐和非推荐博客
    public List<BlogDetails> getRecoBlogOrNoReco(String flag) {
        List<BlogDetails> blogs = null;
        if(flag.equals("1")) {
            String sql = "select * from allblogs where reco = 1 order by createTime desc";
            blogs = queryForList(BlogDetails.class, sql);
        }else {
             String sql2 = "select * from allblogs where reco = 0 order by createTime desc";
             blogs = queryForList(BlogDetails.class,sql2);
        }
             return blogs;
        }

//      设置博客推荐和取消推荐
    public void setRecoOrCancel(String flag,int id) {
        String sql = "update allblogs set reco = 1 where id = ?";
        String sql2 = "update allblogs set reco = 0 where id = ?";
        if(flag.equals("0")) {
            update(sql,id);
        } else {
            update(sql2,id);
        }
    }

//    删除博客
    public void deleteBlogById(int id) {
        String sql = "delete from allblogs where id = ?";
        String sql2 = "delete from blogcomments where id = ?";
        update(sql,id);
        update(sql2,id);
    }

//    获取今日推荐
    public List<BlogDetails> queryTodayReco() {
        String sql = "select * from allblogs where marked = 'todayreco'";
        return queryForList(BlogDetails.class,sql);
    }

//  返回轮播图新闻详细信息
    public List<BlogDetails> queryNews() {
        String sql = "select * from allblogs where marked = ?";
        return queryForList(BlogDetails.class,sql,"news");
    }

//    根据id修改allblogs中的content和title还有createTime
     public void updateBlogById(String title,String content,String createTime,String marked,int id) {
        String sql = "update allblogs set title = ?,content = ?,createTime = ?,marked = ? where id = ?";
        update(sql,title,content,createTime,marked,id);
     }

//     根据id修改news
    public void updateNewsById(String title,String content,String createTime,int id) {
        String sql = "update allblogs set title = ?,content = ?,createTime = ? where id = ?";
        update(sql,title,content,createTime,id);
    }

//     新增label
    public void addLabel(String labelName,String createTime) {
        String sql = "insert into bloglist values(Default,?,?)";
        update(sql,labelName,createTime);
    }

//  删除label
    public void deleteLabelForlabelName(String labelName) {
        String sql = "delete from bloglist where name = ?";
        update(sql,labelName);
        String sql2 = "ALTER TABLE bloglist DROP id";
        update(sql2);
        String sql3 = "ALTER TABLE bloglist ADD id int NOT NULL FIRST";
        update(sql3);
        String sql4 = "ALTER TABLE bloglist MODIFY COLUMN id int NOT NULL AUTO_INCREMENT,ADD PRIMARY KEY(id)";
        update(sql4);
        String sql5 = "select count(*) from bloglist";
        Object o = queryForSingleValue(sql5);
        int count = Integer.parseInt(o.toString());
        String sql6 = "ALTER TABLE bloglist AUTO_INCREMENT = ?";
        update(sql6,count+1);
    }

    @Test
    public void test() {
        deleteLabelForlabelName("d");
    }

//  根据id搜索allblogs表格中的博客内容
    public Blog getBlogById(int id) {
        String sql = "select * from allblogs where id = ?";
        return queryForOne(Blog.class,sql,id);
    }

//    获取博客详情信息
    public BlogDetails getBlogDetails(int id) {
        String sql = "select * from allblogs where id = ?";
        return queryForOne(BlogDetails.class,sql,id);
    }

//    博客收藏数加1
    public void addCollCount(int id) {
        String sql = "update allblogs set collCount = collCount + 1 where id = ?";
        update(sql,id);
    }

//    博客收藏数减1
    public void subCollCount(int id) {
        String sql = "update allblogs set collCount = collCount - 1 where id = ?";
        update(sql,id);
    }

//   allblogs表中博客点赞数加1
    public void addLikedCount(int id) {
        String sql = "update allblogs set likedCount = likedCount + 1 where id = ?";
        update(sql,id);
    }

//    allblogs表中博客点赞数减1
    public void subLikedCount(int id) {
        String sql = "update allblogs set likedCount = likedCount - 1 where id = ?";
        update(sql,id);
    }

//   根据用户名获取它的点赞博客
    public List<Blog> getLikeBlogByUsername(String username) {
        ArrayList<Blog> blogs = new ArrayList<>();
        String sql1 = "select count(*) from " + username + " where likedblogid > 0";
        String sql2 = "select likedblogid from " + username + " where id = ?";
        String sql3 = "select * from allblogs where id = ?";
        Object object = queryForSingleValue(sql1);
        int update = Integer.parseInt(object.toString());
        for(int i = 1; i < update + 1; i++) {
            Object o = queryForSingleValue(sql2, i);
            int likedBlogId = Integer.parseInt(o.toString());
            Blog blog = queryForOne(Blog.class, sql3, likedBlogId);
//            小心为空，特殊处理
            if(blog != null) {
                blogs.add(blog);
            }
        }
        return blogs;
    }

//   举报博客
    public void complainBlog(String blogId,String title,String username,String blogAuthor,String time) {
        String sql = "insert into complain values(DEFAULT,?,?,?,?,?)";
        update(sql,blogId,title,username,blogAuthor,time);
    }

//    获取举报博客
    public List<ComplainBlog> adminGetComplainBlog() {
        String sql = "select * from complain order by time desc";
        List<ComplainBlog> complainBlogs = queryForList(ComplainBlog.class, sql);
        return complainBlogs;
    }


    @Test
    public void LikeTest() {
        System.out.println(getLikeBlogByUsername("jeff2020").toString());
    }


//
//    @Test
//    public void test() {
//        List<Blog> blog = queryBlogByTable("blog", 0);
//        System.out.println(blog);
//    }

//    @Test
//    public void add() {
//        String table = "UserMessage";
//        String sql = "insert into " + table + " values(?,?,?)";
//        update(sql,"9","1","5");
//    }

}
