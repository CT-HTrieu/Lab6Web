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
			<th>Name</th>
			<th>Gender</th>
			<th>Depart</th>
			<th></th>
		</tr>
	
		<c:forEach var="st" items="${staffs }">
		<tr>
			<td>${st.ID }</td>
			<td>${st.name }</td>
			<td>${st.gender }</td>
			<td>${st.depart.name }</td>
			<td><a href="staff/delete/${st.ID }.htm?linkDelete">Delete</a></td>	
			<td><a href="staff/update/${st.ID }.htm?linkEdit">Update</a></td>			
		</tr>
		</c:forEach>
	</table>
</body>
</html>