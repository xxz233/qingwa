<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="/manage/inc/top.jsp"></jsp:include>
<jsp:include page="/manage/inc/menu.jsp"></jsp:include>
<s:action name="companyInfoActionManage_findAll" namespace="/manage"></s:action>

<s:action name="companyInfoActionManage_findById" namespace="/manage">
		<s:param value="#param.companyId"  name="companyId"></s:param>
</s:action>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript"  src="<%=basePath %>>js/jquery.1.10.1.min.js"></script>
  </head>
  
  <body>
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">作品管理</a><span class="crumb-step">&gt;</span><span>新增作品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                    <table class="insert-tab" width="100%" >
                        <tbody>
                        	<tr>
                            	<th width="30%">公司全称：</th>
                            	<td>${requestScope.oneCompany.fullName}</td>
                        	</tr>
                            <tr>
                                <th>公司简称：</th>
                                <td>${requestScope.oneCompany.shortName}</td>
                            </tr>
                            <tr>
                                <th>公司区域：</th>
                                <td>${requestScope.oneCompany.getArea().title}</td>
                            </tr>
                            <tr>
                                <th>公司地址：</th>
                                <td>${requestScope.oneCompany.address}</td>
                            </tr>
                            <tr>
                                <th>公司产业：</th>
                                <td>${requestScope.oneCompany.getIndustry().title}</td>
                            </tr>
                            <tr>
                                <th>公司规模：</th>
                                <td>${requestScope.oneCompany.getCompanyScale().title}</td>
                            </tr>
                            <tr>
                                <th>发展阶段：</th>
                                <td>${requestScope.oneCompany.getCompanyStage().title}</td>
                            </tr>
                            <tr>
                                <th>发展方向：</th>
                                <td>${requestScope.oneCompany.direction}</td>
                            </tr>
                            <tr>
                                <th>公司描述：</th>
                                <td>${requestScope.oneCompany.detail}</td>
                            </tr>
                            <tr>
                                <th>公司电话：</th>
                                <td>${requestScope.oneCompany.phone}</td>
                            </tr>
                            <tr>
                                <th>公司邮箱：</th>
                                <td>${requestScope.oneCompany.email}</td>
                                <input type="hidden" name="cpId" id="cpId"   value="${requestScope.oneCompany.id}"> <!--  cpid为公司Id -->
                            </tr>
                            <tr>
                                <th>审核状态：</th>
                                <c:if test="${requestScope.oneCompany.isValidate==true}"><td>已通过</td></c:if>  
                        		<c:if test="${requestScope.oneCompany.isValidate==false}"><td>未通过</td></c:if>
                            </tr>
                            <tr>
                                <th>操作：</th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="通过" name ="pass" id="pass" type="button"> <!-- pass为通过 -->
                                    <input class=" btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
  </body>
  
  <script>
  

  	$(document).ready(function(){
  		
  		//点击审核通过
  		var companyId = $("#cpId").val();
  		$("#pass").click(function () {
				$.ajax({
					
					url:"<%=basePath%>manage/companyInfoActionManage_update",
					data:"companyId="+companyId,
					success:function(mes){
						
					}
				});
  		});  		
  	});
  
  </script>
</html>
