<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Store Employee</h4>
<form action="EmployeeController" method="post">
		<input type="hidden" name="operation" value="store">
	<label>Id</label>
	<input type="number" name="id"/><br/>
	<label>Name</label>
	<input type="text" name="name"/><br/>
	<label>Salary</label>
	<input type="number" name="salary"/><br/>
	<input type="submit" value="store employee"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>