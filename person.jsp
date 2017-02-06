<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Details</title>
</head>
<body>
	<h2>Add Person Details</h2>
	<form action="addPerson" method="post">
		<table>
			<c:if test="${!empty person.getPersonName()}">
				<tr>
					<td><input type="hidden" name="personId" id = "personId" value=""/></td>
				</tr>
			</c:if>
			<tr>
				<td>Name</td>
				<td><input type="text" name="personName" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" name="country" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${!empty person.getPersonName()}">
						<input type="submit" value="Edit Person" />
					</c:if>
					<c:if test="${empty person.getPersonName()}">
						<input type="submit" value="Add Person" />
					</c:if>
				</td>
			</tr>
		</table>
	</form>
	<br />
	<h3>Persons List</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Country</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty listPerson}">
				<c:forEach items="${listPerson}" var="person">
					<tr>
						<td>${person.getPersonId()}</td>
						<td>${person.getPersonName()}</td>
						<td>${person.getCountry()}</td>
						<td><a href="<c:url value='/editPerson/${person.getPersonId()}' />" >Edit</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>