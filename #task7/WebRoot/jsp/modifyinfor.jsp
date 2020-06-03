<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>注册-个人用户</title>
<link type="text/css" rel="stylesheet" href="../css/login.css" />
<link type="text/css" rel="stylesheet" href="../css/regist.personal.css" />
<link type="text/css" rel="stylesheet" href="../css/passport.base.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<link href="../css/easyui.css" rel="stylesheet"/>
<link href="../css/icon.css" rel="stylesheet"/>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<style type="text/css">
.form-actions .submit{
 width: 20%;
 height:50%;
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
	<div class="easyui-tabs" style="width:850px;height:600px;">
		<div title="修改密码"  style="padding:10px;" >
			<div class="w" id="regist" style="width:830px;">
				<div class="mc">
					<form method="post"  action="<%=request.getContextPath()%>/user/modifyPass" class="form-actions" target="_bank" onsubmit="return CheckForm();">
						<div class="form">
					        <div class="item">
								<span class="label"><b class="ftx04">*</b>昵称：</span>
								<div class="fl item-ifo">
									<input type="text" name="username" value="${host.username }" class="text"
											required="required" />
								</div>
								</div>
			                <div class="item">
								<span class="label"><b class="ftx04">*</b>原始密码：</span>
								<div class="fl item-ifo">
									<input type="password" name="oldpassword" class="text" required="required" />
									<c:if test="${not empty modifypass_fail }">
						 			  <font style="color:red;"> ${ modifypass_fail }</font>
								    </c:if>
							   </div>
							</div>
							   
							 <div class="item">
								<span class="label"><b class="ftx04">*</b>请设置新密码：</span>
								<div class="fl item-ifo">
									<input type="password" name="password" id="password" class="text" required="required" />
								</div>
							</div>
			
							<div class="item">
								<span class="label"><b class="ftx04">*</b>请确认新密码：</span>
								<div class="fl item-ifo">
									<input type="password" name="repassword" id="repassword"  class="text" required="required" />
								    <span class="back"></span>
								</div>
					       </div>
							<div class="item" >
								<div class="fl item-ifo">
									 <input type="submit" value="修改" class="submit"/>
								</div>
							</div>			
						</div>
					</form>
					<div class="item">
							<div class="fl item-ifo" style="width:400px;">
								<c:if test="${not empty modify_fail }">
						 			 <font style="color:red;"> ${ modify_fail }</font>
								</c:if>
							</div>
						</div>
				</div>
			</div> 
		</div>
		<div title="修改基本信息" style="padding:10px;">
				 <div class="w" id="regist" style="width:830px;">
					<div class="mc">
						<form method="post"  class="form-actions"
							action="<%=request.getContextPath()%>/user/modifyInfor" target="iframepage">
							<div class="form">
								<div class="item">
									<span class="label"><b class="ftx04">*</b>昵称：</span>
									<div class="fl item-ifo">
										<input type="text" name="username" value="${host.username }" class="text"
											required="required" />
									</div>
								</div>
			
								<div class="item">
									<span class="label"><b class="ftx04">*</b>性别：${host.sex}</span>
									<div class="fl item-ifo">
										<label for="boy">男</label> 
										<input type="radio" id="boy" name="sex" value="1" <c:if test="${host.sex==1}"> checked="checked" </c:if>  required="required" /> 
										<label for="girl">女</label> 
										<input type="radio" id="girl" name="sex" value="0" <c:if test="${host.sex==0}"> checked="checked" </c:if> required="required" />
									</div>
								</div>
			
								<div class="item">
									<span class="label"><b class="ftx04"></b>婚姻状况：</span>
									<div class="fl item-ifo">
										<label for="no">否</label> 
										<input type="radio" id="no" value="0" name="ismarry" <c:if test="${host.ismarry==0}"> checked="checked" </c:if>/>
										<label for="yes">是</label> 
										<input type="radio" id="yes" value="1" name="ismarry" <c:if test="${host.ismarry==1}"> checked="checked" </c:if>/> 
										<label for="secrecy">保密</label> 
										<input type="radio" id="secrecy" value="-1" name="ismarry" <c:if test="${host.ismarry==-1}"> checked="checked" </c:if>/>
									</div>
								</div>  
			
								<div class="item">
									<span class="label"><b class="ftx04"></b>出生日期：</span>
									<div class="fl item-ifo">
										<input type="date" name="birthday"   value="${host.birthdayString }" class="text" />
									</div>
								</div>
							 	<div class="item">
									<span class="label"><b class="ftx04"></b>家乡：</span>
									<div class="fl item-ifo">
										<input type="text" name="hometown"  value="${host.hometown }" class="text" />
									</div>
								</div>
								<div class="item">
									<span class="label"><b class="ftx04"></b>现在住址：</span>
									<div class="fl item-ifo">
										<input type="text" name="nowaddress" value="${host.nowaddress }"   class="text" />
									</div>
								</div> 
								<div class="item" >
									<div class="fl item-ifo">
										 <input type="submit"  value="修改" class="submit" onclick="return operaconfirm('修改');"/>
									</div>
								</div>
							</div>
						</form>
						<div class="item">
							<div class="fl item-ifo" style="width:400px;">
								<c:if test="${not empty modify_fail }">
						 			 <font style="color:red;"> ${ modify_fail }</font>
								</c:if>
							</div>
						</div>
					  </div>
				</div> 
		</div>
	</div>
		<script type="text/javascript">
		function CheckForm() {
			if ($("#password").val() != $("#repassword").val()) { 
			   alert("您两次输入的密码不一样！请重新输入."); 
			   $("#repassword").focus(); 
			   return false; 
			} 
			   return true; 
		} 
		
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
