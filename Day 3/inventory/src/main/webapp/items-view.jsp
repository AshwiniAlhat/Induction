<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ideas.model.Item" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Latest compiled and minified CSS -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">

<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<script src="js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of Items</title>
</head>
<body>
<h1>List of items</h1>
<p>Here you can see the list of the items, edit them, remove or update.</p>

<button type="button" class="btn btn-success btn-lg glyphicon glyphicon-plus-sign">Add</button>

<table class = "table table-striped table-hover">
<thead>
<tr>
<th width="15%">Sr. No</th><th width="15%">Name</th><th width="10%">Quantity</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${items}" varStatus="loop">
<tr class = "${item.quantity == 0 ? 'danger' : ''}"> 
	<td>${loop.index+1}</td>
	<td>${item.name}</td>	
	<td>${item.quantity}</td>
</tr>
</c:forEach>
</tbody>
</table>



</body>
</html>