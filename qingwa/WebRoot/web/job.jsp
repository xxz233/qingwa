<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/web/inc/head.jsp"></jsp:include>
<jsp:include page="/web/inc/menu.jsp"><jsp:param value="job" name="curr"/></jsp:include>