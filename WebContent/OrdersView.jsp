<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Order"%>
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
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Total</th>
          <th>Action</th>
       </tr>
      <%
		Object obj = request.getAttribute("AddressesList");
		if(obj!=null)
		{
			List<Order> la = (List<Order>)obj;
			for(Order u : la)
			{
	%>
			<tr>
				<td><%=u.getTotal()%></td>
				
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