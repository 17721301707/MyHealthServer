<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Index Page</title>
</head>

<body>
	UserCheck 2016/01/20:
	<form action="<%=request.getContextPath()%>/user/test" method="post" id="test">
		Phone: <input type="text" name="phone"><br> 
		<input type="submit" value="Submit">
	</form>
</body>
</html>
