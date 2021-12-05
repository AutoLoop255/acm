<%--
  Created by IntelliJ IDEA.
  User: 79921
  Date: 2021/12/4
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录页面</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="/layui/layui.js"></script>
    <style>
        body{
            /*background-image: url("");*/
            background-position: center center;
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .loginForm{
            width: 400px;
            height: 350px;
            background-color: white;
            padding: 30px 20px;
            margin-top: 50%;
            border-radius: 5px;
            box-shadow: 0 0 5px black;
            box-sizing: border-box;
        }
        h2, button{
            text-align: center;
        }
    </style>
</head>
<body>

<!-- 你的HTML代码 -->
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md5 layui-col-md-offset4">
            <div class="loginForm">
                <h2>书籍管理登录页面</h2>
                <form class="layui-form">
                    <div class="layui-form-item">
                        <label>用户名:</label>
                        <div class="layui-form-block">
                            <input type="text" name="username" required lay-verify="required"
                                   placeholder="请输入用户名" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label>密码:</label>
                        <div class="layui-form-block">
                            <input type="password" name="password" required lay-verify="required"
                                   placeholder="请输入密码" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label>用户模式:</label>
                        <div class="layui-form-block">
                            <input type="radio" name="reg" value="admin" title ="管理员">
                            <input type="radio" name="reg" value="student" title ="学生" checked>
                            <input type="radio" name="reg" value="teacher" title ="教师">
                            <input type="radio" name="reg" value="bookseller" title ="书商">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-form-block">
                            <button type="button" class="layui-btn" lay-submit lay-filter="loginForm">登录</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

<script>
    //一般直接写在一个js文件中

    layui.use(['layer', 'form'], function() {
        var layer = layui.layer
            , $ = layui.$
            , form = layui.form;

        form.on('submit(loginForm)', function (data) {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/login",
                // data: data.field,
                data: data.field,
                success: function (res) {
                    if(res.data == 1 ){
                        window.location.href = 'indexAdmin.jsp';
                    }
                    console.log(res);
                },
                error: function (res){
                    console.log();
                }
            });
        });



    });
</script>
</body>
</html>