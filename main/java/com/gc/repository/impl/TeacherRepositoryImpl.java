package com.gc.repository.impl;

import com.gc.entity.Student;
import com.gc.entity.Teacher;
import com.gc.repository.TeacherRepository;
import com.gc.util.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TeacherRepositoryImpl implements TeacherRepository {
    /**
     *
     * @param teacher
     * @return
     */
    @Override
    public boolean Add(Teacher teacher) {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        try {
            qr.update("insert into teacher(name, tid, sex, age, password, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    teacher.getName(),
                    teacher.getTid(),
                    teacher.getSex(),
                    teacher.getAge(),
                    teacher.getPassword(),
                    teacher.getPhone(),
                    teacher.getEmail()
            );
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Teacher> FindAll() {

        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        try {
            List<Teacher> query = qr.query("select * from teacher", new BeanListHandler<>(Teacher.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean DelById(Long id) {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        try {
            int res = qr.update("delete from teacher WHERE id = ?", id);
            System.out.println(res);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Teacher FindById(Long id) {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        try {
            Teacher res = qr.query("select * from teacher WHERE id = ?", new BeanHandler<>(Teacher.class),
                    id);
            System.out.println(res);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean UpdateById(Teacher teacher) {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        try {
            int res = qr.update("update teacher set `name` = ?, tid = ?, sex = ?, age = ?, password = ?, phone = ?, email = ? WHERE id = ?",
                    teacher.getName(),
                    teacher.getTid(),
                    teacher.getSex(),
                    teacher.getAge(),
                    teacher.getPassword(),
                    teacher.getPhone(),
                    teacher.getEmail(),
                    teacher.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
