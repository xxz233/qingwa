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
	.loader{
		position: absolute;
		width: 200px;
		height: 200px;
		top:10%;
		left:40%;
		margin-left:100px;
		margin-top:100px;
	}
	.tips{
		position: absolute;
		width: 200px;
		height: 50px;
		top:30%;
		left:35%;
		margin-left:100px;
		margin-top:50px;
		font-family: "微软雅黑";
		color: white;
		font-size: large;
	}
	.maskLayer{ width:100%; height:900px; background-color:#000000; opacity:0.5; -moz-opacity:0.5; filter:alpha(opacity=50);display: none;}
</style>
<body id="login_bg">
	<div class="maskLayer"></div>
  	<span class="cssload"></span>
	<div class="login_wrapper">
		<div class="login_header">
        	<a href="h/"><img src="<%=basePath %>images/logo_white.png" width="285" height="62" alt="拉勾招聘" /></a>
            <div id="cloud_s"><img src="<%=basePath %>images/cloud_s.png" width="81" height="52" alt="cloud" /></div>
            <div id="cloud_m"><img src="<%=basePath %>images/cloud_m.png" width="136" height="95"  alt="cloud" /></div>
        </div>
        
    	<input type="hidden" id="resubmitToken" value="9b207beb1e014a93bc852b7ba450db27" />		
		<div class="login_box">
        	<form id="loginForm">
        		<ul class="register_radio clearfix">
		            <li>
		            	找工作
		              	<input type="radio" value="0" name="type" />
		            </li>
		            <li>
		           	           招人
		              	<input type="radio" value="1" name="type" /> 
		            </li>
		        </ul> 
            	<input type="text" id="email" name="email" tabindex="1" placeholder="请输入常用邮箱地址" />
                <span class="error" style="display:none;" id="beError"></span>
                <input type="password" id="password" name="password" tabindex="2" placeholder="请输入密码" />
            	<label class="fl registerJianJu" for="checkbox">
            		<input type="checkbox" id="checkbox" name="checkbox" checked  class="checkbox valid" />我已阅读并同意<a href="h/privacy.html" target="_blank">《青蛙用户协议》</a>
           		</label>
                <input type="submit" id="submitLogin" value="注 &nbsp; &nbsp; 册" />
            </form>
            <div class="login_right">
            	<div>已有青蛙帐号</div>
            	<a  href="<%=basePath %>login.html"  class="registor_now">直接登录</a>
            </div>
        </div>
        <div class="login_box_btm"></div>
    </div>
    
    <script type="text/javascript">
    /*
    	注册页面js代码，基于模板修改，在原来代码的基础上做了少量的修改，点击注册会重定向到go_mail页面提示用户去邮箱点击验证链接
    */
    $(document).ready(function(e) {
    	$('.register_radio li input').click(function(e){
    		$(this).parent('li').addClass('current').append('<em></em>').siblings().removeClass('current').find('em').remove();
    	});
    	
    	$('#email').focus(function(){
    		$('#beError').hide();
    	});
    	$('#email').blur(function(){
    		//检查邮箱是否已被注册
    		var email = $('#email').val();
    		$.post(
    			'<%=basePath%>web/userAction_findByAccount',
    			{account:email},
    			function(e){
    				if(e==""){
    					$('#beError').text("此邮箱已被注册").show();
    				}
    			}
    		);
    	});
    	//验证表单
	    	 $("#loginForm").validate({
	    	        rules: {
	    	        	type:{
	    	        		required: true
	    	        	},
			    	   	email: {
			    	    	required: true,
			    	    	email: true
			    	   	},
			    	   	password: {
			    	    	required: true,
			    	    	rangelength: [6,16]
			    	   	},
			    	   	checkbox:{required:true}
			    	},
			    	messages: {
			    		type:{
	    	        		required:"请选择使用拉勾的目的"
	    	        	},
			    	 	email: {
			    	    	required: "请输入常用邮箱地址",
			    	    	email: "请输入有效的邮箱地址，如：vivi@lagou.com"
			    	   	},
			    	   	password: {
			    	    	required: "请输入密码",
			    	    	rangelength: "请输入6-16位密码，字母区分大小写"
			    	   	},
			    	   	checkbox: {
			    	    	required: "请接受拉勾用户协议"
			    	   	}
			    	},
			    	errorPlacement:function(label, element){
			    		if(element.attr("type") == "radio"){
			    			label.insertAfter($(element).parents('ul')).css('marginTop','-20px');
			    		}else if(element.attr("type") == "checkbox"){
			    			label.insertAfter($(element).parent()).css('clear','left');
			    		}else{
			    			label.insertAfter(element);
			    		};	
			    	},
			    	submitHandler:function(form){
			    		var type =$('input[type="radio"]:checked',form).val();
			    		var email =$('#email').val();
			    		var password =$('#password').val();
			    		$(form).find(":submit").attr("disabled", true);	
						showLoader();
			            $.ajax({
			            	type:'POST',
			            	data: {account:email,password:password,type:type},
			            	url:'<%=basePath %>web/userAction_registe',
			            	success:function(){
			            		location.href = '<%=basePath %>go_email/' + email + '/go_email.html';
			            	}
			            }).done(function(result) {
		            		$('#resubmitToken').val(result.resubmitToken);
			            	if(result.success){
			            		window.location.href=result.content;			            		
			            	}else{
								$('#beError').text(result.msg).show();
			            	}
			            	$(form).find(":submit").attr("disabled", false);			           		
			            });
			        }  
	    	});
    });
    //创建Ajax请求时等待的动画
  	function showLoader(){
  		document.addEventListener('DOMContentLoaded', function () {
	     	document.querySelector('main').className += 'loaded';
	    });
  		//显示遮罩层
  		$('.maskLayer').css("display","block");
  		var loaderStr = "<div class='loader'><div class='loader-inner line-scale'><div></div><div></div><div></div><div></div><div></div></div></div>";
   		var tipsStr = "<div class='tips'>系统正在处理,请稍候...</div>";
		//创建loader对象
		var loader = $(loaderStr);
		var tips = $(tipsStr);
		$('.cssload').append(loader);
		$('.cssload').append(tips);
  	}
  	//清除动画
  	function clearLoader(){
  		$('.cssload').empty();
  		//隐藏遮罩层
  		$('.maskLayer').css("display","none");
  	}
    </script>
</body>
</html>

