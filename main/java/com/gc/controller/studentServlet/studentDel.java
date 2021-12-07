package com.gc.controller.studentServlet;

import com.gc.repository.StudentRepository;
import com.gc.repository.impl.StudentRepositoryImpl;
import com.gc.util.result.R;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "studentDel", value = "/studentDel" )
public class studentDel extends HttpServlet {
    StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("已经进入后端");
        Gson gson = new Gson();
        String id = request.getParameter("id" );
        System.out.println("DELstudent id: " + id);
        boolean r = studentRepository.DelById(Long.valueOf(id));
        if(r)
            response.getWriter().write(gson.toJson(R.ok().data("ok")));
        else
            response.getWriter().write(gson.toJson(R.ok().data("error")));
    }
}
