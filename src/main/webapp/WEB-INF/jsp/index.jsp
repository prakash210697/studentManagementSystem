<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b>STUDENT MANAGEMENT SYSTEM</b><br>
${msg}
<form action="./login" method="post">
enter username : <input type="text" name="uname"/><br>
enter password : <input type="password" name="pwd"/><br>
<input type="submit" value="login"/>
New user? <a href="./register">register</a>
</form>
</body>
</html>