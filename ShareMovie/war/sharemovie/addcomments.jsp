<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.google.appengine.api.datastore.Key"%>
<%@ page import="javax.jdo.PersistenceManager"%>
<%@ page import="com.sysu.sharemovie.dao.*"%>
<%@ page import="com.sysu.sharemovie.jdo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加评论</title>
</head>
<body>
    <%
      Date date = new Date();
      request.setAttribute("date", date);
      Long listID = Long.valueOf(request.getParameter("listID"));
      request.setAttribute("listID",listID);
      PersistenceManager pm = PMF.get().getPersistenceManager();
      MovieList movielist = pm.getObjectById(MovieList.class, listID);
      pm.close();
    %>
    <p><b><%=movielist.getListname() %>的留言</b></p>
    <%
     Iterator<Key> iter;
     iter = movielist.getMovieComment().iterator();
     if (iter.hasNext()) {
    	 PersistenceManager pm1 = PMF.get().getPersistenceManager();
    	 while (iter.hasNext()) {
    		 Comment listcomments = pm1.getObjectById(Comment.class, iter.next());
    %>
    <p><b><%=listcomments.getAuthorname() %>于<%=listcomments.getDate().toLocaleString() %>评论说：</b></p>
    <p><%=listcomments.getContent() %></p>
    <a href="deletecomment.action?commentID=<%=listcomments.getKey().getId() %>&listID=<%=listID %>">删除</a>
    <%
    	 }
     }else{
    %>
                   现在还没有评论，赶快抢沙发吧！
    <%
     }
    %>
    <s:form action="addcomment" namespace="/sharemovie" method="post">
       <s:textarea name="content" rows="3" cols="60"></s:textarea>
       <input type="hidden" name="listID" value="${request.listID}" />
       <!-- <input type="hidden" name="date" value="${request.date}"></input> -->
       <s:submit value="发表"></s:submit>
    </s:form>
    <br></br>
    <br></br>
    <br></br>
    <a href="movielist.jsp?listID=<%=listID %>">返回列表</a>
</body>
</html>