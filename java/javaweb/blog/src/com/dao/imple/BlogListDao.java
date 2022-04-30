package com.dao.imple;

import com.pojo.BlogList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BlogListDao extends BaseDao{
    public List<BlogList> queryList() {
        ArrayList<BlogList> blogListList = new ArrayList<>();
         String sql = "select * from BlogList";
        List<BlogList> blogLists = queryForList(BlogList.class, sql);
        String sql2 = "select count(*) from BlogList";
        String sql3 = "select count(*) from allblogs where marked = ?";
        String sql4 = "select count(*) from allblogs where reco = 1";
        Object o2 = queryForSingleValue(sql4);
        int recoCount = Integer.parseInt(o2.toString());
        Object o = queryForSingleValue(sql2);
        int count = Integer.parseInt(o.toString());
        for(int i = 0; i < count; i++) {
            Object o1 = queryForSingleValue(sql3, blogLists.get(i).getName());
            int blogcount = Integer.parseInt(o1.toString());
            if(i == 0) {
                blogcount = recoCount;
            }
            blogListList.add(new BlogList( blogLists.get(i).getId(), blogLists.get(i).getName(), blogLists.get(i).getCreateTime(),blogcount));
        }
        return blogListList;
    }

//
    @Test
    public void listTest() {
        System.out.println(queryList());
    }
}
