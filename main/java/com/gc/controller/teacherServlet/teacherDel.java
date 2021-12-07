package com.gc.controller.teacherServlet;

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

@WebServlet(name = "teacherDel", value = "/teacherDel" )
public class teacherDel extends HttpServlet {
    TeacherRepository teacherRepository = new TeacherRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("已经进入后端");
        Gson gson = new Gson();
        String id = request.getParameter("id" );
        System.out.println("DELteacher id: " + id);
        boolean r = teacherRepository.DelById(Long.valueOf(id));
        if(r)
            response.getWriter().write(gson.toJson(R.ok().data("ok")));
        else
            response.getWriter().write(gson.toJson(R.ok().data("error")));
    }
}
