<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>错误页面</title>
<style>
body {
  background-color: #ECECEC;
  font-family:Arial, Helvetica, sans-serif;
  font-size: 14px;
  color: #3c3c3c;
  padding-top:150px;
}

.page404 .f404{
  text-align: center;
  font-size: 150px;
  font-weight: bold;
  line-height: 100px;
  letter-spacing: 5px;
  color: #fff;
  margin-bottom:60px;
}

.page404 .f404 span {
  cursor: pointer;
  text-shadow: 0px 0px 2px #686868,
    0px 1px 1px #ddd,
    0px 2px 1px #d6d6d6,
    0px 3px 1px #ccc,
    0px 4px 1px #c5c5c5,
    0px 5px 1px #c1c1c1,
    0px 6px 1px #bbb,
    0px 7px 1px #777,
    0px 8px 3px rgba(100, 100, 100, 0.4),
    0px 9px 5px rgba(100, 100, 100, 0.1),
    0px 10px 7px rgba(100, 100, 100, 0.15),
    0px 11px 9px rgba(100, 100, 100, 0.2),
    0px 12px 11px rgba(100, 100, 100, 0.25),
    0px 13px 15px rgba(100, 100, 100, 0.3);
  -webkit-transition: all .1s linear;
  transition: all .1s linear;
}

.page404 .f404 span:hover {
  text-shadow: 0px 0px 2px #686868,
    0px 1px 1px #fff,
    0px 2px 1px #fff,
    0px 3px 1px #fff,
    0px 4px 1px #fff,
    0px 5px 1px #fff,
    0px 6px 1px #fff,
    0px 7px 1px #777,
    0px 8px 3px #fff,
    0px 9px 5px #fff,
    0px 10px 7px #fff,
    0px 11px 9px #fff,
    0px 12px 11px #fff,
    0px 13px 15px #fff;
  -webkit-transition: all .1s linear;
  transition: all .1s linear;
}

.page404 .f404-des{
  text-align: center;
  color: #666;
  font-family: cursive;
  font-size: 20px;
  text-shadow: 0 1px 0 #fff;
  letter-spacing: 1px;
  line-height: 2em;
}
</style>
</head>

<body>

  <div class="page404">
    <div class="f404"><span>4</span><span>0</span><span>4</span></div>
    <div class="f404-des">
    	该页面不存在(´･ω･`)<br/>
    </div>
  </div>
  <div style="background-color:#678;width:100%;height:5%;position:fixed;bottom:0;">
  <center><span>@CopyRight  By  小霍</span></center>
  </div>
</body>
</html>
