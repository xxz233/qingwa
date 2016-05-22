<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/manage/inc/top.jsp"></jsp:include>
<jsp:include page="/manage/inc/menu.jsp"></jsp:include>

<s:action name="manageMenuActionManage_findAll" namespace="/manage" ></s:action>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="<%=basePath %>js/jquery.1.10.1.min.js"></script>
  </head>
  
  <body>
  <div class="container clearfix">
    <div class="main-wrap">
                   				
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">作品管理</a><span class="crumb-step">&gt;</span><span>新增作品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="" method="post" id="form" name="form" enctype="multipart/form-data">
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120"><i class="require-red">*</i>是否超级管理员:</th>
                            <td>
                               	<div> 
                               		   是<input type="radio" value="1" name="isSuper" id="yes" checked="checked">	 									  
 									   否<input type="radio" value="0" name="isSuper" id="no" > 
 								</div>
                            </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>帐号：</th>
                                <td>
                                    <input class="common-text required" id="account" name="account" size="50" type="text">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>密码：</th>
                                <td>
                                    <input class="common-text required" id="password" name="password" size="50" type="password">
                                </td>
                            </tr>
                   			<tr>
	                   			<th><i class="require-red">*</i>管理权限：</th>
	                   			<td>
	                   			
	                   			<s:iterator value="#request.ManageMenus" var="ManageMenu" >
	                   			<input type="checkbox" name="manageMenu${id}" checked="checked" >
                  					${title}	
	                   			</s:iterator>
	                   			</td>
                   			</tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" id="add" value="添加" type="button">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

    </div>

</div>
<script type="text/javascript">
$(function(){
	
	//设置为超级管理员
	$("#yes").click(function(){
		$(":checkbox[name^='manageMenu']").prop("checked",true);
	});
	//设置为普通管理员
	$("#no").click(function(){
		$(":checkbox[name^='manageMenu']").removeAttr("checked");
	});
	
	//根据管理权限判断是否超级管理员
	$("input[type='checkbox']").click(function(){
		var ids = "";
		var count="";
		$("input[type='checkbox']:checked").each(function(){
			var id = $(this).attr("name").substr(10);
			ids +=id+",";
		});
	
		if(ids!="")
		{
			ids = ids.substring(0, ids.length-1);
		}
		
			$("input[type='checkbox']").each(function(){
				var id = $(this).attr("name").substr(10);
				count +=id+",";
			});
			if(count!="")
			{
				count = count.substring(0, count.length-1);
			}

			if(count.length!=ids.length)
			{	
				$(":radio[id=no]").prop("checked",true);
			}
			else
			{
				$(":radio[id=yes]").prop("checked",true);
			}
		});
	
	
	//添加管理员
	$("#add").click(function(){
	
		var isSuper = $(":checked[name=isSuper]").val();
		var account = $("#account").val();
		var password= $("#password").val();
		var ids="";
		
		$("input[type='checkbox']:checked").each(function(){
			var id = $(this).attr("name").substr(10);
			ids +=id+",";
		});
		
		if(ids.length<=0)
		{
			alert("必须给管理员一个管理权限");
		}
		else
		{
			if(isSuper=='1')
			{
				isSuper="true";
			}
	
			if(account!=""&&password!="")
			{
				if(account.length>6&&password.length>6)
				{
					$.get("<%=basePath%>manage/adminActionManage_save",
						{isSuper:isSuper,account:account,password:password,ids:ids},
						function(mes){
						if(mes=="ok")
							alert("添加成功")
							window.location.href="<%=basePath%>manage/adminActionManage_findPage"
							return false;
						});
					
				}
				else
				{
					alert("账号或密码不能小于6位数");
				}
			}
			else
			{
				alert("账号或密码不能为空");
			}
		}
		
		
	});
});
</script>

</body>
</html>
