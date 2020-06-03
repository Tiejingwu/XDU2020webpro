<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>说说</title>
<link href="../css/feelother.css" rel="stylesheet" />
</head>
<body>
	<div id="qq">
			<p><center><font style="font-size:20px">ta的说说</font></center></p>
	</div>

 	<div class="msgCon">
		<c:set var="feels" value="${allfeels.getList()}" />
		<c:set var="pager" value="${allfeels }" />
		<c:if test="${!empty feels }">
			<c:forEach items="${feels}" var="feel" varStatus="status">
				<div class='msgBox'>
					<dl>
						<dt>
							<img src="../headpic/${feel.user.headpic }"
								alt="${feel.user.username }" height="50" width="50">
						</dt>
						<dd>
							${feel.user.username } <span style="font-size: 7px;">${feel.feel.timestring }</span>
							<c:if test="${host.userid==feel.user.userid }">
								<a
									href="<%=path %>/user/deleteFeel?feelid=${feel.feel.feelid}&userid=${feel.user.userid }&currentPage=${pager.pageNum }">
									<span style="font-size: 7px;" onclick="return deletecomfirm();">删除</span>
								</a>
							</c:if>
						</dd>
					</dl>
					<div class='msgTxt'>
						${feel.feel.feelcontent }<br>
						<c:if test="${!empty feel.feel.pic}">
							<img src="../img/${feel.feel.pic }" height="50" width="70">
						</c:if>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div> 
	<div class="comm_content">
		<div class="c_list clf">
			<div id="pl_page">
				<div class="pagelistbox">
					<p>
						<span> <c:if test="${pager.isFirstPage==false}">
								<a
									href="<%=path%>/user/${view }?userid=${feel.user.userid }&currentPage=1">首页</a>
							</c:if> <c:if test="${pager.hasPreviousPage==true}">
								<a
									href="<%=path%>/user/${view }?userid=${feel.user.userid }&currentPage=${pager.pageNum-1}">上一页</a>
							</c:if> <c:if test="${pager.hasNextPage==true}">
								<a
									href="<%=path%>/user/${view }?userid=${feel.user.userid }&currentPage=${pager.pageNum+1}">下一页</a>
							</c:if> <c:if test="${pager.isLastPage ==false}">
								<a
									href="<%=path%>/user/${view }?userid=${feel.user.userid }&currentPage=${pager.pages}">尾页</a>
							</c:if> 当前第 ${pager.pageNum}页, 总共${pager.pages} 页
						</span>
					</p>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript">
		function deleteconfirm() {
			question = confirm("你确认要删除么");
			if (question != "0") {
				return true;
			}
			return false;
		}
	</script>
</body>
</html>
