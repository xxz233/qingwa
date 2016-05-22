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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">公司管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">已通过公司</option><option value="20">未通过公司</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="insert.html"><i class="icon-font"></i>新增作品</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>公司全称</th>
                            <th>公司简称</th>
                            <th>行业领域</th>
                            <th>发展阶段</th>
                            <th>审核状态</th>
                            <th>操作</th>
                        </tr>                            
                        <s:iterator  value="#request.companyInfos"  var="companyInfo"  status="stat">
                        <tr>
                        	<td class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></td>		
                        	<td>${companyInfo.fullName}</td>
                        	<td>${companyInfo.shortName}</td>
                        	<td>${companyInfo.getIndustry().title}</td>
                        	<td>${companyInfo.getCompanyStage().title} <input type="hidden"  value=" "></td>
                            <c:if test="${companyInfo.isValidate==true}"><td>已通过</td></c:if>  
                        	<c:if test="${companyInfo.isValidate==false}"><td>未通过</td></c:if>
                        	<td>
                        		<a href="<%=basePath%>manage/validate/companyInfo.jsp?companyId=${companyInfo.id}">详情</a><!-- companyId为公司id -->
	                         </td>                		
                        	</tr>
                        </s:iterator> 
                    </table>
           
                    <c:if test="${pager.pageNo gt 1}">
                		<a href="<%=basePath%>manage/validate/list.jsp?pageNo=${pager.pageNo-1}">&lt;</a>
               		</c:if>
                	<s:iterator begin="1" end="#request.pager.PageCount" var="i">
                        <a href="<%=basePath%>manage/validate/list.jsp?pageNo=${i}">${i}</a>
                	</s:iterator>
                	<c:if test="${pager.pageNo lt pager.pageCount }">
                		<a href="<%=basePath%>manage/validate/list.jsp?pageNo=${pager.pageNo+1}">&gt;</a>
                	</c:if>
                </div>
            </form>
       	 </div>
    	</div>
    	<!--/main-->
	</div>

  </body>
</html>
