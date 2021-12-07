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

@WebServlet(name = "teacherUpdateById", value = "/teacherUpdateById" )
public class teacherUpdateById extends HttpServlet {
    TeacherRepository teacherRepository = new TeacherRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        Teacher teacher = new Teacher(Long.valueOf(request.getParameter("id"))
        ,request.getParameter("name"),
                request.getParameter("tid"),
                request.getParameter("sex"),
                request.getParameter("age"),
                request.getParameter("password"),
                request.getParameter("phone"),
                request.getParameter("email"));
        boolean res = teacherRepository.UpdateById(teacher);
        if(res) {
            if(res) {
                response.getWriter().write(gson.toJson(R.ok()));
            } else {
                response.getWriter().write(gson.toJson(R.error()));
            }
        }
    }
}
