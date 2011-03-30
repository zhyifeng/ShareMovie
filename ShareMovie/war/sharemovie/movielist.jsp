<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.google.appengine.api.datastore.Key"%>
<%@ page import="javax.jdo.PersistenceManager"%>
<%@ page import="com.sysu.sharemovie.dao.*"%>
<%@ page import="com.sysu.sharemovie.jdo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="java.util.Iterator"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>movielist</title>
</head>
<body>
     <%
     Long listID = (Long)request.getAttribute("listID");
     PersistenceManager pm = PMF.get().getPersistenceManager();
     MovieList movielist = pm.getObjectById(MovieList.class, listID);
     pm.close();
     %>
             电影列表名：<p><b><%=movielist.getListname() %></b></p>
             列表描述：<p><%=movielist.getListDescription() %></p>
     <a href="addmovie.jsp?parentID=<%=movielist.getKey().getId()%>" target="_blank">添加电影</a>
     <%
     Iterator<Key> iter;
     iter = movielist.getMovieInList().iterator();
     if (iter.hasNext()) {
    	 PersistenceManager pm1 = PMF.get().getPersistenceManager();
    	 while (iter.hasNext()) {
    		 Movie movie = pm1.getObjectById(Movie.class, iter.next());
    %>
    		name: <p><b><%=movie.getMoviename() %>></b></p>
    		 description:<p><%=movie.getMovieDescription() %>></p>
     <%
    	 }
     }else{
     %>
        There is no movie in list now;
     <%
     }
     %>
</body>
</html>