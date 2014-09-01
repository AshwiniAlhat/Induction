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
<script src="https://code.jquery.com/jquery.js"></script>

<link rel="stylesheet" href="css/bootstrap.min.css">

<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<script src="js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of Items</title>
</head>
<body>
<h1>List of items</h1>
<p>Here you can see the list of the items, edit them, remove or update.</p>

<button type="button" class="btn btn-success btn-lg glyphicon glyphicon-plus-sign"   data-toggle="modal" data-target="#myModal">Add</button>

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

<div class="modal fade" id="myModal"  tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        <span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Add Items</h4>
      </div>
      <div class="modal-body">
          <form action="add" method="post" class="addform">
        <div class="form-group">
            <label for="inputName">Name</label>
            <input type="name" class="form-control" id="name" name="name" placeholder="Name">
        </div>
        <div class="form-group">
            <label for="inputQuantity">Quantity</label>
            <input type="quantity" class="form-control" id="quantity" name="quantity" placeholder="Quantity">
        </div>
      
    
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button  type="button" id="submitButton" class="btn btn-primary">Save</button>
      </div>
      <DIV class="alert alert-success" id="save-success" role="alert" fade="3000" style="display:none;">
      	SUCCESS!!
      </DIV>
        <DIV class="alert alert-danger " id="save-failure" role="alert" style="display:none;">
      	Failure!!
      </DIV>
      </form>
      
    </div>
  </div>
</div>
<SCRIPT>

$(function() {
//twitter bootstrap script
	$("button#submitButton").click(function(){
	        $.ajax({
   		type: "POST",
		url: "http://localhost:8080/inventory/items",
		data: $('form.addform').serialize(),
       	success: function(msg){
	                $("#save-success").show();
		        },
		error: function(){
			 $("#save-failure").show();
			}
     		});
	});
});
</script>
</SCRIPT>



</body>
</html>