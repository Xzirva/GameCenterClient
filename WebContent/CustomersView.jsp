<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Customer"%>
<%@page import="java.util.List"%>
<link rel="stylesheet" href="login.css">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
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
	</head>
	
<!--==============================header=================================-->
	
<body>
		<header>
			<div class="container_12">
				<div class="grid_12">
					<div class="menu_block">
						<nav class="horizontal-nav full-width horizontalNav-notprocessed">
							<ul class="sf-menu">
								<li class="current"><a href="index.html">ABOUT</a></li>
								<li><a href="http://localhost:8080/GameCenterClient/orders">OUR GAMES</a></li>
								<li><a href="index-2.html"> SALES </a></li>
								<li><a href="http://localhost:8080/GameCenterClient/customers">MY ACCOUNT</a></li>
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

<div id="sidebar">
<div class="grid_3 prefix_1">
					<h3 class="head1">My Profile</h3>
					<ul class="list">
						<li><a href="orders?action=showCart">My Cart</a></li>
						<li><a href="addresses">My Addresses</a></li>
						<li><a href="payments">My Payments</a></li>
						<li><a href="orders?action=showOrders">My Orders</a></li>	
					</ul>
					
		<h3 class="head2"><a href="LoginFormCustomer.jsp">Add New Product</a></h3>
					
		
</div>
</div>

<table class="container">
	<thead>
	<tr>
          <th><h1>Id</h1></th>
          <th><h1>Firstname</h1></th>
          <th><h1>Lastname</h1></th>
          <th><h1>Gender</h1></th>
          <th><h1>Username</h1></th>
          <th><h1>Email</h1></th>
          <th><h1>Action</h1></th>
       </tr>
       </thead>
       <%
		Object obj = request.getAttribute("CustomersList");
		if(obj!=null)
		{
			Customer u = (Customer)obj;
			
	%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getFirstname()%></td>
				<td><%=u.getLastname()%></td>
				<td><%=u.getGender()%></td>
				<td><%=u.getUsername()%></td>
				<td><%=u.getEmail()%></td>
				<td>
				
					<a href="customers?action=edit=<%=u.getId()%>">Edit</a>
					
				</td>
			</tr>
	<%
		}
		
		else
		{
			%>
			   <h2>NULL</h2>
			<%		
		}
	  %>
    </table>



</body>
</html>