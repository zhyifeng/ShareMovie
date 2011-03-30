<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.google.appengine.api.datastore.*" %>
<%@ page import="javax.jdo.PersistenceManager"%>
<%@ page import="com.sysu.sharemovie.dao.*"%>
<%@ page import="com.sysu.sharemovie.jdo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%
        String movielistkey = request.getParameter("movielistkey");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        MovieList movielist = pm.getObjectById(MovieList.class, Long.valueOf(movielistkey));
     %>
             电影列表名：<p><b><%=movielist.getListname() %></b></p>
             列表描述：<p><%=movielist.getListDescription() %></p>
</body>
</html>