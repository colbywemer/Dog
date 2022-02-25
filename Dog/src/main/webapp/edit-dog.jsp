<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Dog</title>
</head>
<body>
<form action = "editDogServlet" method= "post">
Dog's Name: <input type = "text" name = "name" value= "${dogToEdit.name}">
Dog's Breed: <input type = "text" name = "breed" value= "${dogToEdit.breed}">
Dog's Color: <input type = "text" name = "color" value= "${dogToEdit.color}">
<input type = "hidden" name = "id" value= "${dogToEdit.id}">
<input type = "submit" value= "Save Edited Dog">
</form>
</body>
</html>