package com.gc.controller;

import com.gc.service.LoginService;
import com.gc.service.impl.LoginServiceImpl;
import com.gc.util.result.R;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("name") + ":发来post请求");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("get请求已收到");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int res = loginService.login(username, password, 1);
        if(res == 1) {
            response.getWriter().write(gson.toJson(R.ok().data(res)));
        } else {
            response.getWriter().write(gson.toJson(R.error()));
        }


    }
}
