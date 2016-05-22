<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/manage/common.css"/>
 <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/manage/main.css"/>
 
<jsp:include page="/manage/inc/top.jsp"></jsp:include>
<jsp:include page="/manage/inc/menu.jsp"></jsp:include>
<div class="container clearfix">
   
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用『豪情』博客程序，建博的首选工具。</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="#"><i class="icon-font">&#xe001;</i>新增作品</a>
                    <a href="#"><i class="icon-font">&#xe005;</i>新增博文</a>
                    <a href="#"><i class="icon-font">&#xe048;</i>新增作品分类</a>
                    <a href="#"><i class="icon-font">&#xe041;</i>新增博客分类</a>
                    <a href="#"><i class="icon-font">&#xe01e;</i>作品评论</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>修改基本信息</h1>
            </div>
            <div class="result-content">
                <form id="form" action="<%=path%>/login_updatePassword?id=${sessionScope.admin.id}" method="post">
                	<div>
                		当前密码  <input type="password" id="now">
                	</div>
                	<div>
                		新改密码  <input type="password" id="password" name="password">
                	</div>
                	<div>
                		再次确认  <input type="password" id="passTwo">
                	</div>
                	
                	<div>
                			<input type="button" value="确定" onclick="queDing()">
                			<input type="button" value="返回" onclick="fanHui()">
                	</div>
                
                </form>
            </div>
        </div>
       
    </div>
    <!--/main-->
</div>
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>

<script>
function queDing()
{
	var dangQian = $("#now").val();
	if(dangQian!="${sessionScope.admin.password}")
	{
			alert("当前密码输入有误,请重新输入");
			
			var now = document.getElementById("now");
			var one = document.getElementById("password");
			var two = document.getElementById("passTwo");
			one.value = "";
			two.value = "";
			now.value = "";
			
			return;
	}
	var password = $("#password").val();
	var passTwo = $("#passTwo").val();
	
	if(password.length<3||password.length>10)
	{
		alert("密码长度不符合规范,请重新输入");
		
		var now = document.getElementById("now");
		var one = document.getElementById("password");
		var two = document.getElementById("passTwo");
		one.value = "";
		two.value = "";
		now.value = "";
		
		return;
	}
	
	if(password!=passTwo)
	{
		alert("两次密码输入不一致,请重新输入");
		
		var now = document.getElementById("now");
		var one = document.getElementById("password");
		var two = document.getElementById("passTwo");
		one.value = "";
		two.value = "";
		now.value = "";
		
		return;	
	}
	
	$("#form").submit();
	alert("修改成功,新密码为"+(password)+"请记住");
	
}

function fanHui()
{
	history.back();
		
}
</script>
</body>
</html>