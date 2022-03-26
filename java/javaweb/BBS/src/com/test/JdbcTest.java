package com.test;

import com.dao.BaseDao;
import com.utils.JdbcUtils;
import org.junit.Test;
import java.sql.Connection;

public class JdbcTest extends BaseDao {
    @Test
//   测试是否正常连接
    public void ConnectionTest() {
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
        try {
            JdbcUtils.sourceClose(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(conn);
    }

//    测试BaseDao的update函数
    @Test
    public void updateTest() {
        String sql = "create table user(id int(5) primary key)";
        update(sql);
    }

}
