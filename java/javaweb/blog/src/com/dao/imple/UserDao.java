package com.dao.imple;

import com.pojo.Blog;
import com.pojo.User;
import com.pojo.UserAction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
//import org.junit.Test;

public class UserDao extends BaseDao{
    public User  queryUserByUsernameAndPassword(String username,String password) {
        String sql = "select id,username,password from user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    public User queryAdminByUsernameAndPassword(String username,String password) {
        String sql = "select username,password from admin where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

//    根据author名查询allBlogs表中有多少条博客
    public Object queryUserByAuthorName(Object ...args) {
        String sql = "select count(*) from allBlogs where author = ?";
        return queryForSingleValue(sql,args);
    }

//    根据author名查询有多少收藏的博客
    public Object queryBlogCollByAuthor(String table) {
        String sql = "select count(*) from " + table;
        return queryForSingleValue(sql);
    }

//    queryBlogCollByAuthor   测试
    @Test
    public void queryBlogCollByAuthorTest() {
        Object num = queryBlogCollByAuthor("jeff2020");
        System.out.println(num.toString());
    }

//    @Test
//    public void test() {
//        Object num = queryUserByAuthorName("jeff2020");
//        System.out.println(num);
//    }

//    @Test
//    public void test() {
//        System.out.println(queryUserByUsernameAndPassword("jeff","362143").getUsername());
//    }

//    admin获取全部用户信息
      public List<User>  QueryUser() {
        String sql = "select * from user ";
        return queryForList(User.class,sql);
    }

//    根据username返回一个用户
    public List<User> QueryByUsername(String username) {
        String sql = "select * from user where username = ?";
        return queryForList(User.class,sql,username);
    }

//    根据id修改user表
    public int UpdateUser(int id,String username,String password) {
        String sql = "update user set username = ?,password = ? where id = ?";
        return update(sql,username,password,id);
    }

//    根据用户名判断该用户是否已经被注册
    public boolean usernameExit(String username) {
        String sql = "select * from user where username = ?";
        User user = queryForOne(User.class, sql, username);
        if(user != null){
            return true;
        }else {
            return false;
        }
//        return user != null ? true : false;
    }

//    把新用户的账号和密码插入到用户表中
    public void insertIntoUser(String username,String  password,String time) {
//        String sql = "insert into user values(null,?,?,?,null,null,null,null,null,null)";
        String sql = "insert into user values(DEFAULT,?,?,?,?,DEFAULT,DEFAULT,DEFAULT,DEFAULT,DEFAULT,DEFAULT,DEFAULT,DEFAULT)";
        update(sql,password,username,time,time);
    }

//    根据表名新建数据库的表
    public void createTableByTablename(String Tablename) {
        String sql = "create table " + Tablename + " ( id int(10)  primary key not null auto_increment,collblogid int(10),likedblogid int(10),followeduserid int(10),followedmeuserid int(10))";
        update(sql);
//      插入默认值
        String sql2 = "insert into " + Tablename + " values(DEFAULT,0,0,0,0)";
        update(sql2);
    }

    //    返回用户动态集合
    public List<UserAction> QueryUserAction() {
        ArrayList<UserAction> userActions = null;
        userActions = new ArrayList<>();
//        String sql = "select * from user order by time desc";
        String sql = "select * from user";
        List<User> users = queryForList(User.class, sql);
        String sql1 = "select count(*) from user";
        Object userNum = queryForSingleValue(sql1);
        int count = Integer.parseInt(userNum.toString());
//      count为有多少个用户
        String sql2 = "select count(*) from allblogs where author = ?"; // 获取用户博客数量
        String sql3 = "select createTime from allblogs where author = ? order by createTime desc";
        for(int i = 0; i < count; i++) {
            String lastWriteTime = "空";
//            获取用户个人博客数量
            Object selfBlog = queryForSingleValue(sql2, users.get(i).getUsername());
            int selfBlogCounts = Integer.parseInt(selfBlog.toString());
////            获取最新博客的写作时间
            Object obj = queryForSingleValue(sql3,users.get(i).getUsername());
            if(obj == null) {
                lastWriteTime = "空";
            }else {
                lastWriteTime = obj.toString();
            }
//            获取用户收藏博客数量
            String sql4 = "select count(*) from " + users.get(i).getUsername() + " where collblogid > 0";
            Object collBlog = queryForSingleValue(sql4);
            int collBlogCount = Integer.parseInt(collBlog.toString());

//           避免有已删除博客
//            for (int j = 1; j < collBlogCount+1; j++) {
//                Object booleanObj =  queryForSingleValue(sql2,i);
//                int id = Integer.parseInt(booleanObj.toString());
//                Blog blog = queryForOne(Blog.class,sql3,id);
//                if(booleanObj == null) {
//                    collBlogCount = collBlogCount - 1;
//                }
//            }

//            粉丝数量
            String sql5 = "select count(*) from " + users.get(i).getUsername() + " where followedmeuserid > 0";
            Object followed = queryForSingleValue(sql5);
            int followedCount = Integer.parseInt(followed.toString());

            //      评论数量
            String sql6 = "select count(*) from blogcomments where username = ?";
            Object object = queryForSingleValue(sql6,users.get(i).getUsername());
            int commentCount = Integer.parseInt(object.toString());

//            点赞过的博客
            //        个人点赞博客数量
            String sql7 = "select count(*) from " + users.get(i).getUsername() + " where likedblogid > 0";
            Object likedBlogCountObj = queryForSingleValue(sql7);
            int likedBlogCount = Integer.parseInt(likedBlogCountObj.toString());
            UserAction userAction = new UserAction(users.get(i).getId(),users.get(i).getUsername(),lastWriteTime,selfBlogCounts,collBlogCount,followedCount,commentCount,likedBlogCount);
            userActions.add(userAction);
        }
        return userActions;
    }

//     获取全部用户的动态信息
    @Test
    public void getAllUserAction() {
        System.out.println(QueryUserAction());
    }



    //    根据用户名返回一个用户的动态信息
    public UserAction getUserActionByUsername(String username) {

        String sql1 = "select count(*) from allblogs where author = ?"; // 获取用户博客数量
        String sql2 = "select createTime from allblogs where author = ? order by createTime desc";
        Object obj = queryForSingleValue(sql2,username);
//       上次写博时间
        String lastWriteTime = "";
        if(obj == null) {
            lastWriteTime = "空";
        }else {
            lastWriteTime = obj.toString();
        }
//      个人博客数量
        Object selfBlog = queryForSingleValue(sql1,username);
        int selfBlogCount = Integer.parseInt(selfBlog.toString());

//       个人收藏博客数量
        String sql3 = "select count(*) from " + username + " where collblogid > 0";
        Object collBlog = queryForSingleValue(sql3);
        int collBlogCount = Integer.parseInt(collBlog.toString());

//       粉丝数量
        String sql4 = "select count(*) from " + username + " where followedmeuserid > 0";
        Object followed = queryForSingleValue(sql4);
        int followedCount = Integer.parseInt(followed.toString());

//      评论数量
        String sql5 = "select count(*) from blogcomments where username = ?";
        Object object = queryForSingleValue(sql5,username);
        int commentCount = Integer.parseInt(object.toString());

//        获取desc
        String sql6 = "select selfdesc from user where username = ?";
        Object desc = queryForSingleValue(sql6,username);

//        个人点赞博客数量
        String sql7 = "select count(*) from " + username + " where likedblogid > 0";
        Object likedBlogCountObj = queryForSingleValue(sql7);
        int likedBlogCount = Integer.parseInt(likedBlogCountObj.toString());
        UserAction userAction = new UserAction(username,lastWriteTime,selfBlogCount,collBlogCount,followedCount,commentCount,desc.toString(),likedBlogCount);
        return userAction;
    }




    //    getOneUserAction
//    @Test
//    public void getOneUserActionTest() {
//        List<UserAction> userActions = getUserActionByUsername("jeff2020");
//        System.out.println(userActions);
//    }

//  按用户名返回用户全部博客（按时间降序）
    public List<Blog> getBlogFromAllBlog(String username) {
        String sql = "select * from allblogs where author = ? order by createTime desc";
        return queryForList(Blog.class,sql,username);
    }

//   用户中心返回用户所有博客按点赞数排序
    public List<Blog> getBlogByLikedCount(String username) {
        String sql = "select * from allblogs where author = ? order by likedCount desc";
        return queryForList(Blog.class,sql,username);
    }


    //    根据用户名返回用户收藏的全部博客
    public List<Blog> queryCollBlogByUsername(String username) {
        List<Blog> blogs = new ArrayList<>();
        String sql = "select count(*) from " + username;
        String sql2 = "select collblogid from " + username + " where id = ?";
        String sql3 = "select * from allblogs where id = ?";
        Object userNum = queryForSingleValue(sql);
        int count = Integer.parseInt(userNum.toString());
        for (int i = 1; i < count+1; i++) {
            Object obj =  queryForSingleValue(sql2,i);
            int id = Integer.parseInt(obj.toString());
            Blog blog = queryForOne(Blog.class,sql3,id);
            if(blog != null) {
                blogs.add(blog);
            }
        }
        return  blogs;
    }

//    为用户收藏博客
    public void collBlogById(String username,int id) {
        String sql = "select id from " + username + " where collblogid = 0";
        Object objId = queryForSingleValue(sql);
        if(objId != null) {
            int collId = Integer.parseInt(objId.toString());
            String sql2 = "update " + username + " set collblogid = ? where id = ?";
            update(sql2, id, collId);
        }else {
            String sql1 = "insert into " + username + " values(null,?,0,0,0)";
            update(sql1, id);
        }
    }

//    为用户取消收藏博客
    public void deleteCollById(String username,int id) {
        String sql = "update " + username + " set collblogid = 0  where collblogid = ?";
        update(sql,id);
//        String sql2 = "ALTER TABLE " + username + " DROP id";
//        update(sql2);
//        String sql3 = "ALTER TABLE " + username + " ADD id int NOT NULL FIRST";
//        update(sql3);
//        String sql4 = "ALTER TABLE " +  username + " MODIFY COLUMN id int NOT NULL AUTO_INCREMENT,ADD PRIMARY KEY(id)";
//        update(sql4);
    }

//    点赞
    public void showLike(String username,int id) {
        String sql = "select id from " + username + " where likedblogid = 0";
        Object objId = queryForSingleValue(sql);
        if(objId != null) {
            String sql2 = "update " + username + " set likedblogid = ? where id = ?";
            update(sql2, id, objId);
        }else {
            String sql1 = "insert into " + username + " values(null,0,?,0,0)";
            update(sql1, id);
        }
    }

//    取消点赞
    public void cancelShowLike(String username,int id) {
        String sql = "update " + username + " set likedblogid = 0  where likedblogid = ?";
        update(sql,id);
    }

//    判断关注
    public Object judgeFollowForUser(String username,String author) {
        String sql = "select id from user where username = ?";
        Object obj = queryForSingleValue(sql,author);
        int id = Integer.parseInt(obj.toString());
        String sql2 = "select id from " + username + " where followeduserid = ?";
        return queryForSingleValue(sql2,id);
    }

//    判断点赞
    public Object judgeLikeForUser(String username,int id) {
        String sql = "select id from " + username + " where likedblogid = ?";
        return queryForSingleValue(sql,id);
    }

//    取消关注
    public void cancelFollowed(String username,String blogauthor) {
        String sql = "select id from user where username = ?";
        Object obj = queryForSingleValue(sql,blogauthor);
        int id = Integer.parseInt(obj.toString());
        String sql2 = "update " + username + " set followeduserid = 0 where followeduserid = ?";
        update(sql2,id);

//      取消关注也需要将username从blogauthor的粉丝中删除
        Object o = queryForSingleValue(sql,username);
        int usernameId = Integer.parseInt(o.toString());
        String sql3 = "update " + blogauthor + " set followedmeuserid = 0 where followedmeuserid = ?";
        update(sql3,usernameId);
    }

//    关注
    public void followUser(String username,String blogauthor) {
        String sql = "select id from user where username = ?";
        Object obj = queryForSingleValue(sql,blogauthor);
        int id = Integer.parseInt(obj.toString());
        String sql2 = "select id from " + username + " where followeduserid = 0 limit 1";
        Object idObj = queryForSingleValue(sql2);
        int minId = Integer.parseInt(idObj.toString());
        String sql3 = "update " + username + " set followeduserid = ? where id = ?";
        update(sql3,id,minId);

//        被关注者也需要在自己的user表中插入粉丝user的id
        Object FanObj = queryForSingleValue(sql,username);
        int fanId = Integer.parseInt(FanObj.toString());
        String sql5 = "select id from " + blogauthor + " where followedmeuserid = 0 limit 1";
        Object BlogAuthorIdObj = queryForSingleValue(sql5);
        int BlogAuthorMinId = Integer.parseInt(BlogAuthorIdObj.toString());
        String sql6 = "update " + blogauthor + " set followedmeuserid = ? where id = ?";
        update(sql6,fanId,BlogAuthorMinId);
    }

//    根据username获取所有关注的人
    public List<User> getAllFollowedUserByUsername(String username) {
        ArrayList<User> users = new ArrayList<>();
        String sql = "select count(*) from " + username +  " where followeduserid > 0";
        String sql2 = "select * from user where id = ?";
        String sql3 = "select followeduserid from " + username + " where id = ?";
        Object o = queryForSingleValue(sql);
        int followedUserCount = Integer.parseInt(o.toString());
        for (int i = 1; i <= followedUserCount; i++) {
            Object o1 = queryForSingleValue(sql3, i);
            int userID = Integer.parseInt(o1.toString());
            User user = queryForOne(User.class, sql2,userID);
            users.add(user);
        }
        return users;
    }

//    获取所有关注我的人
    public List<User> getAllFollowMeUserByUsername(String username) {
        ArrayList<User> users = new ArrayList<>();
        String sql = "select count(*) from " + username +  " where followedmeuserid > 0";
        String sql2 = "select * from user where id = ?";
        String sql3 = "select followedmeuserid from " + username + " where id = ?";
        Object o = queryForSingleValue(sql);
        int followedmeUserCount = Integer.parseInt(o.toString());
        for (int i = 1; i <= followedmeUserCount; i++) {
            Object o1 = queryForSingleValue(sql3, i);
            int userID = Integer.parseInt(o1.toString());
            User user = queryForOne(User.class, sql2,userID);
            users.add(user);
        }
        return  users;
    }

//    根据用户名修改个性签名
    public void deviseSelfDescByUsername(String selfdesc,String username) {
        String sql = "update user set selfdesc = ? where username = ?";
        update(sql,selfdesc,username);
    }


    public void deviseUserInfoByUsername(String name,String major,String company,String job,String graduateSchool,String username) {
        String sql = "update user set  name = ?,major = ?,company = ?,job = ?,graduateSchool = ? where username = ?";
        update(sql,name,major,company,job,graduateSchool,username);
    }


    @Test
    public void getAllFollowMeUserByUsernameTest() {
        System.out.println(getAllFollowMeUserByUsername("jeff2020"));
    }

    @Test
    public void getAllFollowedUserTest() {
        System.out.println(getAllFollowedUserByUsername("jeff2020"));
    }

    @Test
    public void testFollowedUser() {
        followUser("jeff2020","admin1");
    }

    @Test
    public void testCancelFollow() {
        cancelFollowed("jeff2020","admin1");
    }


    @Test
    public void testFollow() {
        if(judgeFollowForUser("jeff2020","admin1") == null) {
            System.out.println("空");
        }else {
            System.out.println("不空");
        }
    }

    @Test
    public void test() {
        List<Blog> blogs =  queryCollBlogByUsername("jeff2020");
        System.out.println(blogs);
    }

}
