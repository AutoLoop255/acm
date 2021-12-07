package com.gc.controller.studentServlet;

import com.gc.entity.Student;
import com.gc.repository.StudentRepository;
import com.gc.repository.impl.StudentRepositoryImpl;
import com.gc.util.result.R;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "studentAdd", value = "/studentAdd")
public class studentAdd extends HttpServlet {
    StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("yes!!");
        Gson gson = new Gson();

        /**
         *   long id;
         *     String name;
         *     String sid;
         *     String sex;
         *     String age;
         *     String password;
         *     String phone;
         *     String email;
         */
        boolean res = studentRepository.Add(new Student(
                null,
                request.getParameter("name"),
                request.getParameter("sid"),
                request.getParameter("sex"),
                request.getParameter("age"),
                request.getParameter("password"),
                request.getParameter("phone"),
                request.getParameter("email")));
        if(res) {
            response.getWriter().write(gson.toJson(R.ok().data("ok")));
        } else {
            response.getWriter().write(gson.toJson(R.error()));
        }


    }
}
