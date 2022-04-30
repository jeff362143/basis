package com.test;

import com.dao.imple.BaseDao;
import com.dao.imple.UserDao;
import com.pojo.User;
import com.pojo.UserAction;
import com.pojo.UserMessage;
import com.utils.JdbcUtils;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class test extends BaseDao {

//   使用自定义的JdbcUtils中的方法连接数据库，并使用其中的方法关闭数据库
    @Test
//   测试是否正常连接
    public void ConnectionTest(){
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
        try {
            JdbcUtils.sourceClose(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(conn);
    }

    @Test
    public void arrTest() {
        int[] arr1 = new int[10];
        String[] arr2 = new String[10];
        String[] arr3 = new String[10];
        String sql = "select username from user where id > ?";
        for(int i = 0; i < 7; i++) {
            Object username = queryForSingleValue(sql,i);
            String objSTr =  username.toString();
            arr2[i] = objSTr;   //  用户博客数量
            String sql2 = "select count(*) from " + objSTr ;
            Object count = queryForSingleValue(sql2);
            int num = Integer.parseInt(count.toString());
            arr1[i] = num;     //   用户收藏的博客数量
            String sql3 = "select createTime from allblogs where author = ? order by createTime desc";
            Object obj = queryForSingleValue(sql3,arr2[i]);
            if(obj == null) {
                arr3[i] = "null";
            }else {
                arr3[i] = obj.toString();  // 用户最新博客书写时间
            }
        }
        for (int i = 0; i < 7; i++) {
            System.out.println(arr2[i]+":"+arr1[i]+":"+arr3[i]);
        }
    }

//    获取用户动态信息
//    @Test
//    public List<UserAction> getUserActions() throws Exception{
//        ArrayList<UserAction> userActions = null;
//        userActions = new ArrayList<>();
//        String sql = "select id,username,name,lastLoginTime from user";
//        List<User> users = queryForList(User.class, sql);
//        String sql1 = "select count(*) from user";
//        Object userNum = queryForSingleValue(sql1);
//        int count = Integer.parseInt(userNum.toString());
////       到这一步为止，已经有了UserAction中的id，username，name，lastLoginTime
//        String sql2 = "select count(*) from user where username = ?"; // 获取用户博客数量
//        String sql3 = "select createTime from allblogs where author = ? order by createTime desc";
//        for(int i = 0; i < count; i++) {
//            String lastWriteTime = "空";
////            获取用户个人博客数量
//            Object selfBlog = queryForSingleValue(sql2, users.get(i).getUsername());
//            int selfBlogCounts = Integer.parseInt(selfBlog.toString());
////            获取最新博客的写作时间
//            Object obj = queryForSingleValue(sql3,users.get(i).getUsername());
//            if(obj == null) {
//               lastWriteTime = "空";
//            }else {
//               lastWriteTime = obj.toString();
//            }
////            获取用户收藏博客数量
//            String sql4 = "select count(*) from " + users.get(i).getUsername();
//            Object collBlog = queryForSingleValue(sql4);
//            int collBlogCount = Integer.parseInt(collBlog.toString());
//            userActions.add(new UserAction(users.get(i).getId(),users.get(i).getUsername(),users.get(i).getName(),users.get(i).getLastLoginTime(),lastWriteTime,selfBlogCounts,collBlogCount));
//        }
////        System.out.println(userActions);
//        return userActions;
//    }

//    集合测试
    @Test
    public void test() {
        ArrayList<UserMessage> userMessages = new ArrayList<>();
        userMessages.add(new UserMessage(1,"1","2","2020-02-03"));
        userMessages.add(new UserMessage(1,"1","2","2020-02-03"));
        System.out.println(userMessages);
    }

    @Test
    public void indexOfTest() {
        String title = "vue的一次测试";
        String search = "vue";
        if(title.indexOf(search)>-1) {
            System.out.println("success");
        }else {
            System.out.println("no");
        }
    }
}

