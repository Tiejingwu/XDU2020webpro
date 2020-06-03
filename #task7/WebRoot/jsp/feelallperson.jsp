<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="header.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'info.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/feel.css" rel="stylesheet" />
</head>

<body>
	<div class="layout-body">
		<div class="w960  clf">
			<div class="m_left">
				<div class="inner pd1">
					<ul class="stats-list clf">
						<li class="first"><strong>${totalfriends}</strong><span>好友</span></li>
						<li><strong>${totalmessages}</strong><span>留言</span></li>
						<li><strong>${totalfeels }</strong><span>说说</span></li>
					</ul>
				</div>
				<div class="inner mt12 p0">
					<div class="hd">
						<h3>最近访客</h3>
					</div>
					<div class="bd">
						<ul class="avatar-list clf">
							<li><a href="#" target="_blank"><img
									src="img/head_snew.jpg" alt="十二的头像" />
									<div class="a-name">十二</div> </a></li>
							<li><a href="#" target="_blank"><img
									src="img/head_snew.jpg" alt="十二的头像" />
									<div class="a-name">十二</div> </a></li>
							<li><a href="#" target="_blank"><img
									src="img/head_snew.jpg" alt="十二的头像" />
									<div class="a-name">十二</div> </a></li>
							<li><a href="#" target="_blank"><img
									src="img/head_snew.jpg" alt="十二的头像" />
									<div class="a-name">十二</div> </a></li>
							<li><a href="#" target="_blank"><img
									src="img/head_snew.jpg" alt="十二的头像" />
									<div class="a-name">十二</div> </a></li>
							<li><a href="#" target="_blank"><img
									src="img/head_snew.jpg" alt="十二的头像" />
									<div class="a-name">十二</div> </a></li>
							<li><a href="#" target="_blank"><img
									src="img/head_snew.jpg" alt="十二的头像" />
									<div class="a-name">十二</div> </a></li>
							<li><a href="#" target="_blank"><img
									src="img/head_snew.jpg" alt="十二的头像" />
									<div class="a-name">十二</div> </a></li>
							<li><a href="#" target="_blank"><img
									src="img/head_snew.jpg" alt="十二的头像" />
									<div class="a-name">十二</div> </a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="m_main">
				<jsp:include page="feelindex.jsp" />
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../js/iframe.js"></script>
</body>
</html>
