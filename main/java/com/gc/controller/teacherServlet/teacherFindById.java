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

@WebServlet(name = "teacherFindById", value = "/teacherFindById" )
public class teacherFindById extends HttpServlet {
    TeacherRepository teacherRepository = new TeacherRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        Long id = Long.valueOf(request.getParameter("id"));
        Teacher teacher = teacherRepository.FindById(id);
        System.out.println("测试根据id查找教师");
        System.out.println(teacher);
        response.getWriter().write(gson.toJson(R.ok().data(teacher)));
    }
}
