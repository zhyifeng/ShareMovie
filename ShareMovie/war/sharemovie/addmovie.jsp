<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.google.appengine.api.datastore.Key"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加电影</title>
</head>
<body>
    <s:actionerror/>
    <s:actionmessage/>
    <s:property value="#session.username"/>
    <s:property value="#session.userkey"/> 
    <%
    Long listID = Long.valueOf(request.getParameter("parentID"));
    request.setAttribute("listID",listID);
    %>
    lsitid:<%=listID %>
          用户名：<s:property value="#session.username"/>
	<s:form action="addmovie" namespace="/sharemovie" method="post">
		<s:textfield label="moviename" cssClass="input_list" name="moviename" />
		<s:textfield label="descirption" cssClass="input_list" name="movieDescription"></s:textfield>
		<s:hidden name="listID" value=""/>
		<s:submit value="commit" />
	</s:form>
	<a href="home.jsp"><button>complete</button></a>
</body>
</html>