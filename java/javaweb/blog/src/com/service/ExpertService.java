package com.service;

import com.dao.imple.ExpertDao;
import com.pojo.Expert;

import java.util.List;

public class ExpertService {
     ExpertDao expertDao = new ExpertDao();

     public List<Expert> getExpertInfo() {
         return expertDao.queryExpert();
     }

     public void updateExpertService(String formerUsername,String username,String desc) {
         expertDao.updateExpertInfo(formerUsername,username,desc);
     }
}
