<%@ page language="java" import="com.src.model.Student" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>
<table border="2" bgcolor="lime">
<tr>
	<th>student Id</th>
	<th>student name</th>
	<th>student address</th>
	<th>student age</th>
	<th>student mobile no</th>
	<th><a href="../index.jsp">Logout</a></th>
</tr>
<c:set var="stds" value="${students}">
</c:set>
<c:forEach items="${stds}" var="std">
<c:forEach var="s" items="${std }" >
<tr>
	<td>${s.studentid}</td>
	<td>${s.studentname}</td>
	<td>${s.studentaddress}</td>
	<td>${s.studentage}</td>
	<td>${s.studentmobileno}</td>
	<td><a href="delete/${s.studentid}">Del</a></td>
	<td><a href="edit/${s.studentid}">Edit</a></td>
</tr>
</c:forEach>
</c:forEach>
</table>

</body>
</html>