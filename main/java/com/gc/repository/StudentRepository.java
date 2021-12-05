package com.gc.repository;

import com.gc.entity.Student;
import com.gc.util.result.R;

import java.util.List;

public interface StudentRepository {
    boolean Add(Student student);

    List<Student> FindAll();

    boolean DelById(Long id);

    Student FindById(Long id);
}
