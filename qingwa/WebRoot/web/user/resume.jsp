<%@ page language="java" import="java.util.*,net.qinghr.qingwa.vo.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int year=1980,month=12,yearNo,monthNo;
%>
<!DOCTYPE HTML>
<html xmlns:wb="http://open.weibo.com/wb"><head>
</script><script type="text/javascript" async="" src="style/js/conversion.js"></script><script src="style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script><style type="text/css"></style>
<meta content="no-siteapp" http-equiv="Cache-Control">
<link  media="handheld" rel="alternate">
<!-- end 云适配 -->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>我的简历</title>
<meta content="23635710066417756375" property="qc:admins">
<meta name="description" content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网">
<meta name="keywords" content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招">
<meta content="QIQ6KC1oZ6" name="baidu-site-verification">

<!-- <div class="web_root"  style="display:none">h</div> -->
<script type="text/javascript">
var ctx = "h";
console.log(1);
</script>
<link href="h/images/favicon.ico" rel="Shortcut Icon">
<link href="<%=basePath %>css/style.css" type="text/css" rel="stylesheet">
<link href="<%=basePath %>css/external.min.css" type="text/css" rel="stylesheet">
<link href="<%=basePath %>css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath %>js/jquery.1.10.1.min.js"></script>
<script src="<%=basePath %>js/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath %>js/ajaxfileupload.js"></script>
<script src="<%=basePath %>js/additional-methods.js" type="text/javascript"></script>
<script type="text/javascript">var youdao_conv_id = 271546; </script> 
<script src="<%=basePath %>js/conv.js" type="text/javascript"></script>
<script src="<%=basePath %>js/ajaxCross.json" charset="UTF-8"></script>
<!-- 包含 -->
<s:action name="resume_findByUserId" namespace="/web"></s:action>
<s:action name="current_findAll" namespace="/web"></s:action>
<s:action name="degree_findAll" namespace="/web"></s:action>
<s:action name="personalExperience_findAll" namespace="/web"></s:action>
<s:action name="companyJobNature_findAll" namespace="/web"></s:action>
<s:action name="area_findAll" namespace="/web"></s:action>
<s:action name="personalSalary_findAll" namespace="/web"></s:action>
</head>
<body>
<input type="hidden" value="${resume.id }" id="resumeid">
<div id="body">
	<!-- 导航栏的位置，已被剪切  -->
    <div id="container">
        
 		<div class="clearfix">
           <div class="content_l">
           	<div class="fl" id="resume_name">
            	<div class="nameShow fl">
            		<h1 id="resumeTitleshow">${resume.title }</h1>
            		<span  class="rename" >重命名</span> | <a target="_blank" href="<%=basePath %>web/user/resume_preview.jsp">预览</a>
           		</div>
           		<form class="fl dn" id="resumeTitleForm">
           			<input type="text" value="${resume.title }" name="resumeName" id="resumeName" class="nameEdit c9">	
           			<a id="resumeTitleSubmit"  href="#">保存</a> | <a target="_blank" href="h/resume/preview.html">预览</a>
           		</form>
           	</div><!--end #resume_name-->
           	<div class="fr c5" id="lastChangedTime">最后一次更新：<span>${resume.eaitTime } </span></div><!--end #lastChangedTime-->
           	<div id="resumeScore">
           		<div class="score fl">
           			<canvas height="120" width="120" id="doughnutChartCanvas" style="width: 120px; height: 120px;"></canvas>
          				<div style="" class="scoreVal"><span>15</span>分</div>
           		</div>	
           		
           		<div class="which fl">
           			<div>工作经历最能体现自己的工作能力，且完善后才可投递简历哦！</div>
           			<span rel="workExperience"><a>马上去完善</a></span>
				</div>
           	</div><!--end #resumeScore-->

           	<div class="profile_box" id="basicInfo">
           		<h2>基本信息</h2>
           		<span class="c_edit"></span>
           		<div class="basicShow">
           			   <span>
           			   <span id="resusername">${resume.userName }</span>&nbsp;
           			   <span id="sresex">${resume.sex }</span>&nbsp;
           			   <span id="sretitle">${resume.degree.title }</span>&nbsp;
           			   <span id="pertitle">${resume.personalExperience.title }</span>&nbsp;
           			    <br>
           			   <span id="restel">${resume.tel }</span>&nbsp;
           			   <span id="resemail">${resume.email }</span>&nbsp;
           			 	<br>
           			   <span id="curtitle">${resume.current.title }</span>       			   
           			   </span>
           			<div class="m_portrait">
                    	<div></div>
                    	<img width="120" height="120" alt="jason" src="<%=basePath %>images/default_headpic.png">
                    </div>
           		</div><!--end .basicShow-->
           		<div class="basicEdit dn">
           			<form id="profileForm">
					  <table>
					    <tbody>
					    <tr>
					      <td valign="top">
					        <span class="redstar">*</span>
					      </td> 
					      <td>
					        <input type="text"  value="" name="username" id="username">
					      </td>
					      <td valign="top"></td> 
					      <td>
					          <ul class="profile_radio clearfix reset">
					            <li>
					           	  	 男<em></em>
					              	<input type="radio"  name="gender" value="男"> 
					            </li>
					            <li>
					            	  女<em></em>
					              	<input type="radio" name="gender" value="女"> 
					            </li>
					          </ul>  
					      </td>
					    </tr>
					    <tr>
					      <td valign="top">
					        <span class="redstar">*</span>
					      </td> 
					      <td>
					      	<input type="hidden" id="topDegree" value="${resume.degree.id }" name="topDegree">
					        <input type="button" value="${resume.degree.id }" id="select_topDegree" class="profile_select_190 profile_select_normal">
							<div class="boxUpDown boxUpDown_190 dn" id="box_topDegree" style="display: none;">
					        	<ul>
					        		<s:iterator value="#request.degrees" var="degree">
					        			<li id="degree${degree.id}">${degree.title }</li>
					        		</s:iterator>
					     		</ul>
					        </div>  
					      </td>
					      <td valign="top">
					        <span class="redstar">*</span>
					      </td> 
					      <td>
					          <input type="hidden" id="workyear" value="" name="workyear">
					          <input type="button" value="" id="select_workyear" class="profile_select_190 profile_select_normal">
							  <div class="boxUpDown boxUpDown_190 dn" id="box_workyear" style="display: none;">
					          	 <ul>
					          	 	<s:iterator value="#request.personalExperiences" var="personalExperience">
					        			<li id="personalExperience${personalExperience.id }">${personalExperience.title }</li>
					        		</s:iterator>
					        	 </ul>
					          </div>  
					      </td>
					    </tr>
					    <tr>
					      <td valign="top">
					        <span class="redstar">*</span>
					      </td> 
					      <td colspan="3">
					          <input type="text"  value="" name="tel" id="tel">
					      </td>
					   	</tr>
					   	<tr>
					      <td valign="top">
					        <span class="redstar">*</span>
					      </td> 
					      <td colspan="3">
					          <input type="text" placeholder="接收面试通知的邮箱" value="" name="email" id="email">
					      </td>
					    </tr>
					    <tr>
					      <td valign="top"> </td> 
					      <td colspan="3">
					          <input type="hidden" id="currentState" value="" name="currentState">
					          <input type="button" value="目前状态" id="select_currentState" class="profile_select_410 profile_select_normal">
							  <div class="boxUpDown boxUpDown_410 dn" id="box_currentState" style="display: none;">
					          	  <ul>
					          	  	<s:iterator value="#request.currents" var="current" >
					       		        <li id="current${current.id }">${current.title }</li>
					       		    </s:iterator>
					        	  </ul>
					          </div>  
					      </td>
					    </tr>
					    <tr>
					      <td></td> 
					      <td colspan="3">
					          <input type="button" id="basicsub" value="保 存" class="btn_profile_save">
					          <a class="btn_profile_cancel" id="basicoff" href="javascript:;">取 消</a>
					      </td>
					    </tr>
					  </tbody></table>
					</form><!--end #profileForm-->
					<div class="new_portrait">
					  <div class="portrait_upload" id="portraitNo">
					      <span>上传自己的头像</span>
					  </div>
					  <div class="portraitShow dn" id="portraitShow">
					    <img width="120" height="120" src="">
					    <span>更换头像</span>
					  </div>
					  <input type="file" value="" title="支持jpg、jpeg、gif、png格式，文件小于5M" onchange="img_check(this,'h/resume/uploadPhoto.json','headPic');" name="headPic" id="headPic" class="myfiles">
						<!-- <input type="hidden" id="headPicHidden" /> -->
					  	<em>
					                  尺寸：120*120px <br>   
					                  大小：小于5M
					  	</em>
					  	<span style="display:none;" id="headPic_error" class="error"></span>
					</div><!--end .new_portrait-->
           		</div><!--end .basicEdit-->
           		<input type="hidden" id="nameVal" value="${resume.userName }">
           		<input type="hidden" id="genderVal" value="${resume.sex }">
           		<input type="hidden" id="topDegreeVal" name="${resume.degree.id }" value="${resume.degree.title }">
           		<input type="hidden" id="workyearVal" name="${resume.personalExperience.id }" value="${resume.personalExperience.title }">
           		<input type="hidden" id="currentStateVal" name="${resume.current.id }" value="${resume.current.title }">
           		<input type="hidden" id="emailVal" value="${resume.email }">
           		<input type="hidden" id="telVal" value="${resume.tel }">
           		<input type="hidden" id="pageType" value="1"> 
           	</div><!--end #basicInfo-->
           	
   <div class="profile_box" id="expectJob">
   	 <h2>期望工作</h2>
   		<span class="c_edit dn"></span>
   		<div class="expectShow dn">
   			<span>
   				<span id="shiqu">${resume.area.title }</span>
   			 	<span id="gongzuoxingzhi">${resume.companyJobNature.title }</span>
   				<span id="zhiwei">${resume.expectedJob }</span>
   				<span id="gongzi">${resume.minSalary }</span> 
   			</span>
   		</div><!--end .expectShow-->
   		<div class="expectEdit dn">
   			<form id="expectForm">
    			<table>
    				<tbody>
    				<tr>
    					<td>
    						<input type="hidden" id="expectCity" value="${resume.area.id} " name="expectCity">
    						<input type="button" value="${resume.area.title }" id="select_expectCity" class="profile_select_287 profile_select_normal">
							<div class="boxUpDown boxUpDown_596 dn" id="box_expectCity" style="display: none;">
				         		<dl>
				       				<dt>主要地区</dt>
				       				<dd>
				       					<s:iterator value="#request.areas" var="area">
						   					<span id="area<s:property value="#area.id"/>"><s:property value="#area.title"/></span>
						   				</s:iterator>
	        						</dd>
	       	  					</dl>
	       	       			</div>  
    					</td>
    					<td>
	    					<ul class="profile_radio clearfix reset">
	    						<s:iterator value="#request.companyJobNatures"  var="companyJobNature">
			    					<li>
					             	 	<s:property value="#companyJobNature.title"/><em></em>
					              		<input type="radio" name="type" > 
					           		</li>
				           		</s:iterator>
	           				</ul> 
    					</td>
    				</tr>
    				<tr>
    					<td>
      						<input type="text" placeholder="期望职位，如：项目经理" value="${resume.expectedJob }" name="expectPosition" id="expectPosition">
						</td>
    					<td>
    						<input type="hidden" id="expectSalary" max="" min="" value="" name="expectSalary">
    						<input type="button" value="${resume.minSalary }" id="select_expectSalary" class="profile_select_287 profile_select_normal">
    						<div class="boxUpDown boxUpDown_287 dn" id="box_expectSalary" style="display: none;">
		         				<ul>
		         					<s:iterator value="#request.personalSalarys" var="personalSalary">
		       							<li min="<s:property value="#personalSalary.minSalary"/>" max="<s:property value="#personalSalary.maxSalary"/>"><s:property value="#personalSalary.title"/></li>
		       						</s:iterator>
		       					</ul>
      					  </div>  
    					</td>
    				</tr>
    				<tr>
    					<td colspan="2">
							<a class="btn_profile_save" id="hopesub"  href="javascript:;">保存</a>
       						<a class="btn_profile_cancel" href="javascript:;">取 消</a>
    					</td>
    				</tr>
    			</tbody>
    		  </table>
   			</form><!--end #expectForm-->
   		</div><!--end .expectEdit-->
      	<div class="expectAdd pAdd">
    		  填写准确的期望工作能大大提高求职成功率哦…<br>
			  快来添加期望工作吧！
			<span>添加期望工作</span>
   		</div><!--end .expectAdd-->	
          		<input type="hidden" id="expectJobVal" value="1">
          		<input type="hidden" id="expectCityVal" value="${resume.area.title }" name="City${resume.area.id }" >
          		<input type="hidden" id="typeVal" value="3">
          		<input type="hidden" id="expectPositionVal" value="${resume.expectedJob }">
          		<input type="hidden" id="expectSalaryVal" value="${resume.minSalary }" name min="${resume.minSalary }" max="${resume.maxSalary }">
      </div><!--end #expectJob-->		
      
 			<!-- 填写简历内容 -->
  </div><!--end .content_l-->
 <!-- 		侧边栏内容                    -->
    
</div>
<!------------------------------------- end ----------------------------------------->  
<script src="<%=basePath %>js/Chart.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/profile.min.js" type="text/javascript"></script>
<!-- <div id="profileOverlay"></div> -->
<div class="" id="qr_cloud_resume" style="display: none;">
	<div class="cloud">
		<img width="134" height="134" src="">
		<a class="close" href="javascript:;"></a>
	</div>
</div>

<!-- 尾部和返回上部标签 -->
<script src="<%=basePath %>js/core.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/popup.min.js" type="text/javascript"></script>

<!-- 自定义 -->
<style>
.error{
	color:red;
}
</style>
<script type="text/javascript">
	var id = $("#resumeid").val();
	$(function(){
		
		
		//修改建立标题
			$("#resumeTitleSubmit").click(function(){
					var resumeName = $("#resumeName").val();
					if(resumeName!="")
					{
						$.post("<%=path%>/web/resume_updateTitle",
								{id:id,title:resumeName},
								function(){
									$("#resumeTitleSubmit").parent().addClass("dn");
							        $("#resumeTitleSubmit").parent().siblings("div").removeClass("dn");
									$("#resumeName").val(resumeName);
									$("#resumeTitleshow").html(resumeName);
								});
					}
					return false;
			});
			//修改基本信息
			$("input[id=basicsub]").click(function(){
				var resname = $("#username").val();
           		var genderVal = $("input[name='gender']:checked").val();
           		var topDegreeVal = $("#topDegree").val();
           		var workyearVal = $("#workyear").val();
           		var currentStateVal = $("#currentState").val();
           		var emailVal = $("#email").val();
           		var telVal = $("#tel").val();
           		$.post("<%=basePath%>web/resume_updateBasic",
           				{id:id,userName:resname,sex:genderVal,"degree.id":topDegreeVal,"personalExperience.id":workyearVal,"current.id":currentStateVal,email:emailVal,tel:telVal},
           				function(){
           					//给显示的标签赋值
           					$("#resusername").html(resname);
           					$("#sresex").html(genderVal);
           					$("#sretitle").html($("#select_topDegree").val());
           					$("#pertitle").html($("#select_workyear").val());
           					$("#restel").html(telVal);
           					$("#resemail").html(emailVal);
           					$("#curtitle").html($("#select_currentState").val()); 
           					//给编辑前显示的隐藏域赋值
             				$("#nameVal").val(resname);
           					$("#genderVal").val(genderVal);
           					$("#topDegreeVal").val($("#select_topDegree").val()).attr("name",topDegreeVal);
           					$("#workyearVal").val($("#select_workyear").val()).attr("name",workyearVal);
           					$("#currentStateVal").val($("#select_currentState").val()).attr("name",currentStateVal);
           					$("#telVal").val(telVal);
           					$("#emailVal").val(emailVal);
           					//把编辑标签隐藏，显示内容标签
           					$("#portraitNo").show(), 
           		       		$("#portraitShow").hide(), 
           		       		$("#basicInfo .c_edit").removeClass("dn"), 
           		       		$("#basicInfo .basicShow").removeClass("dn"), 
           		       		$("#basicInfo .basicEdit").addClass("dn"), j($("#basicInfo"))
             				
           			});
			});
				//基本信息取消操作
			$("a[id='basicoff']").click(function(){
				$("#portraitNo").show(), 
	       		$("#portraitShow").hide(), 
	       		$("#basicInfo .c_edit").removeClass("dn"), 
	       		$("#basicInfo .basicShow").removeClass("dn"), 
	       		$("#basicInfo .basicEdit").addClass("dn"), 
	       		j($("#basicInfo"))
			});
				//修改期望经历
			$("a[id='hopesub']").click(function(){
				var expectPosition = $("#expectCity").val();
				var min = $("#expectSalary").attr("min");
				var max = $("#expectSalary").attr("max");
				b.Cancel(); 
			});
			//让期望工作显示出来
			b.Cancel();
		});
</script>


<script>
$(function(){
	$.ajax({
        url:ctx+"/mycenter/showQRCode",
        type:"GET",
        async:false
   	}).done(function(data){
        if(data.success){
             $('#qr_cloud_resume img').attr("src",data.content);
        }
   	}); 
	var sessionId = "resumeQR"+314873;
	if(!$.cookie(sessionId)){
		$.cookie(sessionId, 0, {expires: 1});
	}
	if($.cookie(sessionId)&&$.cookie(sessionId) != 5){
		$('#qr_cloud_resume').removeClass('dn');
	}
	$('#qr_cloud_resume .close').click(function(){
		$('#qr_cloud_resume').fadeOut(200);
		resumeQR = parseInt($.cookie(sessionId)) + 1;
		$.cookie(sessionId, resumeQR, {expires: 1});
	});
});
$(function(){
	$('#noticeDot-1').hide();
	$('#noticeTip a.closeNT').click(function(){
		$(this).parent().hide();
	});
});
var index = Math.floor(Math.random() * 2);
var ipArray = new Array('42.62.79.226','42.62.79.227');
var url = "ws://" + ipArray[index] + ":18080/wsServlet?code=314873";
var CallCenter = {
		init:function(url){
			var _websocket = new WebSocket(url);
			_websocket.onopen = function(evt) {
				console.log("Connected to WebSocket server.");
			};
			_websocket.onclose = function(evt) {
				console.log("Disconnected");
			};
			_websocket.onmessage = function(evt) {
				//alert(evt.data);
				var notice = jQuery.parseJSON(evt.data);
				if(notice.status[0] == 0){
					$('#noticeDot-0').hide();
					$('#noticeTip').hide();
					$('#noticeNo').text('').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
					$('#noticeNoPage').text('').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
				}else{
					$('#noticeDot-0').show();
					$('#noticeTip strong').text(notice.status[0]);
					$('#noticeTip').show();
					$('#noticeNo').text('('+notice.status[0]+')').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
					$('#noticeNoPage').text(' ('+notice.status[0]+')').show().parent('a').attr('href',ctx+'/mycenter/delivery.html');
				}
				$('#noticeDot-1').hide();
			};
			_websocket.onerror = function(evt) {
				console.log('Error occured: ' + evt);
			};
		}
};
CallCenter.init(url);
</script>
<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button><div id="cboxLoadingOverlay" style="float: left;"></div><div id="cboxLoadingGraphic" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div>
</body></html>