package com.dao.imple;


import com.pojo.Expert;
import com.pojo.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExpertDao extends BaseDao {

    public List<Expert> queryExpert() {
//        List<Expert> experts = new ArrayList<>();
//        String sql = "select count(*) from expert";
//        String sql2 = "select * from expert where id = ?";
//        String sql3 = "select count(*) from allblogs where author = ?";
//        Object o = queryForSingleValue(sql);
//        int count = Integer.parseInt(o.toString());
//        for (int i = 1; i < count + 1; i++) {
//            Expert expert = queryForOne(Expert.class, sql2, i);
//            Object o1 = queryForSingleValue(sql3,expert.getUsername());
//            int selfBlog = Integer.parseInt(o1.toString());
//            experts.add(new Expert(i, expert.getUserId(),expert.getUsername(),expert.getadmindesc(), selfBlog));
//        }
          List<Expert> experts = new ArrayList<>();
          String sql = "select * from user where expertFlag = 1";
          String sql2 = "select count(*) from allblogs where author = ?";
          List<User> users = queryForList(User.class,sql);
          for(int i = 0; i <  users.size(); i++) {
              Object o1 = queryForSingleValue(sql2,users.get(i).getUsername());
              int selfBlog = Integer.parseInt(o1.toString());
              experts.add(new Expert(users.get(i).getId(),users.get(i).getUsername(),users.get(i).getOffcialDesc(), selfBlog));
          }
        return experts;
    }

//    修改专家信息
    public void updateExpertInfo(String formerUsername,String username,String desc) {
//        String sql = "select id from user where username = ?";
//        Object o = queryForSingleValue(sql, username);
//        int id = Integer.parseInt(o.toString());
//        String sql2 = "update user set userid = ?,username = ?,admindesc = ? where userid = ?";
//        update(sql2,id,username,desc,id);
          String sql = "update user set expertFlag = 0 where username = ?";
          String sql2 = "update user set expertFlag = 1,offcialDesc = ? where username = ?";
          update(sql,formerUsername);
          update(sql2,desc,username);
    }

}
