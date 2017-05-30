<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; text/css; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
<head>
  <link href="login.css" rel="stylesheet" type="text/css">
  <link href="tablestyle.css" rel="stylesheet" type="text/css">

</head>
<body>

<table>
 	 <thead>
        <tr>
            <th>Product</th>
            <th>Genre</th>
            <th>Publisher</th>
            <th>Minimum age</th>
            <th>Console</th>
            <th>Released date</th>
            <th>Price</th>
            <th>Description</th>

        </tr>
    </thead>
     <%
		Object obj = request.getAttribute("Product");
		if(obj!=null)
		{
			Product p = (Product)obj;
	%>
	<tr>
				<td><%=p.getName()%> </td>
				<td><%=p.getMaingenre()%> </td>
				<td><%=p.getPublisher()%> </td>
				<td><%=p.getAgemin()%> </td>
				<td><%=p.getAgemin()%> </td>
				<td><%=p.getConsole()%> </td>
				<td><%=p.getReleasedate()%> </td>
				<td><%=p.getPrice()%> </td>
				<td><%=p.getDescription()%></td>
				
			</tr>
			
     </table>
<form method="post" action="orders">
<input type="number" class="demoInputBox" name="quantity" placeholder="Quantity">
<input type="hidden" name="id" value="<%=p.getId()%>">

<div class="submit">
			 <input type="submit" name="register-user" value="Add to Cart" class="btnRegister">
			 </div>
		 <% } %>
</form>
</body>
</html>