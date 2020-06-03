<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'info.jsp' starting page</title>
<link href="../img/css.css" rel="stylesheet"/>
<style type="text/css">
.file {
    position: relative;
    display: inline-block;
    background: #D0EEFF;
    border: 1px solid #99D3F5;
    border-radius: 4px;
    padding: 4px 12px;
    overflow: hidden;
    color: #1E88C7;
    text-decoration: none;
    text-indent: 0;
    line-height: 20px;
}
.file input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
}
.file:hover {
    background: #AADFFD;
    border-color: #78C3F3;
    color: #004974;
    text-decoration: none;
}
</style>
</head>
<body>
	<div class="inner">
		<div class="hd">
			<center><h3>修改头像</h3></center>
		</div>
		<div class="infos">
		<div id="localImag"><center><img src="../headpic/${host.headpic}" width="80" height="80" name="pic"/></center></div>  
			<br><br>
			<center>
			 <form action="<%=path%>/user/updateheadpic" method="post" enctype="multipart/form-data" target="header">
                <input type="file" name="file" class="file" accept="image/png,image/gif,image/jpg,image/jpeg"   onchange="preview(this)" />  
                <input type="submit" value="上传" >
             </form>
             图像预览：<div id="preview"></div>  
			</center>
		</div>
	</div>
	 <script type="text/javascript">     /* 图片预览 */
	 function preview(file)  
	 {  
	 var prevDiv = document.getElementById('preview');  
		 if (file.files && file.files[0])  
		 {  
		 var reader = new FileReader();  
		 reader.onload = function(evt){  
		 prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';  
		}    
	 reader.readAsDataURL(file.files[0]);  
	}  
	 else    
	 {  
	 prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  
	 }  
	 }  
	 </script>  
</body>
</html>
