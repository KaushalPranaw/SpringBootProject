<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="customer"> 

	<table>
		<tr>
			<td>ID : </td>
			<td><form:input path="id"/></td>
		</tr>
		<tr>
			<td>Name : </td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Email : </td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td>Password : </td>
			<td><form:input path="password"/></td>
		</tr>
		<tr>
			<td>Salary : </td>
			<td><form:input path="salary"/></td>
		</tr>
		<tr>
			<td>Address : </td>
			<td><form:input path="address"/></td>
		</tr>
		<tr>
			<td>Date : </td>
			<td><form:input path="date" type="date"/></td>
		</tr>
		<tr>
			 
			<td colspan="2"><input type="submit" value="update"/></td>
		</tr>
	</table>
</form:form>
</body>
</html>