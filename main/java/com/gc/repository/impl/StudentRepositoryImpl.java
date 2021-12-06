package com.gc.repository.impl;

import com.gc.entity.Student;
import com.gc.repository.StudentRepository;
import com.gc.util.C3p0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    /**
     * 添加一个student
     *
     * 传入的数据中student 的 id是null，插入时也不会拿到id。
     *
     * @param student
     * @return true成功添加， false 添加出错
     */
    @Override
    public boolean Add(Student student) {
    QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
    try {
        qr.update("insert into student(name, sid, sex, age, password, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?)",
            student.getName(),
            student.getSid(),
            student.getSex(),
            student.getAge(),
            student.getPassword(),
            student.getPhone(),
            student.getEmail()
                );
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 查询所有的学生
     * @return List集合
     */
    @Override
    public List<Student> FindAll() {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        try {
            List<Student> query = qr.query("select * from student", new BeanListHandler<>(Student.class));

            return query;
        } catch (SQLException e) {
            e.printStackTrace();
           return null;
        }
    }

    /**
     *
     * @param id 数据库唯一id
     *
     * @return true成功删除， false 删除出错
     */
    @Override
    public boolean DelById(Long id) {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        try {
            int res = qr.update("delete from student WHERE id = ?", id);
            System.out.println(res);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Student FindById(Long id) {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        try {
            Student res = qr.query("select * from student WHERE id = ?", new BeanHandler<>(Student.class),
                    id);
            System.out.println(res);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param student
     * @return
     */
    @Override
    public boolean UpdateById(Student  student) {
        QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
        try {
            int res = qr.update("update student set name = ?, sid = ?, sex = ?, age = ?, password = ?, phone = ?, email = ? WHERE id = ?",
                    student.getName(),
                    student.getSid(),
                    student.getSex(),
                    student.getAge(),
                    student.getPassword(),
                    student.getPhone(),
                    student.getEmail(),
                    student.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
           return false;
        }
    }


}
