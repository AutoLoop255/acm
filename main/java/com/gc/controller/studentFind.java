package com.gc.controller;

import com.gc.entity.Student;
import com.gc.repository.StudentRepository;
import com.gc.repository.impl.StudentRepositoryImpl;
import com.gc.util.result.R;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentFind", value = "/studentFind" )
public class studentFind extends HttpServlet {
    StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        List<Student> students = studentRepository.FindAll();
        response.getWriter().write(gson.toJson(R.ok().data(students)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        List<Student> students = studentRepository.FindAll();
        response.getWriter().write(gson.toJson(R.ok().data(students)));
    }
}
