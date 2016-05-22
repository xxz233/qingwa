<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath %>js/jquery.1.10.1.min.js"></script>
<s:action name="adminActionManage_findAll" namespace="/manage"></s:action>
<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<div class="result-title">
        <div class="result-list">
            <a href="insert.html"><i class="icon-font"></i>添加管理员</a>
            <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
        </div>
    </div>
	 <div class="result-content">
             <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" id="top" type="checkbox"></th>
                            <th>帐号</th>
                            <th>最后登录时间</th> 
                            <th>最后登录IP</th>
                            <th>登录次数</th>
                            <th>添加时间</th>
                            <th>操作</th>
                        </tr>
                        <s:iterator value="#request.admins" var="admin">
                        	
	                        <tr id="tr${id }">
	                        	<td class="tc" width="5%"><input class="allChoose" id="check${id }" type="checkbox"></td>
	                            <td>${account}</td>
	                            <td>${loginTime }</td>
	                            <td>${loginIp }</td>
	                             <td>${count }</td>
	                            <td>
	                            	<s:date name="#attr.inputTime" format="yyyy/MM/dd HH:mm:ss"/>
	                            </td>	      

	                            <td>
	                                <a class="link-update" id="update${id }" href="<%=basePath%>manage/admin/update.jsp?id=${id}">修改</a>
	                                <a class="link-del" id="delete${id }"   href="javascript:void(0)">删除</a>
	                            </td>
	                        </tr>
                        </s:iterator>
              </table>
</div>
<script type="text/javascript">

//单选删除
$("[id^='delete']").click(function(){
	var id = $(this).attr("id").substr(6);
	
	$.get("<%=basePath%>manage/adminActionManage_delete",
		  {id:id},
		  function(){
		  	$("#tr"+id).remove();
		  });
	
});

//全部选中
$("#top").click(function(){
	$(":checkbox[id^='check']").prop("checked",$(this).prop("checked"));
});

//多选删除
$("#batchDel").click(function(){
	var ids = "";

	$(":checked[id^='check']").each(function(){
		var id = $(this).attr("id").substr(5);
		ids += id+",";
	});
	
	if(ids!="")
	{
		ids = ids.substring(0, ids.length-1);
	}
	
	$.get("<%=basePath%>manage/adminActionManage_batchDelete",
		 {adminIds:ids},
		 function(){
		 	$(":checked[id^='check']").each(function(){
		 		var id = $(this).attr("id").substr(5);
		 		$("#tr"+id).remove();
		 	});
		 ;})
		
});

<%-- //点击修改
$("[id^='update']").click(function(){
	var id = $(this).attr("id").substr(6);
	
	$.get("<%=basePath%>manage/adminActionManage_findById",
		 {id:id},
		 function(mes){
		 
		 	if(mes=="update")
		 	{
		 		window.location.href="<%=basePath%>manage/admin/update.jsp";
		 		return false;
		 	}
		 });
	
}); --%>
</script>
</body>
</html>

