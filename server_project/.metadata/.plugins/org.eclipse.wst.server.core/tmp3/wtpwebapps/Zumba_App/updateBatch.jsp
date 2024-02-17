<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h4>Update Batch Details</h4>
<form action="BatchController" method="post">
	<input type="hidden" name="operation" value="update">
	<label>Id</label>
	<input type="number" name="batchid"/><br/>
	<label>TypeOfBatch</label>
	<input type="Text" name="typeofbatch"/><br/>
	<input type="submit" value="update batch info"/>
	<input type="reset" value="reset"/>
</form>
<br/>
<a href="home.jsp">Back</a>
</body>
</html>