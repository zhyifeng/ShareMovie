<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>删除电影</title>
</head>
<body>
    <%
    Long movieID = Long.valueOf(request.getParameter("movieID"));
    request.setAttribute("movieID",movieID);
    Long listID = Long.valueOf(request.getParameter("parentID"));
    request.setAttribute("listID",listID);
    %>
    <s:action name="deletemovie" namespace="/sharemovie">
        <input type="hidden" name="movieID" value="${request.movieID}" />
        <input type="hidden" name="listID" value="${request.listID}" />
    </s:action>
</body>
</html>