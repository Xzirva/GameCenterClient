<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Customer"%>
<%@page import="java.util.List"%>
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
		<link rel="stylesheet" href="login.css">
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

<div id="sidebar">
			<div class="grid_3 prefix_1">
					<h3 class="head1">My Profile</h3>
					<ul class="list">
						<li><a href="orders?action=showCart">My Cart</a></li>
						<li><a href="addresses?action=showShipping">My Shipping Addresses</a></li>
						<li><a href="addresses?action=showBilling">My Billing Addresses</a></li>
						<li><a href="payments?action=showAll">My Payments</a></li>
						<li><a href="orders?action=showOrders">My Orders</a></li>		
					</ul>
					
					<h3 class="head1">Update Information </h3>
					<ul class="list">
						<li><a href="addressForm.jsp">Add Address</a></li>
						<li><a href="paymentForm.jsp">Add Payment</a></li>		
					</ul>
				</div>
			</div>
			
			
     <% Object obj = request.getAttribute("Customer");
		if(obj!=null)
		{
			Customer c = (Customer)obj;
		
	%>
	
   <section class="container">
    <div class="login">
	<form method="post" action="customers">
	<h1>Customers Form</h1>
<br>	
<p>
		<input type="text" name="firstname" value=<%=c.getFirstname()%> />
		</p>
		<p>
		<input type="text" name="lastname" value=<%=c.getLastname()%> />
	</p>
	<p>
       <input type="text" name="email" value=<%=c.getEmail()%>/>
	</p>
	
	<p>
			<input type="radio" name="gender" value="m" />Male
			<input type="radio" name="gender" value="f" checked />Female
		</p>
			
		<input type="hidden" name="username" value=<%=c.getUsername()%> />
		<input type="hidden" name="idcustomer" value=<%=c.getId()%> />
		<input type="hidden" name="typeaction" value="update" />
		
		 <div class="submit">
        	<input type="submit" name="commit" value="Edit Address">
        </div>
        
      <%} %>  
	</form>
	
	</div>
	</section>
	
	</body>
	</html>