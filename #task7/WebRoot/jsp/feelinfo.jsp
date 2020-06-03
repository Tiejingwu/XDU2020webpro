<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>My JSP 'info.jsp' starting page</title>
<link href="../img/css.css" rel="stylesheet"/>
<link href="../css/easyui.css" rel="stylesheet"/>
</head>
<body>
				<div class="inner">
					<div class="hd">
						<h3>基本资料
						<c:if test="${state==1 }">
						<a href="<%=path%>/user/feelmy?userid=${user.userid }&currentPage=1" target="iframepage" class="comfirm">说说</a>
						<a href="<%=path%>/user/showMessages?receiveid=${user.userid }&currentPage=1" target="_self" class="comfirm">留言板</a>
						<a href="<%=path%>/user/blackFriend?userid=${user.userid }" class="comfirm" target="iframepage" onclick="return operaconfirm('拉黑');">拉黑</a>
						<a href="<%=path%>/user/deleteFriend?userid=${user.userid }" class="comfirm" target="iframepage" onclick="return operaconfirm('删除');">删除</a>
						</c:if>
						<c:if test="${state==-1 }">
						  <a href="<%=path%>/user/regainFriend?userid=${host.userid }&friendid=${user.userid}" class="comfirm" target="iframepage" onclick="return operaconfirm('恢复好友');" >恢复</a>
					      <a href="<%=path%>/user/deleteblackFriend?userid=${user.userid }" class="comfirm" target="iframepage"  onclick="return operaconfirm('删除');">删除</a>
						</c:if>
						<c:if test="${state==0 }">
						   <a href="<%=path%>/user/refuseFriend?userid=${user.userid }" class="comfirm" target="iframepage"  onclick="return operaconfirm('拒绝');">拒绝</a>
						   <a href="<%=path%>/user/agreeFriend?userid=${user.userid }" class="comfirm" target="iframepage">同意</a>
						</c:if>
						</h3>
					</div>
					<div class="infos">
					    QQ号码：${user.qq}<br>
						昵称：${user.username}<br> 
					 	性别：
						<c:if test="${user.sex==1}">男</c:if>
						<c:if test="${user.sex==0}">女</c:if>
						<br>  
						出生日期：${user.birthdayString}<br>
						<c:if test="${!empty user.hometown }">
							家乡住址：${user.hometown}<br>
						</c:if>
						<c:if test="${empty user.hometown }">
							家乡住址：未填写<br>
						</c:if>
						<c:if test="${!empty user.nowaddress }">
							现在住址：${user.nowaddress}<br>
						</c:if>
						<c:if test="${empty user.nowaddress }">
							现在住址：未填写<br>
						</c:if>
					 	婚姻状况：
						<c:if test="${user.ismarry==1}">是</c:if>
						<c:if test="${user.ismarry==0}">否</c:if>
						<c:if test="${user.ismarry==-1}">保密</c:if> 
						<br>  
						成为好友时间：
						<c:if test="${empty addfriendtimeString }">
							${addfriendtimeString }<br>
						</c:if>
				</div>
				<c:if test="${empty state }">
				<div class="inner">
					<div class="hd">
						<h3>登陆信息</h3>
					</div>
					<div class="infos">
					 	QQ状态：
						<c:if test="${user.state==1}">正常</c:if>
						<c:if test="${user.state==0}">冻结</c:if> 
						<br>  
						最近登录时间：${user.lastvisit}<br>
					</div>
				</div>
				</c:if>
				
	<script type="text/javascript" src="../js/jquery.js"></script>	
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		  $(function() {
			  $(".comfirm").linkbutton();
		  });
	</script>
	<script type="text/javascript">
		function operaconfirm(opera) {
			question = confirm("你确认要"+opera+"么");
			if (question != "0") {
				return true;
			}
			return false;
		}
	</script>
</body>
</html>
