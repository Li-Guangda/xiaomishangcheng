package com.liguangda.utils;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0ConnectionPoolUtils {

    private static DataSource ds = new ComboPooledDataSource();

    public static DataSource getDataSource() { return ds; }
}
