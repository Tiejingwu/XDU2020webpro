<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'showfriends.jsp' starting page</title>
<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
}

#left {
	background: url("images/menu_bg.jpg") repeat-y scroll left top #FFFFFF;
	width: 290px;
	height: 600px;
	text-align: left;
	float: left;
}

#slideMenu {
	height: 93%;
	overflow: auto;
}

#menu {
	height: 100%;
	margin-left: 0px;
	font-family: Arial, Helvetica, sans-serif;
}

#menu li {
	line-height: 10px;
	margin: 0px;
	padding: 0px;
	list-style-type: none;
	border-bottom: 1px solid #B5CADF;
}

#menu li a {
	display: block;
	padding: 10px 20px 10px 0.5em;
	font-size: 12px;
	font-weight: bold;
	letter-spacing: 2px;
	padding-left: 35px;
	text-align: left;
	text-decoration: none;
}

#menu li a:link,#menu li a:visited {
	background-color: #EAF1FB;
	color: #003366;
}

#menu li a:hover {
	background-color: #8AB1EC;
	color: #ffffff;
}

#menu ul li {
	line-height: 10px;
	margin: 0px;
	padding: 0px;
	list-style-type: none;
	border-bottom: 1px dashed #B5CADF;
}

#menu ul li a:link,#menu ul li a:visited {
	background-color: white;
	color: black;
}

#menu ul li a:hover {
	background-color: gray;
	color: white;
}
</style>
</head>
<body>
	<div class="layout-body">
		<div class="w960  clf">
			<div class="m_left">
				<div class="inner mt12 p0">
					<div id="left">
						<div id="slideMenu">
							<div id="menuWrap" class="menuWrap" style="height: 140px;">
								<ul id="menu">
									<li id="li2"><a href="javascript:void(0);"
										onclick="expand(1)"> 我的好友</a></li>
									<ul id="child1" style="DISPLAY: none">
										<c:if test="${!empty  allfriendlist}">
											<c:forEach items="${allfriendlist}" var="friend" varStatus="s">
												<li>
												<a href="<%=path%>/user/showinfor?friendid=${friend.userid}" target="iframepage"><img
														src="headpic/${friend.headpic }" width="25" height="25" />${friend.username}</a>
												</li>
											</c:forEach>
										</c:if>
									</ul>
									<li id="li1"><a href="javascript:void(0);"
										onclick="expand(2)" target="transformShows">黑名单</a></li>
									<ul id="child2" style="DISPLAY: none">
										<c:if test="${!empty  blackList}">
											<c:forEach items="${blackList}" var="deletefriend"
												varStatus="s">
												<li>
											 <a href="<%=path%>/user/showinfor?friendid=${deletefriend.userid}" target="iframepage">
												<img src="headpic/${deletefriend.headpic }" width="25"
														height="25" />${deletefriend.username}</a>
												</li>
											</c:forEach>
										</c:if>
									</ul>
									<li id="li1"><a href="javascript:void(0);"
										onclick="expand(3)" target="transformShows">待确认</a></li>
									<ul id="child3" style="DISPLAY: none">
										<c:if test="${!empty  waitList}">
											<c:forEach items="${waitList}" var="waitfriend"
												varStatus="s">
												<li>
												 <a href="<%=path%>/user/showinfor?friendid=${waitfriend.userid}" target="iframepage">
												<img src="headpic/${waitfriend.headpic }" width="25" height="25" />${waitfriend.username}</a>
												</li>
											</c:forEach>
										</c:if>
									</ul>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="m_main">
				<iframe frameborder=0 width=840 id="iframepage" name="iframepage"
					onLoad="iFrameHeight()" 
					src="<%=request.getContextPath()%>/jsp/askforfriend.jsp"></iframe>
			</div>
		</div>
	</div>

	<SCRIPT language=javascript>
		function expand(el) {
			childObj = document.getElementById("child" + el);

			if (childObj.style.display == 'none') {
				childObj.style.display = 'block';
			} else {
				childObj.style.display = 'none';
			}
			return;
		}
	</SCRIPT>
	<a style="opacity: 0;" id="topcontrol" href="javascript:;" title="返回顶部"></a>
</body>
</html>

