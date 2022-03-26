package com.dao;

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
    public int update(String sql, Object... args) {
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
