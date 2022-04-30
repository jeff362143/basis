package com.service;

import com.dao.imple.BlogListDao;
import com.pojo.BlogList;

import java.util.List;

public class BlogListService {
    private BlogListDao blogListDao = new BlogListDao();

//   查询并返回了BlogList表中的所有Blog项
    public List<BlogList> getAllBlogList() {
        return blogListDao.queryList();
    }
}
