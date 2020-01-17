<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h2 align="center">${requestScope.status}</h2>
<body>

	<form method="post">
		<table>
			<tr>
				<td>Email : </td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				 
				<td><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>