<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	<title>Register</title>
	</head>
	<body>
	<s:actionerror/>
	用户名：<s:property value="#session.username"/>
	<s:form action="addlist" namespace="/sharemovie" method="post">
		<s:textfield label="listname" cssClass="input_list" name="listname" />
		<s:textfield label="descirption" cssClass="input_list" name="listDescription"></s:textfield>
		<s:submit value="commit" />
	</s:form>
	<a href="home.jsp"><button>cancle</button></a>
	</body>
</html>