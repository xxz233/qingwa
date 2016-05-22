<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<s:action name="webMenuAction_findByPosition" namespace="/web"><s:param name="position">bottom</s:param></s:action>
<div id="footer">
	<div class="wrapper">
		<s:iterator value="#attr.webMenus" var="webMenu">
			<a href="<%=basePath %>${webMenu.url}" target="${webMenu.target}" rel="nofollow">${webMenu.title }</a>
		</s:iterator>
	    <a class="footer_qr" href="javascript:void(0)" rel="nofollow">青蛙微信<i></i></a>
	    <s:action name="configAction_findByConfigKey" namespace="/web"><s:param name="configKey">copyRight</s:param></s:action>
		<div class="copyright">&copy;${requestScope.config.configValue} 
		<s:action name="configAction_findByConfigKey" namespace="/web"><s:param name="configKey">beianUrl</s:param></s:action>
		<a target="_blank" href="${requestScope.config.configValue}">
		<s:action name="configAction_findByConfigKey" namespace="/web"><s:param name="configKey">beianNum</s:param></s:action>
		${requestScope.config.configValue}</a></div>
	</div>
</div>
