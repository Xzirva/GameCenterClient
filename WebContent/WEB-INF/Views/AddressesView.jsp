<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Address"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Customers List</title>
 </head>
 <body>
    <h4>Sort by</h4>
Sort :
<form method="get" action="customers">
	<input name="sortType" type="radio" value="1"/>Shipping
	<input name="sortType" type="radio" value="1"/>Billing
	<input type="submit" value="Trier" />
</form>
    
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Address</th>
          <th>Zipcode</th>
          <th>City</th>
          <th>Country</th>
          <th>Type</th>
          <th>Action</th>
       </tr>
      <%
		Object obj = request.getAttribute("AddressesList");
		if(obj!=null)
		{
			List<Address> la = (List<Address>)obj;
			for(Address u : la)
			{
	%>
			<tr>
				<td><%=u.getAddress()%></td>
				<td><%=u.getZipcode()%></td>
				<td><%=u.getCity()%></td>
				<td><%=u.getCountry()%></td>
				<td><%=u.getType()%></td>
				<td>
					<a href="customers?action=delete&id=<%=u.getId()%>">Delete</a>
					<a href="customers?action=put&id=<%=u.getId()%>">Edit</a>	
				</td>
			</tr>
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

<h3>
<a href="Customerform.html">Add</a>
</body>
</html>