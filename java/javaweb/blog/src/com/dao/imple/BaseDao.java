package com.dao.imple;

import com.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

//      获取dbUtils提供的QueryRunner对象去操作数据库
    private QueryRunner runner = new QueryRunner();
//          通用的crud方法
    public int update(String sql, Object... args) {
//          Connection对象需要我们自己创建，preparestatement和resultset对象导入的jar包中帮我们创建好了
        Connection connection = JdbcUtils.getConnection();
        try {
            return runner.update(connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.sourceClose(connection);
        }
        return -1;
    }

    @Test
    public void test1() {
//        新建表格数据
        String table = "UserMessage";
        String sql = "insert into " + table + " values(?,?,?)";
        update(sql,"2","1","5");

//        新建表格
//        String table = "test";
//        String sql = "create table " + table + "(id int(10),name varchar(10))";
//        update(sql);
//        String sql2 = "insert into " + table + " value(?,?)";
//        update(sql2,1,"test");
    }

//         通用的查询然后返回一个对象操作
    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection connection1 = JdbcUtils.getConnection();
        try {
            return runner.query(connection1,sql,new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.sourceClose(connection1);
        }
        return null;
    }

    //     通用的查询然后返回多个对象
    public <T>List<T> queryForList(Class<T> type,String sql,Object ...args){
        Connection connection1 = JdbcUtils.getConnection();
        try {
            return runner.query(connection1,sql,new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.sourceClose(connection1);
        }
        return null;
    }

    //     通用查询然后返回单个值的情况
    public Object queryForSingleValue(String sql,Object ...args){
        Connection connection2 = JdbcUtils.getConnection();
        try {
            return runner.query(connection2,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.sourceClose(connection2);
        }
        return null;
    }



}
