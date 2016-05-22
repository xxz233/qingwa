<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/web/inc/head.jsp"></jsp:include>
<% Cookie[] cookies = request.getCookies();
	String account = "";
	if(cookies!=null){
		for(int i=0; i<cookies.length; i++) {
			// 获得具体的Cookie
            Cookie cookie = cookies[i];
             if (cookie.getName().equals("account")) {
           			String cookieValue = cookie.getValue();
           			account = cookie.getValue();
           		}
		}
	} %>
<body id="login_bg">
	<div class="login_wrapper">
		<div class="login_header">
        	<a href="h/"><img src="<%=basePath %>images/logo_white.png" width="285" height="62" alt="拉勾招聘" /></a>
            <div id="cloud_s"><img src="<%=basePath %>images/cloud_s.png" width="81" height="52" alt="cloud" /></div>
            <div id="cloud_m"><img src="<%=basePath %>images/cloud_m.png" width="136" height="95"  alt="cloud" /></div>
        </div>
        
    	<input type="hidden" id="resubmitToken" value="" />		
		 <div class="login_box">
        	<form id="loginForm">
				<input type="text" id="email" name="email" value="<%=account %>" tabindex="1" placeholder="请输入登录邮箱地址" />
			  	<input type="password" id="password" name="password" tabindex="2" placeholder="请输入密码" />
				<span class="error" style="display:none;" id="beError"></span>
			    <label class="fl" for="remember"><input type="checkbox" id="remember" value="1" checked="checked" name="autoLogin" /> 记住我</label>
			    <a href="reset.html" class="fr" target="_blank">忘记密码？</a>
			    <input type="submit" id="submitLogin" value="登 &nbsp; &nbsp; 录" />
			</form>
			<div class="login_right">
				<div>还没有青蛙帐号？</div>
				<a  href="<%=basePath %>registe.html"  class="registor_now">立即注册</a>
			</div>
        </div>
        <div class="login_box_btm"></div>
    </div>

<script type="text/javascript">
$(function(){
		$('#email').focus(function(){
    		$('#beError').hide();
    	});
	//验证表单
	 	$("#loginForm").validate({
	 		/* onkeyup: false,
	    	focusCleanup:true, */
	        rules: {
	    	   	email: {
	    	    	required: true,
	    	    	email: true
	    	   	},
	    	   	password: {
	    	    	required: true
	    	   	}
	    	},
	    	messages: {
	    	   	email: {
	    	    	required: "请输入登录邮箱地址",
	    	    	email: "请输入有效的邮箱地址，如：vivi@lagou.com"
	    	   	},
	    	   	password: {
	    	    	required: "请输入密码"
	    	   	}
	    	},
	    	submitHandler:function(form){
	    		if($('#remember').prop("checked")){
	      			$('#remember').val(1);
	      		}else{
	      			$('#remember').val(null);
	      		}
	    		var email = $('#email').val();
	    		var password = $('#password').val();
	    		var remember = $('#remember').val();
	    		
	    		$(form).find(":submit").attr("disabled", true);
	            $.ajax({
	            	type:'POST',
	            	data:{account:email,password:password,autoLogin:remember},
	            	url:'<%=basePath%>web/userAction_login',
	            	success:function(e){
	            		if(e=="ok")
	            			location.href = '<%=basePath%>';
	            		else{
	            			$(form).find(":submit").attr("disabled", false);
	            			$('#beError').text("用户名或密码错误").show();
	            		}
	            	}
	            });
					
	        }  
		});
})
</script>
</body>
</html>