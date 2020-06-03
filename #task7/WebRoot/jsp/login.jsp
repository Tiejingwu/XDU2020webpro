<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>空间登录</title>
<link type="text/css" rel="stylesheet" href="../css/login.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<style type="text/css">
.form-actions .submit{
 cursor: pointer; 
 background: rgb(61, 157, 179);
 padding: 8px 5px;
 font-family: 'BebasNeueRegular','Arial Narrow',Arial,sans-serif;
 color: #fff;
 font-size: 20px; 
 margin: 5px;
 border: 1px solid rgb(28, 108, 122); 
 margin-bottom: 10px; 
 text-shadow: 0 1px 1px rgba(0, 0, 0, 0.5);
 border-radius: 3px; 
 box-shadow:0px 1px 6px 4px rgba(0, 0, 0, 0.07) inset,
 0px 0px 0px 3px rgb(254, 254, 254),
 0px 5px 3px 3px rgb(210, 210, 210);
 -webkit-transition: all 0.2s linear;
 transition: all 0.2s linear;
 }
 .form-actions .submit:hover{
 background: rgb(74, 179, 198);
 }
 .form-actions .submit:active,
 .form-actions .submit:focus{
 background: rgb(40, 137, 154);
 position: relative;
 top: 1px;
 border: 1px solid rgb(12, 76, 87); 
 box-shadow: 0px 1px 6px 4px rgba(0, 0, 0, 0.2) inset;
 }
</style>
</head>
<body>
	<div class="w">
		<div id="logo">
			<b></b>
		</div>
	</div>
	<form method="post" action="<%=request.getContextPath() %>/user/loginvalid" class="form-actions">
		<div class=" w1" id="entry">
			<div class="mc " id="bgDiv">
			<div id="logo">
			 <img src="../img/logo.jpg" alt="空间" width="470" height="360" />
	    	</div>
				<div class="form ">
					<div class="item fore1">
						<span>用户名</span>
						<div class="item-ifo">
							<input type="text" name="qq"  class="text"  required="required"/>
							<div class="i-name ico"></div>
							<label id="qq_error" class="hide"><b></b></label>
						</div>
					</div>

					<div class="item fore2">
						<span>密码</span>
						<div class="item-ifo">
							<input type="password"  name="password" class="text" required="required" />
							<div class="i-pass ico"></div>
							<label id="loginpwd_error" class="hide"></label>
						</div>
					</div>
						<input type="submit" value="登陆" class="submit"/>
						<input type="reset" class="submit"/> 
					<pre>       ${login_fail}
					</pre>
				</div>
			</div>
			<div class="free-regist">
				<span><a href="<%=request.getContextPath()%>/user/register" >免费注册&gt;&gt;</a></span>
			</div>
		</div>
	</form>

</body>
</html>
