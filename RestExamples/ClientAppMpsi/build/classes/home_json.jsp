<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>sending json data</h2>
<h3>use prefix 96 for vodafone for example : 9654545454</h3>
<h3>user prefix 88 for airtel for example : 8865656565</h3><br>
<form action="getServiceProviderNameJson" method="post">
	Mobile Number : <input type="text" name="mobileNumber"><br>
	<input type="Submit" value="Submit">
</form>

</body>
</html>