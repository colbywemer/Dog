<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new addoption</title>
</head>
<body>
<form action ="createNewAddoptionServlet" method="post">
Owner's Name: <input type ="text" name ="ownerName"
><br />
Adoption date: <input type ="text" name ="month" placeholder="mm" size="4"> 
<input type ="text" name ="day" placeholder="dd" size="4">, 
<input type ="text" name ="year" placeholder="yyyy" size="4">
Address: <input type ="text" name ="address"><br />
Phone Number: <input type ="text" name ="phoneNumber"><br />
Available Items:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
<option value ="${currentitem.id}">${currentitem.name} |${currentitem.breed} |${currentitem.color}</option>
</c:forEach>
</select>
<br />
<input type ="submit" value="Create Addoption and Add Dogss">
</form>
<a href ="home.html">Go add new dogs instead.</a>
</body>
</html>