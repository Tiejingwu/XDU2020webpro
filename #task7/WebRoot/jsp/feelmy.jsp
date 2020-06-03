<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <jsp:include page="header.jsp" /> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'info.jsp' starting page</title>
<link href="css/feel.css" rel="stylesheet" />
</head>
<body>
	<div class="layout-body">
		<div class="w960  clf">
			<div class="m_main">
               <jsp:include page="feelindex.jsp" />
			</div>
		</div>
	</div>
</body>
</html>
