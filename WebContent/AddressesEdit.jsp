<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Address"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; text/css; charset=UTF-8" pageEncoding="UTF-8"%>
    
	<head>
		<title>GAME CENTER</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/form.css">
		<link rel="stylesheet" href="css/divide.css">
		<link rel="stylesheet" href="css/table.css">
		<script src="js/script.js"></script>
		<script src="js/superfish.js"></script>
		<script>
		$(document).ready(function(){
			$().UItoTop({ easingType: 'easeOutQuart' });
		});
		</script>
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
			
			 <%
		Object obj = request.getAttribute("Address");
		if(obj!=null)
		{
			Address a = (Address)obj;
		
	%>
	<section class="container">
    <div class="login">
	<form method="post" action="addresses">
	<h1>Address Form</h1>
<br>	
<p>
		<input type="text" name="address" value=<%=a.getAddress()%> />
		</p>
		<p>
		<input type="text" name="zipcode" value=<%=a.getZipcode()%> />
	</p>
	<p>
       <input type="text" name="city" value=<%=a.getCity()%>/>
		</p>
		<p>
		<input type="text" name="country" value=<%=a.getCountry()%>/>
	</p>
		<p>
			<select name="type">
  				<option value="shipping">Shipping</option>
  				<option value="billing">Billing</option>
  				<option value="both">Both</option>
  			</select>
		</p>
		
		<input type="hidden" name="idaddress" value=<%=a.getId()%> />
		<input type="hidden" name="typeaction" value="update" />
		 <div class="submit">
        	<input type="submit" name="commit" value="Edit Address">
        </div>
        
        
	</form>
	
	
	
	<%} %>
	</div>
	</section>
</body>
</html>