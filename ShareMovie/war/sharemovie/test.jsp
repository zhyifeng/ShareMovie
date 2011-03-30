<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.sysu.sharemovie.dao.PMF" %>
<%@ page import="com.sysu.sharemovie.jdo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%
     PersistenceManager pm = PMF.get().getPersistenceManager();
     //String query = "select from "+SMUser.class.getName();
     String query = "select from "+MovieList.class.getName();
     List<MovieList> movielist = (List<MovieList>)pm.newQuery(query).execute();
     if (movielist.isEmpty()){
     %>
     <p>  No MovielistHere.</p>
     <%
       }else{
    	   for (MovieList m : movielist){
    		   if (m.getListname() == null){
     %>
     <p> No UsernameHere </p>
     <%
    		   }else{
    			   //session.setAttribute("movielistkey",m.getKey());
     %>
     <div>
         <b><a href="test2.jsp?movielistkey=<%=m.getKey().getId()%>"><%=m.getListname() %></a></b><br>
     </div>
     
     <%
    		   }
    	   }
       }
     pm.close();
     %>
</body>
</html>