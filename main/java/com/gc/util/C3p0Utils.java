package com.gc.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

// 使用教程：https://www.cnblogs.com/98dkk/p/10150204.html
public class C3p0Utils {
    private static DataSource dataSource = null;
    static  {
        dataSource = new ComboPooledDataSource("testc3p0");
    }
    public static DataSource getDataSource() {
        return dataSource;
    }

}
