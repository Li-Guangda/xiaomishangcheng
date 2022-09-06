package com.liguangda.utils;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner; 
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class MyDBUtils {
    
    private static QueryRunner queryRunner = new QueryRunner(C3P0ConnectionPoolUtils.getDataSource());

    public static <T> T insert(String sql, Object[] params, Class clazz) throws SQLException {
        return (T) queryRunner.insert(sql, new BeanHandler<>(clazz), params);    
    }

    public static int update(String sql, Object[] params) throws SQLException {
        return queryRunner.update(sql, params); 
    }

    public static <T> List<T> query(String sql, Object[] params, Class clazz) throws SQLException {
        return (List<T>) queryRunner.query(sql, new BeanListHandler<>(clazz) ,params);
    }

    public static <T> T queryOne(String sql, Object[] params, Class clazz) throws SQLException {
        return (T) queryRunner.query(sql, new BeanHandler<>(clazz), params);
    }
}
