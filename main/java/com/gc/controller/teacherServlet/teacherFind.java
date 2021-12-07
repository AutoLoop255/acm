package com.gc.controller.teacherServlet;

import com.gc.entity.Teacher;
import com.gc.repository.TeacherRepository;
import com.gc.repository.impl.TeacherRepositoryImpl;
import com.gc.util.result.R;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "teacherFind", value = "/teacherFind" )
public class teacherFind extends HttpServlet {
    TeacherRepository teacherRepository = new TeacherRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        List<Teacher> teachers = teacherRepository.FindAll();
        System.out.println(teachers);
        response.getWriter().write(gson.toJson(R.ok().data(teachers)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        List<Teacher> teachers = teacherRepository.FindAll();
        System.out.println(teachers);
        response.getWriter().write(gson.toJson(R.ok().data(teachers)));
    }
}
