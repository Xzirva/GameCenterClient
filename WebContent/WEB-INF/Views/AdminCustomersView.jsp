<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Customer"%>
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
	<input name="sortType" type="radio" value="1"/>firstname
	<input name="sortType" type="radio" value="1"/>lastname
	<input name="sortType" type="radio" value="2"/>username
	<input type="hidden" name="action" valce="sort" />
	<input type="submit" value="Trier" />
</form>
    
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Gender</th>
          <th>Username</th>
          <th>Email</th>
          <th>Action</th>
       </tr>
      <%
		Object obj = request.getAttribute("CustomersList");
		if(obj!=null)
		{
			List<Customer> lc = (List<Customer>)obj;
			for(Customer u : lc)
			{
	%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getFirstname()%></td>
				<td><%=u.getLastname()%></td>
				<td><%=u.getGender()%></td>
				<td><%=u.getUsername()%></td>
				<td><%=u.getEmail()%></td>
				<td>
				
					<a href="addresses?action=get&id=<%=u.getId()%>">Addresses</a>
					<a href="orders?action=get&id=<%=u.getId()%>">Orders</a>
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