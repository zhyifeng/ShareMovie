<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	<title>Login</title>
	</head>
	<body>
	<center>
	   <div style="margin-top:40px; margin-left:20px; font-size:20px; height:50px">
	   <h1>欢迎登录ShareMovie</h1>
	   </div>
	   <s:actionmessage/>
	        如果你还没有注册，单击此处<a href="register.jsp">注册</a>  
	   <FONT color="red"><s:actionerror/></FONT>
	   <s:form action="loginact" namespace="/" method="post" validate="true">
		<s:textfield label="用户名" cssClass="input_list" name="username" />
		<s:password label="密码" cssClass="input_list" name="password" />
		<s:submit value="login" />
	</s:form>
	</center>
	</body>
</html>