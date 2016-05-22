<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery.1.10.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.ui.datetimepicker.min.js"></script>
	<link href="css/manage/admin_login.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
   	<div class="admin_login_wrap">
    <h1 align="center">青蛙网后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="index.html" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="account" id="account" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="password" id="password" size="40" class="admin_input_style" />
                    </li>
					<li>
						<img id="identityCode" name="identityCode" maxlength="5" alt="" src="<%=basePath%>manage/adminActionManage_getCodePig.action">
						<a href="#" id="changeCode">换一个</a>
                        <label for="pwd">验证码：</label>
                        <input type="text" name="code" id="code" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="button" id="dengLu" tabindex="3" value="登录" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    
 <script type="text/javascript">
$(document).ready(function(){
	$("#dengLu").click(function(){
		
		var account = $("#account").val();
		var password = $("#password").val();
		
		var code = $("#code").val();

		$.post("<%=basePath%>manage/adminActionManage_findByAccountAndpassword",
				{account:account,password:password,code:code},
				function(mes){
					
					if(mes=="yzmcw")
					{
						alert("验证码错误");
						$.get("<%=basePath%>manage/adminActionManage_getCodePig",
						function(data){
							var r = Math.random();
				
							$("#identityCode").attr("src","<%=basePath%>manage/adminActionManage_getCodePig");
						
						}); 
					}
					
					if(mes=="cg")
					{
						alert("登录成功");
						window.location.href="<%=basePath%>manage/index.jsp";
						return false;
					}
					
					if(mes=="cw")
					{
						alert("账号或密码错误");
						
						$.get("<%=basePath%>manage/adminActionManage_getCodePig",
						function(data){
							
							var r = Math.random();
							
							$("#identityCode").attr("src","<%=basePath%>manage/adminActionManage_getCodePig");
						});
						return false;
					}
				});
	});

	$("#changeCode").click(function(){
		$.get("<%=basePath%>manage/adminActionManage_getCodePig",
		function(data){
			var r = Math.random();
			
			$("#identityCode").attr("src","<%=basePath%>manage/adminActionManage_getCodePig");
		});			
		
		return false;			   
	});
	
});
 
 </script> 
  </body>
</html>
