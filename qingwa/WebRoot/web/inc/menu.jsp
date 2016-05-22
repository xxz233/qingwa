<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <div id="header">
    	<div class="wrapper">
    		<a href="<%=basePath %>" class="logo">
    			<img src="<%=basePath %>images/logo.png" width="229" height="43" alt="拉勾招聘-专注互联网招聘" />
    		</a>
    		<ul class="reset" id="navheader">
	    	</ul>
	    	<!-- 如果用户未登陆则显示登陆和注册链接，否则显示个人菜单 -->
	    	<s:if test="#session.user==null">
	    		<ul class="loginTop">
            	<li><a href="<%=basePath %>login.html" rel="nofollow">登录</a></li> 
            	<li>|</li>
            	<li><a href="<%=basePath %>registe.html" rel="nofollow">注册</a></li>
            </ul>
	    	</s:if>
        	<s:else>
        		<dl class="collapsible_menu" id="${sessionScope.user.type}"> 
			      <dt> 
			       <span><s:if test="#attr.user.userName==null">${sessionScope.user.account }</s:if><s:else>${sessionScope.user.userName }</s:else>&nbsp;</span> 
			       <span class="red dn" id="noticeDot-0"></span> 
			       <i></i> 
			      </dt> 
			     
		     </dl> 
		     <div class="dn" id="noticeTip"> 
		      <span class="bot"></span> 
		      <span class="top"></span> 
		      <a target="_blank" href="delivery.html"><strong>0</strong>条新投递反馈</a> 
		      <a class="closeNT" href="javascript:;"></a> 
		     </div> 
        	</s:else>
      </div>
  </div><!-- end #header -->
  <!-- 使用javascript获取菜单 -->
  <script type="text/javascript">
  	var userId ='user${sessionScope.user.id }';//标志用户是否登陆
  	var personalMenu = $('.collapsible_menu');//个人菜单容器
  	var navheader = $('#navheader');//顶部导航菜单容器
  	var curr = '${param.curr}';//标志当前导航所在位置
  	$(function(){
  		//用户登录，初始化个人菜单和导航菜单
  		if(userId.length!=4){
  			getPersonalMenu(personalMenu.attr('id'));
  			getTopMenu(personalMenu.attr('id'),'top',0);
  		}
  		else{//用户未登陆，隐藏我的简历或我的公司
  			getTopMenu('false','top',1);
  		}
  	})
  	//获取登录后的个人菜单
  	function getPersonalMenu(type){
  	//向服务器请求数据，返回的是json格式的数据
  		$.post('<%=basePath %>web/personalMenuAction_findByType',{'type':type},function(e){
  			//遍历json数组
  			var json = eval(e);//转换为json数组对象
  			for(var i=0; i<json.length; i++){
  				var obj = $('<a></a>');
  				if(json[i].title=='退出')
  					obj.attr('href','<%=basePath %>web/userAction_exit');
  				else
  					obj.attr('href','<%=basePath %>'+json[i].url);
  				obj.attr('target',json[i].target);
  				obj.attr('rel','nofollow');
  				obj.html(json[i].title);
  				if(i==json.length-3)
  					var dd =  $('<dd class="btm"></dd>');//带分割线
  				else
  					var dd = $('<dd></dd>');
  				dd.append(obj);
  				personalMenu.append(dd);
  			}
  		});
  	}
  	//获取顶部菜单，如果未登录则默认显示个人用户的菜单，并且隐藏我的简历
  	function getTopMenu(type,position,index){
  	//向服务器请求数据，返回的是json格式的数据
  		$.post('<%=basePath %>web/webMenuAction_findByTypeAndPosition',{'type':type,'position':position},function(e){
  			//遍历json数组
  			var json = eval(e);//转换为json数组对象
  			for(var i=0; i<json.length-index; i++){
  				var obj = $('<a></a>');
  				var li = $('<li></li>');
  				if(curr=='index'&&json[i].url=='index.html')
  					li.addClass('current');
  				else if(curr=='job'&&json[i].url=='job.html')
  					li.addClass('current');
  				else if(curr=='company'&&json[i].url=='company.html')
  					li.addClass('current');
  				else if(curr=='watang'&&json[i].url=='watang.html')
  					li.addClass('current');
  				else if(curr=='resume'&&json[i].url=='resume.html')
  					li.addClass('current');
  				else if(curr=='my_company'&&json[i].url=='my_company.html')
  					li.addClass('current');
  				obj.attr('href','<%=basePath %>'+json[i].url);
  				obj.attr('target',json[i].target);
  				obj.attr('rel','nofollow');
  				obj.html(json[i].title);
  				li.append(obj);
  				navheader.append(li);
  			}
  		});
  	}
  </script>
