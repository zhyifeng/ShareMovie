<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	<title>Register</title>
	</head>
	<body>
	<s:actionerror/>
	<s:form action="registeract" namespace="/sharemovie" method="post">
		<s:textfield label="username" cssClass="input_list" name="username" />
		<s:password label="password" cssClass="input_list" name="password" />
		<s:password label="repassword" cssClass="input_list" name="repassword" />
		<s:submit value="register" />
	</s:form> 
	</body>
</html>