<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>My JSP 'info.jsp' starting page</title>
<link href="../img/css.css" rel="stylesheet" />
</head>
<body>
	<div class="inner">
		<div class="hd">
			<h3>信息反馈</h3>
		</div>
		<div class="infos">
			<c:if test="${not empty askfor_suc }">
			  ${ askfor_suc}
			</c:if>
			<c:if test="${not empty askfor_fail }">
			 ${askfor_fail}
			</c:if>
			<c:if test="${not empty agree_suc }">
			   ${agree_suc }  
			</c:if>
			<c:if test="${not empty agree_fail }">
			   ${agree_fail } 
			</c:if>
			<c:if test="${not empty refuse_suc }">
			   ${refuse_suc }
			</c:if>
			<c:if test="${not empty refuse_fail }">
			   ${refuse_fail }
			</c:if>
			<c:if test="${not empty black_suc }">
			   ${ black_suc}
			</c:if>
			<c:if test="${not empty black_fail }">
			   ${black_fail }
			</c:if>
			<c:if test="${not empty delete_suc }">
			   ${delete_suc }
			</c:if>
			<c:if test="${not empty delete_fail }">
			   ${ delete_fail}
			</c:if>
			<c:if test="${not empty modify_fail }">
			   ${modify_fail }
			</c:if>
		</div>
	</div>
</body>
</html>
