<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	<title>Register</title>
	</head>
	<body>
	  <center>
	      <div style="margin-top:40px; margin-left:20px; font-size:20px; height:50px">
	      <h1>欢迎加入ShareMovie</h1> 
	      </div>
	               已经拥有sharemovie帐号?<a href="login.jsp">直接登录</a>  
	      <FONT color="red"><s:actionerror/></FONT>
	      <s:form action="registeract" namespace="/sharemovie" method="post">
		  <s:textfield label="用户名" cssClass="input_list" name="username" />
		  <s:password label="密码" cssClass="input_list" name="password" />
		  <s:password label="重复密码" cssClass="input_list" name="repassword" />
		  <s:textfield label="邮箱" cssClass="input_list" name="email"></s:textfield>
		  <s:submit value="注册" />
	      </s:form> 
	  </center>	    
	</body>
</html>