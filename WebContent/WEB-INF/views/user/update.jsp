<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath }/">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="user/update.htm" modelAttribute="user" method="POST">
		<div>
			<label>Username</label>
			<form:input path="username" value="${user.username }"/>
		</div>
		
		<div>
			<label>Password</label>
			<form:input path="password" value="${user.password }"/>
		</div>
		
		<div>
			<label>Fullname</label>
			<form:input path="fullname" value="${user.fullname }"/>
		</div>
		
		<div>
			<button class="btn btn-default">Update</button>
		</div>
	</form:form>
</body>
</html>