<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List </title>
</head>
<body>
	${ hello }
	
	
	<c:if test="${empty employees }">
		沒有
	</c:if>
	
	<c:if test="${!empty employees }">
		<table border="1" cellspacing="0" cellpadding="9" >
			<tr>
				<th>Id</th>
				<th>lastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>	
				<c:forEach items="${employees }" var="emp">
					<tr>
						<td>${emp.id }</td>
						<td>${emp.lastName }</td>
						<td>${emp.email }</td>
						<td>${emp.gender == 0 ? 'female' : 'male' }</td>
						<td>${emp.department.departmentName }</td>
						<td><a href="update/${emp.id }">edit</a></td>
						<td><a href="delete/${emp.id }" onclick="return deleteById()">delete</a></td>					
					 </tr>
				</c:forEach>				
		</table>
	</c:if>	
	<a href="add">add employee</a>
	<script type="text/javascript">
		function deleteById(){
			
			var con = confirm("是否确认删除？");
			if(con == true){
				return true;
			}else{
				return false;
			}
		}
	</script>
</body>
</html>