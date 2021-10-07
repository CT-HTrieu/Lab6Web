<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath }/">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${message }
	<table class="table table-hover">
		<tr>
			<th>Username</th>
			<th>Password</th>
			<th>Fullname</th>
			<th></th>
		</tr>
	
		<c:forEach var="u" items="${users}">
		<tr>
			<td>${u.username }</td>
			<td>${u.password }</td>
			<td>${u.fullname }</td>
			<td><a href="user/delete/${u.username }.htm?linkDelete">Delete</a></td>	
			<td><a href="user/update/${u.username }.htm?linkEdit">Update</a></td>			
		</tr>
		</c:forEach>
	</table>
</body>
</html>