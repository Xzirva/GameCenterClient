<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.OrderLine"%>
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
          <th>Product</th>
          <th>Quantity</th>
          <th>Total</th>
       </tr>
      <%
		Object obj = request.getAttribute("OrderLinesView");
		if(obj!=null)
		{
			List<OrderLine> la = (List<OrderLine>)obj;
			for(OrderLine u : la)
			{
	%>
			<tr>
				<td><%=u.getProd().getName()%></td>
				<td><%=u.getQte()%></td>
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
<a href="orders?action=show">View Orders</a>
<a href="products?action=">View Products</a>
</body>
</html>