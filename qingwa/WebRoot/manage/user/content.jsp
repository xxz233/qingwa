<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                    	
                        <a id="allDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>	
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%" id="userTable">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox" id="allChoose"></th>
                            <th>排序</th>
                            <!-- <th>ID</th> -->
                            <th>账号</th>
                            <th>用户名</th>
                            <th>登陆次数</th>
                            <th>注册时间</th>
                            <th>操作</th>
                        </tr>
                        <s:iterator value="#request.usersManageList" var="list" status="stat">
                        <tr id="tr${id }">
                            <td class="tc"><input name="id[]" type="checkbox" id="check${id}"></td>
                            <td>${stat.count}</td>
                            <!-- <td>${id}</td> -->
                            <td>${account}</td>
                            <td title="${userName }">${userName }</td>
                            <td>2</td>
                            <td><s:date name="inputTime" format="yyyy-MM-dd   HH:mm:ss"/></td>
                            <!-- <td><a href="javascript:void(0);"  id="delete"  name="delete${id}" >删除</a> </td> -->
                            <c:if test="${list.enable}" var="isSu">
                            	<td>
                            		<a href="javascript:void(0);"  id="delete"  name="delete${id}" >删除</a> 
                            	</td>
                            </c:if>
							<c:if test="${not isSu}">
								<td>
                            		<a href="javascript:void(0);"  id="edit"  name="edit${id}" >还原</a> 
                            	</td>	
							</c:if>
                        </tr>
                        </s:iterator>
                    </table>
                    <c:if test="${sessionScope.pager.dataCount==0}" var="isShow">
                    <p align="center" style="font-size:20">没有搜索到结果</p>
                    </c:if>
                    <c:if test="${not isShow}">
                    <div class="list-page">
                    <s:iterator status="stat" begin="1" end="#attr.pager.pageCount">
                    			<a href="javascript:getContent('${stat.index+1}','${sessionScope.user.userName}','${sessionScope.user.account}','${sessionScope.flag}','${sessionScope.startDate}','${sessionScope.endDate}','false');">${stat.index+1 }</a>
                    </s:iterator>
                    </div>
                    </c:if>
                </div>
            </form>
        </div>
       <script>
     //全选
		$("#allChoose").click(function(){
			$(":checkbox[id^='check']").prop("checked",$(this).prop("checked"));
		})
       		$(function(){
       			$('#delete[name^=delete]').click(function(){
       				var ids = $(this).attr('name').substr(6);
       				$.post(
       					'<%=basePath %>manage/userActionManage_delete',
       					{ids:ids},
       					function(e){
       							getContent(
       									'${sessionScope.pager.pageNo}',
       									'${sessionScope.user.userName}',
       									'${sessionScope.user.account}',
       									'${sessionScope.flag}',
       									'${sessionScope.startDate}',
       									'${sessionScope.endDate}',
       									'false'
       									);
       						}
       				);
       		  });
       			$('#allDel').click(function(){
       				var ids = "";
       				$(":checked[id^='check']").each(function(){
       					id=$(this).attr('id').substr(5);
       					ids+=id+",";
       				})
       				if(ids!="")
					{
						ids = ids.substring(0,ids.length-1);
					}
       				$.post(
           					'<%=basePath %>manage/userActionManage_delete',
           					{ids:ids},
           					function(e){
           							getContent(
           									'${sessionScope.pager.pageNo}',
           									'${sessionScope.user.userName}',
           									'${sessionScope.user.account}',
           									'${sessionScope.flag}',
           									'${sessionScope.startDate}',
           									'${sessionScope.endDate}',
           									'false'
           									);
           						}
           				);
       			})
       			$('#edit[name^=edit]').click(function(){
   				var ids = $(this).attr('name').substr(4);
   				$.post(
   					'<%=basePath %>manage/userActionManage_update',
   					{ids:ids},
   					function(e){
   							getContent(
   									'${sessionScope.pager.pageNo}',
   									'${sessionScope.user.userName}',
   									'${sessionScope.user.account}',
   									'${sessionScope.flag}',
   									'${sessionScope.startDate}',
   									'${sessionScope.endDate}',
   									'false'
   							);
   						}
   				);
       			});
       		});
       </script>