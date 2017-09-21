<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

Mobile Number : <input type="text" name="mobileNumber" value="${mobilenumber}"><br>
Operator Name : <input type="text" name="mobileOperator" value="${operatorname}"><br>
Customer Name : <input type="text" name="customername" value="${customername}"><br>
<br>
<a href='<c:url value='/home_json'></c:url>'>Home</a>
</body>
</html>