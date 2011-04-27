<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.google.appengine.api.datastore.Key"%>
<%@ page import="javax.jdo.PersistenceManager"%>
<%@ page import="com.sysu.sharemovie.dao.*"%>
<%@ page import="com.sysu.sharemovie.jdo.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	<title>editlist</title>
	</head>
	<body>
	<s:actionerror/>
    <s:actionmessage/>
    <%
    Long listID = Long.valueOf(request.getParameter("listID"));
    PersistenceManager pm = PMF.get().getPersistenceManager();
    MovieList movielist = pm.getObjectById(MovieList.class, listID);
    pm.close();
    String name=movielist.getListname();
    String desc=movielist.getListDescription();
    request.setAttribute("listID",listID);
    request.setAttribute("name",name);
    request.setAttribute("desc",desc);
    %>
    lsitid:<%=listID %>
	用户名：<s:property value="#session.username"/>
	<s:form action="addlist" namespace="/sharemovie" method="post">
		<s:textfield label="listname" cssClass="input_list" name="listname" value="%{#request.name}"/>
		<s:textfield label="descirption" cssClass="input_list" name="listDescription" value="%{#request.desc}"/>
		<input type="hidden" name="listID" value="${request.listID}" />
		<s:submit value="commit" />
	</s:form>
	<a href="home.jsp"><button>cancle</button></a>
	</body>
</html>