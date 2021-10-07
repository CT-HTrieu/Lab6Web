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
	${message }
	<form:form action="record/insert.htm" modelAttribute="record">
		<div>
			<label>Nhân viên</label>
			<form:select path="staff.ID" items="${staffs }" itemValue="ID" itemLabel="name"/>
		</div>
		
		<div>
			<label>Loại</label>
			<form:radiobutton path="type" value="1" label="Thành tích"/>
			<form:radiobutton path="type" value="0" label="Kỉ luật"/>
		</div>
		
		<div>
			<label>Lí do</label>
			<form:textarea path="reason" rows="3"/>
		</div>
		
		<div>
			<button>Insert</button>
		</div>
	</form:form>
</body>
</html>