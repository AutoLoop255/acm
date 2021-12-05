package com.gc.controller;

import com.gc.entity.Student;
import com.gc.repository.StudentRepository;
import com.gc.repository.impl.StudentRepositoryImpl;
import com.gc.util.result.R;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentFindById", value = "/studentFindById" )
public class studentFindById extends HttpServlet {
    StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        Long id = Long.valueOf(request.getParameter("id"));
        Student student = studentRepository.FindById(id);
        System.out.println("测试根据id查找学生");
        System.out.println(student);
        response.getWriter().write(gson.toJson(R.ok().data(student)));
    }
}
