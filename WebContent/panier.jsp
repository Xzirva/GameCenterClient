<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Order"%>
<%@page import="beans.OrderLine"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; text/css; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
<head>
  <link href="../Css/login.css" rel="stylesheet" type="text/css">
  <link href="../Css/tablestyle.css" rel="stylesheet" type="text/css">

</head>
<body>

<table>
 	 <thead>
        <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
        </tr>
    </thead>
    <%
		Object obj = request.getAttribute("Panier");
		if(obj!=null)
		{
			Order o = (Order)obj;
			List<OrderLine> lo = o.getOrderLines();
			for(OrderLine u : lo)
			{
	%>
		<tr>
			
				<td><%=u.getProd().getName()%> </td>
				<td><%=u.getQte()%> </td>
				<td> <%=u.getTotal()%></td>	
				<td>				
					<a href="orders?action=removeProduct&id=<%=o.getId()%>">Add</a>						
				</td>	
		</tr>
			</tbody>
			<% 
			}
			%>
			<tr>
			<td><%= o.getTotal() %><td>
			</tr>
		</table>
		</body>
		<a href="Orders?action=pay">Pay</a>
		<a href="Orders?action=remove">Remove</a>
		<%
		}
		
		else
		{
			%> 
			<h1>Empty Cart</h1>
			<%
			
		}
		
		%>
		
		<a href="products?action=">View Products</a>


</html>