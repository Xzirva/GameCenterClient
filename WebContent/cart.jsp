<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Order"%>
<%@page import="beans.OrderLine"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; text/css; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<title>GAME CENTER</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/table.css">
		<link rel="stylesheet" href="css/form.css">
		<link rel="stylesheet" href="css/divide.css">	
		<script src="js/script.js"></script>
		<script src="js/superfish.js"></script>
	
		<script>
		$(document).ready(function(){
			$().UItoTop({ easingType: 'easeOutQuart' });
		});
		</script>
		<!--[if lt IE 8]>
		<div style=' clear: both; text-align:center; position: relative;'>
			<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
				<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
			</a>
		</div>
		<![endif]-->
		<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<link rel="stylesheet" media="screen" href="css/ie.css">
		<![endif]-->
	</head>
	<body>
<!--==============================header=================================-->
		<header>
			<div class="container_12">
				<div class="grid_12">
					<div class="menu_block">
						<nav class="horizontal-nav full-width horizontalNav-notprocessed">
							<ul class="sf-menu">
								<li class="current"><a href="index.html">ABOUT</a></li>
								<li><a href="http://localhost:8080/GameCenterClient/orders?action=show">OUR GAMES</a></li>
								<li><a href="orders?action=showCart"> MY CART </a></li>
								<li><a href="http://localhost:8080/GameCenterClient/customers?action=myaccount">MY ACCOUNT</a></li>
								<li><a href="index-4.html">CONTACTS</a></li>
							</ul>
						</nav>
						<div class="clear"></div>
					</div>
				</div>
				<div class="grid_12">
					<h1>
						<a href="index.html">
							
						</a>
					</h1>
				</div>
			</div>
		</header>  

<table class="container">
	<thead>
        <tr>
            <th><h1>Product</h1></th>
            <th><h1>Quantity</h1></th>
            <th><h1>Price</h1></th>
            <th><h1>Total</h1></th>
        </tr>
    </thead>
    <%
		Object obj = request.getAttribute("Cart");
		if(obj!=null)
		{
			Order o = (Order)obj;
			if(o.getTotal()==0)
			{
				
				%><br>
				  <h1> Empty Cart.. Start your shopping now!</h1>
				  
			<% }
			else
			{
				List<OrderLine> lo = o.getOrderLines();
				for(OrderLine u : lo)
				{
	%>
					<tr>
					<td><%=u.getProd().getName()%>(<%=u.getProd().getConsole()%>)</td>
					<td><%=u.getQte()%> </td>
					<td> <%=u.getTotal()%></td>	
					<td>				
						<a href="orders?action=removeProduct&productid=<%=u.getProd().getId()%>">Remove</a>						
					</td>	
				</tr>
				</tbody>
				<% 
				}
				%>
				<tr>
				<td>Total Price<td>
				<td><%= o.getTotal() %><td>
				</tr>
		</table>
		
		 <p><h2><a href="orders?action=pay">Pay</a></h2></p>
		
		 <h2><a href="orders?action=removeCart">Remove</a></h2>
		<%
			}
		}
		
		else
		{
			%> 
			<h1>Empty Cart.. Start you shopping now!</h1>
			<%
			
		}
		
		%>
		
		<p> <h2><a href="orders?action=show">View Products</a><p> <h2>

</body>
</html>