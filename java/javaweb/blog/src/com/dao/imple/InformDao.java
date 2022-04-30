package com.dao.imple;

import com.pojo.Inform;

import java.util.List;

public class InformDao extends BaseDao {

    public int getInformCountByUsername(String username) {
        String sql = "select count(*) from inform where flag = 0";
        Object o = queryForSingleValue(sql);
        int count = Integer.parseInt(o.toString());
        return count;
    }

    public List<Inform> getInformByUsername(String username) {
//      把flag设为1代表已读
        String sql2 = "update inform set flag = 1 where owner = ?";
        update(sql2,username);

        String sql = "select * from inform where owner = ?";
        List<Inform> informs = queryForList(Inform.class, sql,username);
        return  informs;
    }

    public void sendLikeInformForAuthor(Inform inform) {
        String sql = "insert into inform values(DEFAULT,?,?,?,?,0,?)";
        update(sql,inform.getOwner(),"点赞了你的博客",inform.getBlogid(),inform.getSender(),inform.getBlogtitle());
    }
}
