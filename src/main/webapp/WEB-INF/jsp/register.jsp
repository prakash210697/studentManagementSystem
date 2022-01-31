<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save" method="post">
enter student id: <form:input path="studentid"/><br>
enter student password:<form:input path="studentpassword"/><br>
enter student name :<form:input path="studentname"/></br>
enter student age : <form:input path="studentage"/><br/>
enter student address : <form:textarea path="studentaddress"></form:textarea><br/>
enter student mobile number:<form:input path="studentmobileno"/><br/>
<input type="submit" value="register">
</form:form>

</body>
</html>