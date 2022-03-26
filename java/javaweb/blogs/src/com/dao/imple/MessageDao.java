package com.dao.imple;

import com.pojo.UserMessage;
import java.util.List;

public class MessageDao extends BaseDao {
//   获取按时间降序排序的15条留言
    public List<UserMessage> queryMessages() {
        String sql = "select * from usermessage order by time desc limit 15;";
        return queryForList(UserMessage.class,sql);
    }

//    获取指定时期范围的留言
     public List<UserMessage> queryMessagesByScope(String scope1,String scope2) {
        String sql = "select * from usermessage where time > '" + scope1 + "' and time < '" + scope2 + "'";
        return  queryForList(UserMessage.class,sql);
     }

}
