<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="employee" method="post">
		<table>

			<tr>
				<td>ID :</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" readonly="true" /></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>

				<td colspan="2"><form:button>update Employee</form:button></td>
			</tr>
		</table>

	</form:form>
</body>
</html>