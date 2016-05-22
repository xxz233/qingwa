<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <body>
  <jsp:include page="/manage/inc/top.jsp"></jsp:include>
  <jsp:include page="/manage/inc/menu.jsp"></jsp:include>
  <script type="text/javascript" src="<%=basePath %>js/manage/jquery-ui-date.js"></script>  
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                    <table class="search-tab">
                        <tr>
                         <!--   <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                             -->
                             <th width="50">查看:</th>
                            <td>
                                <select name="search-sort" id="look">
                                    <option value="all">全部</option>
                                    <option value="1" >可用</option>
                                    <option value="0">不可用</option>
                                </select>
                            </td>
                            <th width="50">账号:</th>
                            <td><input class="common-text" placeholder="账号" id="account" name="account" type="text"></td>
                            <th width="70">用户名:</th>
                            <td><input class="common-text" placeholder="用户名" id="userName" name="userName" type="text"></td>
                            <th width="70">开始日期:</th>
                            <td><input type="text" id="startDate" size="10" /></td>
                            <th width="70">结束日期:</th>
               				<td><input type="text" id="endDate" size="10" /></td>
                            <td><input class="btn btn-primary btn2" value="查询" type="button"  onclick="javascript:findUser()"></td>
                        </tr>
                    </table>
            </div>
        </div>
        <span id="content"></span>
    </div>
    <!--/main-->
</div>
  </body>
  <script type="text/javascript">
  var userName=$("#userName").val();
  var account = $("#account").val();
  var flag = $("#look").val();
  var startDate = $("#startDate").val();
  var endDate = $("#endDate").val();
  function findUser()
  {
	  location.reload();
  }
  $(function()
  {
	  getContent('${sessionScope.pager.pageNo}',userName,account,flag,startDate,endDate,true);
  });
  function getContent(pageNo,userName,account,flag,startDate,endDate,isReSet)
  {
	  showLoader();
  	$.post(
  			'<%=basePath %>manage/userActionManage_findAll',
  			{'pageNo':pageNo,'userName':userName,'account':account,'flag':flag,'startDate':startDate,'endDate':endDate,'isReSet':isReSet},
  			function(e)
  			{
  				var content = $('#content');
  				content.empty();
  				content.append(e);
  				clearLoader();
  			}
  	)
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
