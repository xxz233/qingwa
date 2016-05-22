<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<s:action name="manageMenuActionManage_findAll" namespace="/manage"></s:action>
<div class="container clearfix"></div>
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                	<s:iterator value="#attr.menus" var="menu">
                		<a href="#"><i class="icon-font">&#xe003;</i>${menu.title }</a>
                		<s:iterator value="#attr.menu.manageMenus" var="item">
                			 <ul class="sub-menu">
		                        <li><a href="<%=basePath%>manage/admin/${item.url}"><i class="icon-font">&#xe008;</i>${item.title }</a></li>
                    		</ul>
                		</s:iterator>
                	</s:iterator>
                 </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->