<%--
  Created by IntelliJ IDEA.
  User: 79921
  Date: 2021/12/4
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 管理系统大布局 - Layui</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">layout demo</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">

        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    tester
                </a>
                    <dl class="layui-nav-child">
            <dd><a href="">Your Profile</a></dd>
            <dd><a href="">Settings</a></dd>
            <dd><a href="">Sign out</a></dd>
            </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
</div>


    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">


                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">学生管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" onclick="change('stuFind')">学生查询</a></dd>
                        <dd><a href="javascript:;" onclick="change('stuAdd')">学生添加</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" onclick="change('teachFind')">教师查询</a></dd>
                        <dd><a href="javascript:;" onclick="change('teachAdd')">教师添加</a></dd>
                    </dl>
                </li>

            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <iframe src="main/stuFind.html" frameborder="0" id="demoAdmin" style="width: 100%; height: 100%;"></iframe>

        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>
<script src="./layui/layui.js"></script>
<script>
    function change(res) {
        let top = "main/";
        //拿到frame 的object 然后 把 src 改成对应的
        let fobj = document.getElementById("demoAdmin");
        if(res === 'stuFind') {
            fobj.setAttribute("src", top + res + ".html");
        }
        if(res === 'stuAdd') {
            fobj.setAttribute("src", top + res + ".html");
        }
        if(res === 'teachFind') {
            fobj.setAttribute("src", top + res + ".html");
        }
        if(res === 'teachAdd') {
            fobj.setAttribute("src", top + res + ".html");
        }
    }
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;
        $(document).on('click', '')

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });
    });
</script>
</body>
</html>