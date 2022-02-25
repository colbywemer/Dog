<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dogs List</title>
</head>
<body>
<form method = "post" action = "navigationServlet">
<table>
<c:forEach items= "${requestScope.allDogs}" var="currentdog">
<tr>
<td><input type= "radio" name= "id"value= "${currentdog.id}"></td>
<th>Name</th>
<td>${currentdog.name}</td>
<th>Breed</th>
<td>${currentdog.breed}</td>
<th>Color</th>
<td>${currentdog.color}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name= "doThisToItem">
<input type = "submit" value = "delete" name= "doThisToItem">
<input type= "submit" value = "add" name = "doThisToItem">
</form>
</body>
</html>