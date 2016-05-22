<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/manage/inc/top.jsp"></jsp:include>
<jsp:include page="/manage/inc/menu.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript" src="<%=basePath %>js/manage/jquery-ui-date.js"></script>  
<style type="text/css">
	.main-wrap{
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
  <body>
  <div class="maskLayer"></div>
  <span class="cssload"></span>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="<%=basePath %>manage/index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">管理员</span><span class="crumb-step">&gt;</span><span class="crumb-name">普通管理员</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">查看:</th>
                            <td>
                                <select name="search-sort" id="look">
                                    <option value="all">全部</option>
                                    <option value="1" >可用</option>
                                    <option value="0">不可用</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" style="color: gray;" value="" id="keywords" type="text"></td>
               				<td>开始日期<input type="text" id="startDate" size="10" /></td>
               				<td>结束日期<input type="text" id="endDate" size="10" /></td>
               				<td><input class="btn btn-primary btn2" id="inquiry" value="查询" type="button"></td>
               				
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                
                <!-- 列表可变内容，包含content.jsp阿贾克斯返回的 -->
                <span id="content"></span>
            </form>
        </div>
    </div>
    <!--/main-->
  </body>
  <script type="text/javascript">
	$(function(){
  		var f = $('#look').val();
  		if(f=="all")
  			getContent('true');

  		$('#look').change(function(){
  			var f = $('#look').val();
  			$('#keywords').val("");
  			
  			if(f=="all")
  			{
  				getContent('true');
  			}	
  			
  			if(f=="1")
  			{
  				f = "true";
  				getContent('false',"",f);
  			}
  			
  			if(f=="0")
  			{
  				f = "false";
  				getContent('false',"",f);
  			}
  		});
  		
  		$('#inquiry').click(function(){
  			var startDate = $("#startDate").val();
  			var endDate = $("#endDate").val();
  			
  			if(endDate=="")
  			{
  				endDate = null;
  			} 
  			var f = $('#look').val();
  			var flag;
  			if(f=="all")
  			{
  				f    = "";
  				flag = "true";
  			}
  			if(f=="1")
  			{
  				f = "true";
  				flag = "false";
  			}
  			
  			if(f=="0")
  			{
  				f = "false";
  				flag = "false";
  			}
  			var account = $('#keywords').val();
  			getContent(flag,account,f,startDate,endDate);
  		});
  	});

  	function getContent(flag,account,enable,startDate,endDate){
  		if(account==''){
  			showLoader();
	  		$.post(
	  			'<%=basePath%>manage/admin/content.jsp',
	  			{'isSuper':'false','flag':flag,'enable':enable,'startDate':startDate,'endDate':endDate},
	  			function(e){
	  				var content = $('#content');
	  				var c = $(e);
	  				content.empty();
	  				content.append(c);
	  				clearLoader();
	  			}
	  		);
	  	}
	  	else{
	  		showLoader();
	  		$.post(
	  			'<%=basePath%>manage/admin/content.jsp',
	  			{'isSuper':'false','flag':flag,'account':account,'enable':enable,'startDate':startDate,'endDate':endDate},
	  			function(e){
	  				var content = $('#content');
	  				var c = $(e);
	  				content.empty();
	  				content.append(c);
	  				clearLoader();
	  			}
	  		);
	  	}
  	}
  	//创建Ajax请求时等待的动画
  	function showLoader(){
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
</html>
