<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Address"%>
<%@page import="beans.Payment"%>
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
								<li><a href="index-2.html"> SALES </a></li>
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

<section class="container">
    <div class="login">
      <h1>Confirm Order</h1>
<form method="post" action="orders">

<p>
			Shipping Address<select name="shipping">
		
<% 
		Object obj = request.getAttribute("AddressesShippingList");
		if(obj!=null)
		{
			List<Address> las = (List<Address>)obj;
			for(Address u : las)
			{
		
		
%>
		<option value=<%=u.getId()%>><%=u.getAddress()%></option>
	
		<%  } 
		}
		%>
		
</select>
</p>

<p>
			Billing Address<select name="billing">
		
<% 	
		obj = request.getAttribute("AddressesBllingList");
		if(obj!=null)
		{
			List<Address> lab = (List<Address>)obj;
			for(Address u : lab)
			{
%>	

		<option value=<%=u.getId()%>><%=u.getAddress()%></option>
	
		<% } 
		}
		%>	
</select>
</p>
	
<p>
			Credit Card <select name="payment">
<%	
		obj = request.getAttribute("PaymentList");
		if(obj!=null)
		{
			List<Payment> lp = (List<Payment>)obj;
			for(Payment u : lp)
			{
%>
	<option value=<%=u.getId()%>><%=u.getCvv()%></option>
	
		<% } 
		}
		%>	
</select>
</p>
	


</form>
</div>
</section>
</body>
</html>