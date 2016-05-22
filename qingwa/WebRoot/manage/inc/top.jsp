<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>青蛙人才招聘网后台管理系统</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/manage/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/manage/main.css"/>
    <script type="text/javascript" src="<%=basePath %>js/manage/modernizr.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery.1.10.1.min.js"></script>
    <link rel="stylesheet" href="<%=basePath %>plugins/jquery-ui/jquery-ui.min.css">
    <script type="text/javascript" src="<%=basePath %>plugins/jquery-ui/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="<%=basePath %>plugins/cssloader/loaders.css">
 </head>
  
  <body>
    <div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.html">首页</a></li>
                <li><a href="http://www.mycodes.net/" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">${sessionScope.admin.account}</a></li>
                <li><a href="<%=basePath%>manage/admin/password.jsp">修改密码</a></li>
                <li><a href="<%=basePath%>manage/login.jsp">退出</a></li>
            </ul>
        </div>
    </div>
</div>

  </body>
</html>
