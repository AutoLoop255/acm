package com.gc.repository.impl;

import com.gc.entity.Manager;
import com.gc.repository.LoginRepository;
import com.gc.util.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class LoginRepositoryImpl implements LoginRepository {


    /**
     *  判断是否登录上，
     * @param username
     * @param password
     * @param authority
     *  1代表管理员
     *  2代表学生
     *  3代表教师
     *  4代表书商
     * @return
     *  0代表用户名 / 密码错误
     *  其余代表登录成功：
     *  1代表管理员
     *  2代表学生
     *  3代表教师
     *  4代表书商
     */
    @Override
    public int login(String username, String password, Integer authority) {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        // TODO 现在就只能手机号登录
        switch (authority) {
            case 1:
                try {
                    Manager res = null;
                    res = qr.query("SELECT * FROM manager WHERE phone = ?",
                            new BeanHandler<>(Manager.class), username);
                    System.out.println(res);
                    System.out.println("password: "+ password);
                    if(res == null || !res.getPassword().equals(password)) break;
                    else {
                        System.out.println("yes");
                        return 1;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                break;
        }
        return 0;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

    }
}
