<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	<title>Register</title>
	</head>
	<body>
	<s:actionerror/>
	<s:form action="addlist" namespace="/sharemovie" method="post">
		<s:textfield label="listname" cssClass="input_list" name="listname" />
		<s:textfield label="descirption" cssClass="input_list" name="listDescription"></s:textfield>
		<s:submit value="commit" />
	</s:form>
	</body>
</html>