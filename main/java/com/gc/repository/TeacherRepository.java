package com.gc.repository;

import com.gc.entity.Teacher;

import java.util.List;

public interface TeacherRepository {
    boolean Add(Teacher Teacher);

    List<Teacher> FindAll();

    boolean DelById(Long id);

    Teacher FindById(Long id);

    boolean UpdateById(Teacher teacher);
}
