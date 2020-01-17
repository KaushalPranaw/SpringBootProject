<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
	<table align="center" border="1">
		<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Address</th>
				<th>Date</th>
				<th>Salary</th>
				<th>Update</th>
				<th>Delete</th>
				
			</tr>
		<c:forEach var="c" items="${requestScope.allUser}">
			<tr>
				<td>${c.name}</td>
				<td>${c.email}</td>
				<td>${c.password}</td>
				<td>${c.address}</td>
				<td>${c.date}</td>
				<td>${c.salary}</td>
				<td><a href='<spring:url value="/cust/update?cid=${c.id}"/>'>update</a></td>
				<td><a href='<spring:url value="/cust/delete?cid=${c.id}"/>'>delete</a></td>
			</tr>
		</c:forEach>
	</table>
	 
</body>
</html>