package com.gc.controller;

import com.gc.entity.Student;
import com.gc.repository.StudentRepository;
import com.gc.repository.impl.StudentRepositoryImpl;
import com.gc.util.result.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentUpdateById", value = "/studentUpdateById" )
public class studentUpdateById extends HttpServlet {
    StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        Student student = new Student(Long.valueOf(request.getParameter("id"))
        ,request.getParameter("name"),
                request.getParameter("sid"),
                request.getParameter("sex"),
                request.getParameter("age"),
                request.getParameter("password"),
                request.getParameter("phone"),
                request.getParameter("email"));
        boolean res = studentRepository.UpdateById(student);
        if(res) {
            if(res) {
                response.getWriter().write(gson.toJson(R.ok()));
            } else {
                response.getWriter().write(gson.toJson(R.error()));
            }
        }
    }
}
