package com.gc.util;

import com.gc.entity.Manager;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

// 使用教程：https://www.cnblogs.com/98dkk/p/10150204.html
public class C3p0Utils {
    private static DataSource dataSource;
    static  {
        dataSource = new ComboPooledDataSource("testc3p0");
    }
    public static DataSource getDataSource() {
        dataSource = new ComboPooledDataSource("testc3p0");
        return dataSource;
    }

    public static void main(String[] args) {
        QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
//        queryRunner.update("insert into manager(name, aid, password, phone, email) values(?,?,?,?,?) ",
//                "gc", "888", "123", "123123", "123");
        try {
            List<Manager> managerList = queryRunner.query("select * from manager", new BeanListHandler<>(Manager.class));
            for(Manager manager : managerList) {
                System.out.println(manager);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
