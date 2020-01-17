<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center" style="color: red">
		<marquee style="font-family:Book Antiqua; color: #FFFFFF" bgcolor="#000080" scrollamount="30">${status}</marquee>
	</h2>


	<table align="center" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th colspan="2">OPTIONS</th>
		</tr>
		<c:forEach var="e" items="${emplist}">
			<tr>
				<td>${e.id}</td>
				<td>${e.name}</td>
				<td>${e.salary}</td>
				<td><a href='<spring:url value="/delete?id=${e.id}"/>'>delete</a>
				</td>
				<td><a href='<spring:url value="/update?id=${e.id}"/>'>update</a>
				</td>
			</tr>
		</c:forEach>
	</table>


	<div align="center">
		<a href="/add">Add Employee</a>
	</div>

</body>
</html>