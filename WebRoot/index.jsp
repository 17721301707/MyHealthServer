<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
</head>

<body>
	UserCheck:
	<form action="<%=request.getContextPath()%>/user/login" method="post" id="login">
		Phone: <input type="text" name="phone"><br> 
		<input type="submit" value="Submit">
	</form>
</body>
</html>
