<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/web/inc/head.jsp"></jsp:include>
<body>
<div id="body">
	<jsp:include page="/web/inc/menu.jsp"><jsp:param value="index" name="curr"/></jsp:include>
    <div id="container">
        				
		<div id="sidebar">
			<div class="mainNavs">
				<s:action name="jobTypeAction_findAll" namespace="/web"></s:action>
				<s:iterator value="#attr.jobTypes" var="jobType">
					<div class="menu_box">
						<div class="menu_main">
							<h2>${jobType.title } <span></span></h2>
								<!-- 循环并判断取出热门职业 -->
								<!-- 循环出二级菜单 -->
								<s:iterator value="#jobType.jobTypes" var="sec">
									<s:iterator value="#sec.jobTypes" var="third">
										<s:if test="#third.isHot">
											<a href="#">${third.title }</a>
										</s:if>
									</s:iterator>
								</s:iterator>
								<!-- end 热门职业 -->
						</div>
						<!-- start 二级菜单 -->
						<div class="menu_sub dn">
					   		<dl class="reset">
					        	<s:iterator value="#jobType.jobTypes" var="sec">
					        		<dt>
					        			<a href="#">${sec.title }</a>
					        		</dt>
					        		<!-- 循环出三级菜单 -->
					        		<dd>
						        		<s:iterator value="#sec.jobTypes" var="third">
						        				<s:if test="#third.isHot">
						        					<a class="curr" href="#">${third.title }</a>
						        				</s:if>
						        				<s:else>
						        					<a href="#">${third.title }</a>
						        				</s:else>
						        		</s:iterator>
					        		</dd>
					        	</s:iterator>
					        </dl>
						</div>
					</div>
				</s:iterator>		
			<a class="subscribe" href="subscribe.html" target="_blank">订阅职位</a>
		</div>
	</div>
		<!-- end sidebar -->
        <div class="content">	
	        			<div id="search_box">
		<form id="searchForm" name="searchForm" action="list.html" method="get">
        <ul id="searchType">
        	        	<li data-searchtype="1" class="type_selected">职位</li>
        	<li data-searchtype="4">公司</li>
        	        </ul>
        <div class="searchtype_arrow"></div>
        <input type="text" id="search_input" name = "kd"  tabindex="1" value=""  placeholder="请输入职位名称，如：产品经理"  />
                <input type="hidden" name="city" id="cityInput" value=""/>
                <input type="submit" id="search_button" value="搜索" />
				
    </form>
</div>

<script type="text/javascript" src="<%=basePath %>js/search.min.js"></script>
<dl class="hotSearch">
	<dt>热门搜索：</dt>
	<s:action name="configAction_findByConfigKey" namespace="/web"><s:param name="configKey">hotSearch</s:param></s:action>
</dl>
<script type="text/javascript">
	$(function(){
		var str = '${requestScope.config.configValue}';
		var hotSearch = $('.hotSearch');
		var words = str.split(',');
		for(var i=0;i<words.length;i++){
			var dd = $('<dd></dd>');
			var obj = $('<a></a>');
			obj.attr('href', '<%=basePath%>#');
			obj.html(words[i]);
			dd.append(obj);
			hotSearch.append(dd);
		}
	});
</script>			
			<div id="home_banner">
	            <ul class="banner_bg">
	            		                <li  class="banner_bg_1 current" >
	                    <a href="h/subject/s_buyfundation.html?utm_source=DH__lagou&utm_medium=banner&utm_campaign=haomai" target="_blank"><img src="style/images/d05a2cc6e6c94bdd80e074eb05e37ebd.jpg" width="612" height="160" alt="好买基金——来了就给100万" /></a>
	                </li>
	                	                <li  class="banner_bg_2" >
	                    <a href="h/subject/s_worldcup.html?utm_source=DH__lagou&utm_medium=home&utm_campaign=wc" target="_blank"><img src="style/images/c9d8a0756d1442caa328adcf28a38857.jpg" width="612" height="160" alt="世界杯放假看球，老板我也要！" /></a>
	                </li>
	                	                <li  class="banner_bg_3" >
	                    <a href="h/subject/s_xiamen.html?utm_source=DH__lagou&utm_medium=home&utm_campaign=xiamen" target="_blank"><img src="style/images/d03110162390422bb97cebc7fd2ab586.jpg" width="612" height="160" alt="出北京记——第一站厦门" /></a>
	                </li>
	                	            </ul>
	            <div class="banner_control">
	                <em></em> 
	                <ul class="thumbs">
	                		                    <li  class="thumbs_1 current" >
	                        <i></i>
	                        <img src="style/images/4469b1b83b1f46c7adec255c4b1e4802.jpg" width="113" height="42" />
	                    </li>
	                    	                    <li  class="thumbs_2" >
	                        <i></i>
	                        <img src="style/images/381b343557774270a508206b3a725f39.jpg" width="113" height="42" />
	                    </li>
	                    	                    <li  class="thumbs_3" >
	                        <i></i>
	                        <img src="style/images/354d445c5fd84f1990b91eb559677eb5.jpg" width="113" height="42" />
	                    </li>
	                    	                </ul>
	            </div>
	        </div><!--/#main_banner-->
			
        	<ul id="da-thumbs" class="da-thumbs">
	        		        		<li >
	                    <a href="h/c/1650.html" target="_blank">
	                        <img src="style/images/a254b11ecead45bda166afa8aaa9c8bc.jpg" width="113" height="113" alt="联想" />
	                        <div class="hot_info">
	                        	<h2 title="联想">联想</h2>
	                            <em></em>
	                            <p title="世界因联想更美好">
	                            	世界因联想更美好
	                            </p>
	                        </div>
	                    </a>
	                </li>
                	        		<li >
	                    <a href="h/c/9725.html" target="_blank">
	                        <img src="style/images/c75654bc2ab141df8218983cfe5c89f9.jpg" width="113" height="113" alt="淘米" />
	                        <div class="hot_info">
	                        	<h2 title="淘米">淘米</h2>
	                            <em></em>
	                            <p title="将心注入 追求极致">
	                            	将心注入 追求极致
	                            </p>
	                        </div>
	                    </a>
	                </li>
                	        		<li >
	                    <a href="h/c/1914.html" target="_blank">
	                        <img src="style/images/2bba2b71d0b0443eaea1774f7ee17c9f.png" width="113" height="113" alt="优酷土豆" />
	                        <div class="hot_info">
	                        	<h2 title="优酷土豆">优酷土豆</h2>
	                            <em></em>
	                            <p title="专注于视频领域，是中国网络视频行业领军企业">
	                            	专注于视频领域，是中国网络视频行业领军企业
	                            </p>
	                        </div>
	                    </a>
	                </li>
                	        		<li >
	                    <a href="h/c/6630.html" target="_blank">
	                        <img src="style/images/f4822a445a8b495ebad81fcfad3e40e2.jpg" width="113" height="113" alt="思特沃克" />
	                        <div class="hot_info">
	                        	<h2 title="思特沃克">思特沃克</h2>
	                            <em></em>
	                            <p title="一家全球信息技术服务公司">
	                            	一家全球信息技术服务公司
	                            </p>
	                        </div>
	                    </a>
	                </li>
                	        		<li >
	                    <a href="h/c/2700.html" target="_blank">
	                        <img src="style/images/5caf8f9631114bf990f87bb11360653e.png" width="113" height="113" alt="奇猫" />
	                        <div class="hot_info">
	                        	<h2 title="奇猫">奇猫</h2>
	                            <em></em>
	                            <p title="专注于移动互联网、互联网产品研发">
	                            	专注于移动互联网、互联网产品研发
	                            </p>
	                        </div>
	                    </a>
	                </li>
                	        		<li  class="last" >
	                    <a href="h/c/1335.html" target="_blank">
	                        <img src="style/images/c0052c69ef4546c3b7d08366d0744974.jpg" width="113" height="113" alt="堆糖网" />
	                        <div class="hot_info">
	                        	<h2 title="堆糖网">堆糖网</h2>
	                            <em></em>
	                            <p title="分享收集生活中的美好，遇见世界上的另外一个你">
	                            	分享收集生活中的美好，遇见世界上的另外一个你
	                            </p>
	                        </div>
	                    </a>
	                </li>
                            </ul>
            
            <ul class="reset hotabbing">
            	            		<li class="current">热门职位</li>
            	            	<li>最新职位</li>
            </ul>
            <div id="hotList">
	            <ul class="hot_pos reset">
	            		            		            				            		<li class="clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/147822.html" target="_blank">运营总监</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>15k-20k</span>
			                        <span><em class="c7">经验：</em> 3-5年</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>发展前景</span>
			                        <br />
				                    <span>1天前发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/399.html" target="_blank">节操精选</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网</span>
			                        			                        <span><em class="c7">创始人：</em>陈桦</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 初创型(天使轮)</span>
			                        <span><em class="c7">规模：</em>少于15人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>移动互联网</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>扁平管理</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="odd clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/147974.html" target="_blank">售前工程师（运维经验优先）</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>6k-12k</span>
			                        <span><em class="c7">经验：</em> 3-5年</span>
			                        <span><em class="c7">最低学历： </em>大专</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>五险一金+商业保险+带薪年假+奖金等</span>
			                        <br />
				                    <span>1天前发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/5232.html" target="_blank">监控宝</a></div>
			                        <span><em class="c7">领域：</em> 云计算\大数据</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 成长型(A轮)</span>
			                        <span><em class="c7">规模：</em>50-150人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>福利好</li>
			                        					                        				                        					                        			<li>商业险</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/148237.html" target="_blank">手机游戏运营</a> 
			                            &nbsp;
			                            <span class="c9">[南京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>4k-8k</span>
			                        <span><em class="c7">经验：</em> 1-3年</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>工作氛围和谐~正面激励成长~福利好~</span>
			                        <br />
				                    <span>1天前发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/8307.html" target="_blank">爱游戏(中国电信游戏基地)</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,游戏</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 初创型(未融资)</span>
			                        <span><em class="c7">规模：</em>150-500人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>年底双薪</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="odd clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/148429.html" target="_blank">葡萄酒内容运营专员</a> 
			                            &nbsp;
			                            <span class="c9">[广州]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>5k-8k</span>
			                        <span><em class="c7">经验：</em> 1-3年</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>喝着世界美酒快乐地工作！</span>
			                        <br />
				                    <span>1天前发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/4474.html" target="_blank">酒咔嚓</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,生活服务</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 初创型(天使轮)</span>
			                        <span><em class="c7">规模：</em>15-50人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>股票期权</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/1221.html" target="_blank">百度移动游戏UI designer</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>7k-14k</span>
			                        <span><em class="c7">经验：</em> 1-3年</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>喜欢游戏，喜欢生活，游戏生活~</span>
			                        <br />
				                    <span>1天前发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/323.html" target="_blank">百度移动游戏</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网</span>
			                        			                        <span><em class="c7">创始人：</em>李彦宏</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 上市公司</span>
			                        <span><em class="c7">规模：</em>2000人以上</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>年终分红</li>
			                        					                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>股票期权</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="odd clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/148188.html" target="_blank">iOS</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>13k-26k</span>
			                        <span><em class="c7">经验：</em> 不限</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>中国第一只能手机广告平台</span>
			                        <br />
				                    <span>1天前发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/1331.html" target="_blank">多盟domob</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网</span>
			                        			                        <span><em class="c7">创始人：</em>齐玉杰</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 成长型(B轮)</span>
			                        <span><em class="c7">规模：</em>150-500人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金 </li>
			                        					                        				                        					                        			<li>股票期权 </li>
			                        					                        				                        					                        			<li>年底双薪 </li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/148393.html" target="_blank">Java</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>15k-25k</span>
			                        <span><em class="c7">经验：</em> 1-3年</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>项目快速发展，技术氛围浓厚，有业界大牛</span>
			                        <br />
				                    <span>09:21发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/1537.html" target="_blank">搜狗</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,搜索</span>
			                        			                        <span><em class="c7">创始人：</em>王小川</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 初创型(未融资)</span>
			                        <span><em class="c7">规模：</em>2000人以上</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        					                        			<li>午餐补助</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="odd clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/148838.html" target="_blank">web前端</a> 
			                            &nbsp;
			                            <span class="c9">[上海]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>6k-12k</span>
			                        <span><em class="c7">经验：</em> 1-3年</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>靠谱的工程师要来靠谱的公司</span>
			                        <br />
				                    <span>00:21发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/195.html" target="_blank">杰派网络</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网</span>
			                        			                        <span><em class="c7">创始人：</em>顾培盟</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 初创型(天使轮)</span>
			                        <span><em class="c7">规模：</em>15-50人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>股票期权</li>
			                        					                        				                        					                        			<li>年底双薪</li>
			                        					                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/148849.html" target="_blank">Java</a> 
			                            &nbsp;
			                            <span class="c9">[杭州]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>15k-30k</span>
			                        <span><em class="c7">经验：</em> 不限</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>有技术挑战、有成长机会、有漂亮妹子</span>
			                        <br />
				                    <span>09:08发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/108.html" target="_blank">蘑菇街</a></div>
			                        <span><em class="c7">领域：</em> 电子商务</span>
			                        			                        <span><em class="c7">创始人：</em>陈琪</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 成熟型(C轮)</span>
			                        <span><em class="c7">规模：</em>150-500人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>管理规范</li>
			                        					                        				                        					                        			<li>无限零食饮料</li>
			                        					                        				                        					                        			<li>轻时尚</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="odd clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/148978.html" target="_blank">测试实习生</a> 
			                            &nbsp;
			                            <span class="c9">[上海]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>3k-5k</span>
			                        <span><em class="c7">经验：</em> 不限</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>实习通过，毕业直接转正，实习期有餐贴</span>
			                        <br />
				                    <span>10:16发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/4490.html" target="_blank">一铺科技</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,企业服务</span>
			                        			                        <span><em class="c7">创始人：</em>William</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 成长型(A轮)</span>
			                        <span><em class="c7">规模：</em>50-150人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>单身住宿</li>
			                        					                        				                        					                        			<li>股票期权</li>
			                        					                        				                        					                        			<li>午餐补助</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/148783.html" target="_blank">网页产品设计师</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>8k-10k</span>
			                        <span><em class="c7">经验：</em> 1-3年</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>六险一金，饭补，班车，晋升机制，氛围好</span>
			                        <br />
				                    <span>14:15发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/8143.html" target="_blank">途家网</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,O2O</span>
			                        			                        <span><em class="c7">创始人：</em>罗军</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 成长型(B轮)</span>
			                        <span><em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="odd clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/148206.html" target="_blank">产品经理（工商系统项目）</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>10k-20k</span>
			                        <span><em class="c7">经验：</em> 5-10年</span>
			                        <span><em class="c7">最低学历： </em>本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>和一群聪明的人共事</span>
			                        <br />
				                    <span>1天前发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/3646.html" target="_blank">PEVC</a></div>
			                        <span><em class="c7">领域：</em> 金融互联网</span>
			                        			                        <span><em class="c7">创始人：</em>兰宁羽</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 成长型(A轮)</span>
			                        <span><em class="c7">规模：</em>50-150人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>节日礼物</li>
			                        					                        				                        					                        			<li>弹性工作</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/147720.html" target="_blank">团队经理</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>10k-15k</span>
			                        <span><em class="c7">经验：</em> 不限</span>
			                        <span><em class="c7">最低学历： </em>大专</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>位置佳，环境优越，发展空间大，薪酬高</span>
			                        <br />
				                    <span>2天前发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/3786.html" target="_blank">宜信公司</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,金融互联网</span>
			                        			                        <span><em class="c7">创始人：</em>唐宁</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 成熟型(D轮及以上)</span>
			                        <span><em class="c7">规模：</em>2000人以上</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>管理规范</li>
			                        					                        				                        					                        			<li>技能培训</li>
			                        					                        				                        					                        			<li>扁平管理</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="odd clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/145249.html" target="_blank">手游商务</a> 
			                            &nbsp;
			                            <span class="c9">[上海]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>6k-10k</span>
			                        <span><em class="c7">经验：</em> 1-3年</span>
			                        <span><em class="c7">最低学历： </em>大专</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>一年两次调薪，免费早、晚餐，项目、年终奖</span>
			                        <br />
				                    <span>2014-06-27</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/4428.html" target="_blank">恺英网络</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,游戏</span>
			                        			                        <span><em class="c7">创始人：</em>王悦</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 初创型(未融资)</span>
			                        <span><em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>游戏公司</li>
			                        					                        				                        					                        			<li>页游</li>
			                        					                        				                        					                        			<li>手游</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	            				            		<li class="clearfix">
		            																		            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/148680.html" target="_blank">市场推广</a> 
			                            &nbsp;
			                            <span class="c9">[上海]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>7k-12k</span>
			                        <span><em class="c7">经验：</em> 1-3年</span>
			                        <span><em class="c7">最低学历： </em>大专</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>年度16薪 市场营销发展方向</span>
			                        <br />
				                    <span>1天前发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10 recompany"><a href="h/c/1235.html" target="_blank">在路上</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,在线旅游</span>
			                        			                        <span><em class="c7">创始人：</em>黄天赐</span>
			                        			                        <br />
			                        <span><em class="c7">阶段：</em> 成熟型(C轮)</span>
			                        <span><em class="c7">规模：</em>50-150人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>弹性工作</li>
			                        					                        				                        					                        			<li>领导好</li>
			                        					                        				                        					                        			<li>移动互联网</li>
			                        					                        				                        </ul>
			                    </div>
			                    			                </li>
	                		                	                
	                	                <a href="list.html" class="btn fr" target="_blank">查看更多</a>
	                	            </ul>
	            <ul class="hot_pos hot_posHotPosition reset" style="display:none;">
	            		            		            				            		<li class="clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/149389.html" target="_blank">高级PHP研发工程师</a> 
			                            &nbsp;
			                            <span class="c9">[南京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>12k-24k</span>
			                        <span><em class="c7">经验：</em>3-5年</span>
			                        <span><em class="c7">最低学历：</em> 本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>IPO了的互联网创业公司，潜力无限！</span>
			                        <br />
				                    <span>15:11发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8250.html" target="_blank">途牛旅游网</a></div>
			                        <span><em class="c7">领域：</em> 电子商务,在线旅游</span>
			                        			                        <span><em class="c7">创始人：</em>于敦德</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>上市公司</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>股票期权</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="odd clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/149388.html" target="_blank">高级搜索研发工程师</a> 
			                            &nbsp;
			                            <span class="c9">[南京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>15k-30k</span>
			                        <span><em class="c7">经验：</em>3-5年</span>
			                        <span><em class="c7">最低学历：</em> 本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>IPO了的互联网创业公司，潜力无限！</span>
			                        <br />
				                    <span>15:09发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8250.html" target="_blank">途牛旅游网</a></div>
			                        <span><em class="c7">领域：</em> 电子商务,在线旅游</span>
			                        			                        <span><em class="c7">创始人：</em>于敦德</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>上市公司</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>股票期权</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/149385.html" target="_blank">高级数据工程师（爬虫、采集、分析）</a> 
			                            &nbsp;
			                            <span class="c9">[南京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>15k-30k</span>
			                        <span><em class="c7">经验：</em>3-5年</span>
			                        <span><em class="c7">最低学历：</em> 本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>IPO了的互联网创业公司，潜力无限！</span>
			                        <br />
				                    <span>15:08发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8250.html" target="_blank">途牛旅游网</a></div>
			                        <span><em class="c7">领域：</em> 电子商务,在线旅游</span>
			                        			                        <span><em class="c7">创始人：</em>于敦德</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>上市公司</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>股票期权</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="odd clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/149380.html" target="_blank">高级JAVA研发工程师/架构师</a> 
			                            &nbsp;
			                            <span class="c9">[南京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>15k-30k</span>
			                        <span><em class="c7">经验：</em>3-5年</span>
			                        <span><em class="c7">最低学历：</em> 本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>IPO了的互联网创业公司，潜力无限！</span>
			                        <br />
				                    <span>15:06发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8250.html" target="_blank">途牛旅游网</a></div>
			                        <span><em class="c7">领域：</em> 电子商务,在线旅游</span>
			                        			                        <span><em class="c7">创始人：</em>于敦德</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>上市公司</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>股票期权</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/73775.html" target="_blank">测试工程师</a> 
			                            &nbsp;
			                            <span class="c9">[成都]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>4k-8k</span>
			                        <span><em class="c7">经验：</em>1-3年</span>
			                        <span><em class="c7">最低学历：</em> 大专</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>让我们共同谱写快乐家新的历史</span>
			                        <br />
				                    <span>14:47发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/15431.html" target="_blank">惠装装修</a></div>
			                        <span><em class="c7">领域：</em> 电子商务</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成长型(B轮)</span>
			                        <span> <em class="c7">规模：</em>50-150人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="odd clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/88497.html" target="_blank">PHP开发工程师</a> 
			                            &nbsp;
			                            <span class="c9">[成都]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>6k-12k</span>
			                        <span><em class="c7">经验：</em>1-3年</span>
			                        <span><em class="c7">最低学历：</em> 大专</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>让我们共同谱写快乐家新的历史</span>
			                        <br />
				                    <span>14:46发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/15431.html" target="_blank">惠装装修</a></div>
			                        <span><em class="c7">领域：</em> 电子商务</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成长型(B轮)</span>
			                        <span> <em class="c7">规模：</em>50-150人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/146689.html" target="_blank">贵宾理财顾问</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>6k-10k</span>
			                        <span><em class="c7">经验：</em>1-3年</span>
			                        <span><em class="c7">最低学历：</em> 大专</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>位置佳，环境优越，发展空间大，薪酬高</span>
			                        <br />
				                    <span>14:42发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/3786.html" target="_blank">宜信公司</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,金融互联网</span>
			                        			                        <span><em class="c7">创始人：</em>唐宁</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成熟型(D轮及以上)</span>
			                        <span> <em class="c7">规模：</em>2000人以上</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>管理规范</li>
			                        					                        				                        					                        			<li>技能培训</li>
			                        					                        				                        					                        			<li>扁平管理</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="odd clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/126310.html" target="_blank">web前端</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>6k-10k</span>
			                        <span><em class="c7">经验：</em>1-3年</span>
			                        <span><em class="c7">最低学历：</em> 本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>六险一金，饭补，班车，晋升机制，氛围好</span>
			                        <br />
				                    <span>14:16发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8143.html" target="_blank">途家网</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,O2O</span>
			                        			                        <span><em class="c7">创始人：</em>罗军</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成长型(B轮)</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/137954.html" target="_blank">海外客服主管-北京-02615</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>6k-8k</span>
			                        <span><em class="c7">经验：</em>3-5年</span>
			                        <span><em class="c7">最低学历：</em> 大专</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>施展个人才华的平台</span>
			                        <br />
				                    <span>14:16发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8143.html" target="_blank">途家网</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,O2O</span>
			                        			                        <span><em class="c7">创始人：</em>罗军</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成长型(B轮)</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="odd clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/124832.html" target="_blank">平面设计</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>6k-8k</span>
			                        <span><em class="c7">经验：</em>1-3年</span>
			                        <span><em class="c7">最低学历：</em> 大专</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>有趣、高薪、具有挑战性</span>
			                        <br />
				                    <span>14:16发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8143.html" target="_blank">途家网</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,O2O</span>
			                        			                        <span><em class="c7">创始人：</em>罗军</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成长型(B轮)</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/124794.html" target="_blank">软件质量保证(SQA)工程师-北京-02531</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>10k-13k</span>
			                        <span><em class="c7">经验：</em>1-3年</span>
			                        <span><em class="c7">最低学历：</em> 本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>六险一金，饭补，班车，晋升机制，氛围好</span>
			                        <br />
				                    <span>14:16发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8143.html" target="_blank">途家网</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,O2O</span>
			                        			                        <span><em class="c7">创始人：</em>罗军</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成长型(B轮)</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="odd clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/123599.html" target="_blank">网络推广</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>10k-13k</span>
			                        <span><em class="c7">经验：</em>3-5年</span>
			                        <span><em class="c7">最低学历：</em> 本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>完善的福利体系，无限的晋升空间</span>
			                        <br />
				                    <span>14:16发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8143.html" target="_blank">途家网</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,O2O</span>
			                        			                        <span><em class="c7">创始人：</em>罗军</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成长型(B轮)</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/120897.html" target="_blank">视觉设计师（网站运营方向）</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>8k-12k</span>
			                        <span><em class="c7">经验：</em>3-5年</span>
			                        <span><em class="c7">最低学历：</em> 本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>薪资高、发展空间大、前景优</span>
			                        <br />
				                    <span>14:16发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8143.html" target="_blank">途家网</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,O2O</span>
			                        			                        <span><em class="c7">创始人：</em>罗军</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成长型(B轮)</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="odd clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/120282.html" target="_blank">资深.Net开发工程师-北京-02466</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>15k-22k</span>
			                        <span><em class="c7">经验：</em>5-10年</span>
			                        <span><em class="c7">最低学历：</em> 本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>六险一金，饭补，班车，晋升机制，氛围好</span>
			                        <br />
				                    <span>14:16发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8143.html" target="_blank">途家网</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,O2O</span>
			                        			                        <span><em class="c7">创始人：</em>罗军</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成长型(B轮)</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	            				            		<li class="clearfix">
		            				            					                	<div class="hot_pos_l">
			                    	<div class="mb10">
			                        	<a href="h/jobs/91655.html" target="_blank">市场策划经理-线上活动-北京-02267</a> 
			                            &nbsp;
			                            <span class="c9">[北京]</span>
			                            			                        </div>
			                        <span><em class="c7">月薪： </em>10k-15k</span>
			                        <span><em class="c7">经验：</em>5-10年</span>
			                        <span><em class="c7">最低学历：</em> 本科</span>
			                        <br />
			                        <span><em class="c7">职位诱惑：</em>六险一金，饭补，班车，晋升机制，氛围好</span>
			                        <br />
				                    <span>14:16发布</span>
			                        <!-- <a  class="wb">分享到微博</a> -->
			                    </div>
			                	<div class="hot_pos_r">
			                    	<div class="mb10"><a href="h/c/8143.html" target="_blank">途家网</a></div>
			                        <span><em class="c7">领域：</em> 移动互联网,O2O</span>
			                        			                        <span><em class="c7">创始人：</em>罗军</span>
			                        			                        <br />
			                        <span> <em class="c7">阶段： </em>成长型(B轮)</span>
			                        <span> <em class="c7">规模：</em>500-2000人</span>
			                        <ul class="companyTags reset">
			                        				                        					                        			<li>绩效奖金</li>
			                        					                        				                        					                        			<li>五险一金</li>
			                        					                        				                        					                        			<li>带薪年假</li>
			                        					                        				                        </ul>
			                    </div>
			                </li>
	                	                	                <a href="list.html?city=%E5%85%A8%E5%9B%BD" class="btn fr" target="_blank">查看更多</a>
	            </ul>
            </div>
            
            <div class="clear"></div>
            <s:action name="webMenuAction_findByPosition" namespace="/web"><s:param name="position">link</s:param></s:action>
			<div id="linkbox">
			    <dl>
			        <dt>友情链接</dt>
			        <dd>
			        	<s:iterator value="#attr.webMenus" var="webMenu">
			        		<a href="${webMenu.url }" target="${webMenu.target }">${webMenu.title }</a> <span>|</span>
			        	</s:iterator>
			          		<a href="h/af/flink.html" target="_blank" class="more">更多</a>
			        </dd>
			    </dl>
			</div>
        </div>	
 	    <input type="hidden" value="" name="userid" id="userid" />
 	    <!-- 微信二维码 -->
 		<div id="qrSide"><a></a></div>
<!-- 快速登录 -->
<s:if test="#attr.user==null">
 <div id="loginToolBar">
	<div>
		<em></em>
		<img src="<%=basePath %>images/footbar_logo.png" width="138" height="45" />
		<span class="companycount"></span>
		<span class="positioncount"></span>
		<a href="#loginPop" class="bar_login inline" title="登录"><i></i></a>
		<div class="right">
			<a href="<%=basePath %>registe.html" class="bar_register" id="bar_register" target="_blank"><i></i></a>
		</div>
		<input type="hidden" id="cc" value="16002" />
		<input type="hidden" id="cp" value="96531" />
	</div>
</div>
</s:if> 
<!-------------------------------------弹窗lightbox  ----------------------------------------->
<% Cookie[] cookies = request.getCookies();
	String account = "";
	if(cookies!=null){
		for(int i=0; i<cookies.length; i++) {
			// 获得具体的Cookie
            Cookie cookie = cookies[i];
             if (cookie.getName().equals("account")) {
           			String cookieValue = cookie.getValue();
           			account = cookie.getValue();
           		}
		}
	} %>
<div style="display:none;">
	<!-- 登录框 -->
	<div id="loginPop" class="popup" style="height:240px;">
       	<form id="loginFormx" class="loginBox">
			<input type="text" id="email" name="email" tabindex="1" value="<%=account %>" placeholder="请输入登录邮箱地址" />
			<input type="password" id="password" name="password" tabindex="2" placeholder="请输入密码" />
			<span class="error" style="display:none;" id="beError"></span>
		    <label class="fl" for="remember"><input type="checkbox" id="remember" value="" checked="checked" name="autoLogin" /> 记住我</label>
		    <a href="h/reset.html" class="fr">忘记密码？</a>
		    <input type="submit" id="submitLogin" value="登 &nbsp; &nbsp; 录" />
		</form>
		<div class="login_right">
			<div>还没有青蛙帐号？</div>
			<a href="<%=basePath %>registe.html" class="registor_now">立即注册</a>
		</div>
    </div><!--/#loginPop-->
</div>
<!------------------------------------- end ----------------------------------------->
<script type="text/javascript" src="<%=basePath %>js/Chart.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/home.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/count.js"></script>
			<div class="clear"></div>
			<input type="hidden" id="resubmitToken" value="" />
	    	<a id="backtop" title="回到顶部" rel="nofollow"></a>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<jsp:include page="/web/inc/foot.jsp"></jsp:include>

<script type="text/javascript" src="<%=basePath %>js/core.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/popup.min.js"></script>

<!-- <script src="style/js/wb.js" type="text/javascript" charset="utf-8"></script>
 -->

</body>
<script type="text/javascript">
$(function(){
		$('#email').focus(function(){
    		$('#beError').hide();
    	});
	//验证表单
	 	$("#loginFormx").validate({
	 		/* onkeyup: false,
	    	focusCleanup:true, */
	        rules: {
	    	   	email: {
	    	    	required: true,
	    	    	email: true
	    	   	},
	    	   	password: {
	    	    	required: true
	    	   	}
	    	},
	    	messages: {
	    	   	email: {
	    	    	required: "请输入登录邮箱地址",
	    	    	email: "请输入有效的邮箱地址，如：vivi@lagou.com"
	    	   	},
	    	   	password: {
	    	    	required: "请输入密码"
	    	   	}
	    	},
	    	submitHandler:function(form){
	    		if($('#remember').prop("checked")){
	      			$('#remember').val(1);
	      		}else{
	      			$('#remember').val(null);
	      		}
	    		var email = $('#email').val();
	    		var password = $('#password').val();
	    		var remember = $('#remember').val();
	    		$(form).find(":submit").attr("disabled", true);
	            $.ajax({
	            	type:'POST',
	            	data:{account:email,password:password,autoLogin:remember},
	            	url:'<%=basePath%>web/userAction_login',
	            	success:function(e){
	            		if(e=="ok")
	            			location.href = '<%=basePath%>';
	            		else{
	            			$(form).find(":submit").attr("disabled", false);
	            			$('#beError').text("用户名或密码错误").show();
	            		}
	            	}
	            });
					
	        }  
		});
})
</script>
<style>
#loginFormx{width:360px; margin:0; border-right:1px dashed #999; float:left;}
#loginFormx a{color:#019875; }
#loginFormx input#email{width:296px;font-size:16px; color:#777; border:none;}
#loginFormx input#password{width:296px;font-size:16px; color:#777;  border:none;}
#loginFormx input:focus{border:2px solid #fff;-webkit-box-shadow: 0px 0px 4px #b5f0e7;-moz-box-shadow: 0px 0px 4px #b5f0e7;box-shadow: 0px 0px 4px #b5f0e7;}
#loginFormx .fr{color:#777; margin-right:45px;}
#loginFormx .fr:hover{color:#019875;}
#loginFormx label{vertical-align:top;}
#loginFormx input[type="checkbox"]{margin-bottom:20px;border:none;background:none}
#loginFormx input[type="text"],#loginFormx input[type="password"]{margin:0 0 20px 0;}
#loginFormx span.error{margin:-10px 0 10px 0; }
.ui-autocomplete{width:488px;background:#fafafa !important;position: relative;z-index:10;border: 2px solid #91cebe;}
.ui-autocomplete-category{font-size:16px;color:#999;width:50px;position: absolute;z-index:11; right: 0px;/*top: 6px; */text-align:center;border-top: 1px dashed #e5e5e5;padding:5px 0;}
.ui-menu-item{ *width:439px;vertical-align: middle;position: relative;margin: 0px;margin-right: 50px !important;background:#fff;border-right: 1px dashed #ededed;}
.ui-menu-item a{display:block;overflow:hidden;}
</style>
</html>	