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
			<th>ID</th>
			<th>Type</th>
			<th>Reason</th>
			<th>Date</th>
			<th>Staff ID</th>
			<th></th>
		</tr>
	
		<c:forEach var="r" items="${records }">
		<tr>
			<td>${r.ID }</td>
			<td>${r.type }</td>
			<td>${r.reason }</td>
			<td>${r.date }</td>
			<td>${r.staff.ID }</td>
			<td><a href="record/delete/${r.ID }.htm?linkDelete">Delete</a></td>	
			<td><a href="record/update/${r.ID }.htm?linkEdit">Update</a></td>			
		</tr>
		</c:forEach>
	</table>
</body>
</html>