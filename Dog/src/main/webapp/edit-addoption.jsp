<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing Adoption</title>
</head>
<body>
<form action ="editAddoptionDetailsServlet" method="post">
<input type ="hidden" name ="id" value="${addoptionToEdit.id}">
Owner Name: <input type ="text" name ="ownerName" value=" ${addoptionToEdit.ownerName}"><br />
Adoption date: <input type ="text" name ="month" placeholder="mm" size="4" value="${month}"> 
<input type ="text" name ="day" placeholder="dd" size="4" value="${date}">, 
<input type ="text" name="year" placeholder="yyyy" size="4" value="${year}">
Address: <input type ="text" name ="address" value="${addoptionToEdit.address}"><br />
Phone Number: <input type ="text" name ="phoneNumber" value="${addoptionToEdit.phoneNumber}"><br />
Available Dogs:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
<option value ="${currentitem.id}">${currentitem.name} |${currentitem.breed} |${currentitem.color}</option>
</c:forEach>
</select>
<br />
<input type ="submit" value="Edit Addoption and Add Dogs">
</form>
<a href ="home.html">Go add new dogs instead.</a>
</body>
</html>