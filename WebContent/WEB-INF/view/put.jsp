<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>put</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath }/save" method="POST" modelAttribute="employee">
		<c:choose>
			<c:when test="${employee.id != 0 }">
			<form:hidden path="id" value="${employee.id }"/>
				id:${id }
			</c:when>
			<c:otherwise>
				lastName:<form:input path="lastName"/>
			</c:otherwise>
		</c:choose>
		<br><br>
		email:<form:input path="email"/>
		<br><br>
		<%
			HashMap<String,String> genders = new HashMap<String,String>();
			genders.put("0", "female");
			genders.put("1", "male");
			request.setAttribute("genders", genders);
		%>
		gender:<form:radiobuttons path="gender" items="${genders }"/>
		<br><br>
		departments:<form:select path="department.id" items="${departments }" 
						itemLabel="departmentName" itemValue="id"></form:select>
		<br><br>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>