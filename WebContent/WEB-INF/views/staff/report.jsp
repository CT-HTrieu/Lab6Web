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
			<th>Staff ID</th>
			<th>Achievements</th>
			<th>Disciplinary Actions</th>
			<th>Summary</th>
			<th></th>
		</tr>
	
		<c:forEach var="r" items="${reports }">
		<tr>
			<td>${r[0]}</td>
			<td>${r[1] }</td>
			<td>${r[2] }</td>
			<td>${r[1] * r[2] }</td>			
		</tr>
		</c:forEach>
	</table>
</body>
</html>