<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>My JSP 'info.jsp' starting page</title>
<link href="../img/css.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="../css/search.css" />
</head>
<body>
 	<div class="inner">
		<div class="hd">
			<h3>添加好友</h3>
		</div>
		<div class="infos">
			<form method="post" action="<%=path%>/user/findFriend">
				<div id="entry">
					<div class="form ">
						<label for="qq"></label>
						<div class="item-ifo">
							<input type="text" name="selectcontent" id="selectcontent"
								class="text" placeholder="输入查询内容" autofocus="autofocus"
								autocomplete="off" required="required" />
							<div class="i-name ico"></div>
							<select name="selectmethod" id="selecte" class="shortselect">
								<option value="qq" selected="selected">QQ查询</option>
								<option value="username">昵称查询</option>
							</select>
						    <input type="submit" value="查询">
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="infos">
			<div class="right">  
			    <c:set var="users" value="${friendresult.getList()}" />
				<c:set var="pager" value="${friendresult }" />
				<c:if test="${!empty users }">
					<c:forEach items="${users}" var="user" varStatus="status">
						<div class="qquser">
							<img src="../headpic/${user.headpic}" width="80" height="80"/> <br>昵称：${user.username} <br>QQ：${user.qq}
							<form action="<%=path %>/user/askforFriend" method="post" >
								<input type="hidden" name="friendid" value="${user.userid }"> 
								<input type="submit" value="添加">
							</form>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<div class="comm_content">
			<div class="c_list clf">
				<div id="pl_page">
					<div class="pagelistbox">
						<p>
						<c:if test="${!empty users }">
							<span> <c:if test="${pager.isFirstPage==false}">
									<a
										href="<%=path%>/user/findFriend?userid=${user.userid }&currentPage=1">首页</a>
								</c:if> <c:if test="${pager.hasPreviousPage==true}">
									<a
										href="<%=path%>/user/$findFriend?userid=${user.userid }&currentPage=${pager.pageNum-1}">上一页</a>
								</c:if> <c:if test="${pager.hasNextPage==true}">
									<a
										href="<%=path%>/user/findFriend?userid=${user.userid }&currentPage=${pager.pageNum+1}">下一页</a>
								</c:if> <c:if test="${pager.isLastPage ==false}">
									<a
										href="<%=path%>/user/$findFriend?userid=${user.userid }&currentPage=${pager.pages}">尾页</a>
								</c:if> 当前第 ${pager.pageNum}页, 总共${pager.pages} 页
							</span>
						</c:if>
						<c:if test="${not resultisnull }">
						 <b style="font-size: 20px;">${resultisnull}</b>
						</c:if>
						<c:if test="${not empty askfor_suc }">
							 <b style="font-size: 20px;">${askfor_suc}</b>
						</c:if>
						<c:if test="${not empty askfor_fail }">
							 <b style="font-size: 20px;">${askfor_fail}</b>
						</c:if>
						</p>
					</div>
				</div>
 			</div> 
		</div>
	</div> 
	
</body>
</html>
