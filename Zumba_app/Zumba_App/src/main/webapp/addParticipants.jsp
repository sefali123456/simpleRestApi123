<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Participants Details</h2>
<form action="ParticipantsController" method="post">
<label>Participants Name</label>
<input type="text" name="pname"><br/>
<label>Age</label>
<input type="number" name="age"><br/>
<label>PhoneNumber</label>
<input type="number" name="phonenumber"><br/>

<input type="submit" value="Store Batch"/>
<input type="reset" value="reset"/>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>