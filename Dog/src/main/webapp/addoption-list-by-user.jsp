<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adoptions Lists</title>
</head>
<body>
<form method= "post" action="addoptionNavigationServlet">
<table>
<c:forEach items="${requestScope.allAddoptions}" var="currentlist">
<tr>
<td><input type="radio" name="id" value="${currentlist.id}"></td>
<td><h2>${currentlist.ownerName}</h2></td></tr>
<tr><td colspan="3">Adoption Date: ${currentlist.adoptionDate}</td></tr>
<tr><td colspan="3">Address: ${currentlist.address}</td></tr>
<tr><td colspan="3">Phone Number: ${currentlist.phoneNumber}</td></tr>
<c:forEach var ="listVal" items ="${currentlist.listOfDogs}">
<tr><td></td><td colspan="3">${listVal.name}, ${listVal.breed}, ${listVal.color}</td></tr>
</c:forEach>
</c:forEach>
</table>
<input type ="submit" value ="edit" name="doThisToList">
<input type ="submit" value ="delete" name="doThisToList">
<input type="submit" value ="add" name ="doThisToList">
</form>
<a href="home.html">Insert a new dog</a>
</body>
</html>