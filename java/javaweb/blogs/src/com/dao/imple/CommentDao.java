package com.dao.imple;

import com.pojo.Comment;
import org.junit.Test;

import java.util.List;

public class CommentDao extends BaseDao {

    public List<Comment> GetCommentsById(int id) {
//       根据博客id选出它的所有评论
        String sql = "select * from blogcomments where id = ? order by commentTime desc";
        return queryForList(Comment.class,sql,id);
    }

//    保存某一个用户对某一个博客的评论到博客评论表中
    public void SaveCommentFromUser(int id,String username,String comment,String commentTime) {
        String sql = "insert into blogcomments values(?,?,?,?,null)";
        update(sql,id,username,comment,commentTime);
    }

//    根据username获取它的全部评论
    public List<Comment> getCommentsByUsername(String username) {
        String sql = "select * from blogcomments where username = ?";
        return queryForList(Comment.class,sql,username);
    }

//    删除评论
    public void deleteCommentById(int commentId) {
        String sql = "delete from blogcomments where commentid = ?";
        update(sql,commentId);
    }

    @Test
    public void test() {
        List<Comment> comments = GetCommentsById(13);
        System.out.println(comments.toString());
    }
}
