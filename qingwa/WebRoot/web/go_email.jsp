<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/web/inc/head.jsp"></jsp:include>
<style type="text/css">
	#login_bg{
		position: relative;
	}
	.tips{
		position: absolute;
		width: 600px;
		height: 50px;
		top:20%;
		left:25%;
		margin-left:10px;
		margin-top:50px;
		font-family: "微软雅黑";
		color: white;
		font-size: large;
	}
	.index{
		color:fuchsia;
	}
	.index:HOVER {
		color:fuchsia;
	}
	
}
</style>
   <body id="login_bg">
	<div class="tips">系统已经给您发送了一封邮件，请点击邮件内的链接完成注册...<a id="mail" class="index" href="" target="_blank">去邮箱</a><br><br>
		<div><span id="second">10</span>秒后自动进入<a class="index" href="<%=basePath %>index.html" target="_self">首页</a></div>
	</div>
   </body>
   <script type="text/javascript">
   		$(function(){
   			var mail = '${param.email}';
   			var str = mail.split("@");
   			$('#mail').attr("href","https://mail."+str[1]);
   			setInterval(second,1000);
   			function second(){
   				var s = $('#second').html();
   				i = parseInt(s);
   				i = i-1;
   				if(i==0)
   					go();
   				s = i + "";
   				$('#second').html(s);
   			}
   			function go(){
   				location.href = '<%=basePath %>index.html';
   			}
   		});
   </script>
  </html>