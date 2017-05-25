<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
<head>
  <link rel="stylesheet" href="mainpage.css">
</head>
<body>

<div class = left>

<form method="get" action="">
Search : <input type="text" name="product" />
<br>

Filter By: <select name="publisher">
  				<option selected value="asc">Price Asc</option>
  				<option value="desc">Price Desc</option>
  				<option value="last">Last Released</option>
  				<option value="last">Favorites</option>
  			</select>

Genre: <select name="publisher">
				<option selected value="all">All</option>
  				<option  value="action">Action</option>
  				<option value="race">Race</option>
  				<option value="dancing">Dance</option>
  				<option value="education">Educational</option>
  			</select>
  			
  			
Console: <select name="console">
				<option selected value="all">All</option>
  				<option  value="action">Wii</option>
  				<option value="race">WiiU</option>
  				<option value="dancing">Xbox</option>
  				<option value="education">PlayStation</option>
  				<option value="education">Game Cube</option>
  			</select>
  			
<input type="submit" value="Query">
</form>
</div>

<div class= right>
 	
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
     <tbody>
     <%
		Object obj = request.getAttribute("ProductsList");
		if(obj!=null)
		{
			List<Product> lp = (List<Product>)obj;
			for(Product u : lp)
		{
	%>
	<tr>
				<td><%=u.getName()%> </td>
				<td><%=u.getMaingenre()%> </td>
				<td><%=u.getPublisher()%> </td>
				<td><%=u.getAgemin()%> </td>
				<td><%=u.getAgemin()%> </td>
				<td><%=u.getConsole()%> </td>
				<td><%=u.getReleasedate()%> </td>
				<td><%=u.getPrice()%> </td>
				<td><%=u.getDescription()%> </td>
				<td>
					<a href="customersdelete?action=get&id=<%=u.getId()%>">Add</a>	
				</td>
			</tr>
			</tbody>
			<%
			}
			
			
		}
		else
		{
			%><h1>NULL</h1>
			<%
			
		}
	%>
			

</table>
 

</div>


</body>
</html>