<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<h1>Please enter email id and password</h1>
<meta charset="ISO-8859-1">
</head>
<body>

<%!String email,pass; %>
<%
	email = request.getParameter("email");
	pass = request.getParameter("pass");
	
	
	// We can write JDBC code. we need to convert maven and write jdbc code. 
	//Class.forName("");
	//Connection con = DriverManager.getConnection("", "", "");
	
	if(email.equals("rohit@gmail.com") && pass.equals("rohit@123")){
		out.println("sucessfully login");
		//rd1.forward(request, response);
		%>
			<jsp:forward page="home.jsp"></jsp:forward>
		<%
	}else {
		out.println("failure try once again");
		//rd2.include(request, response);
			%>
			<jsp:include page="index.html"></jsp:include>
			<%
	}
	response.setContentType("text/html");
%>
</body>
</html>