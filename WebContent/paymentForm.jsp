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
		<link rel="stylesheet" href="css/login.css"/>
	     <link rel="stylesheet" href="css/style.css">
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
	<h1>Payment Form</h1>
	
	<section class="container">
    <div class="login">
<form method="post" action="payments">
	<h1>Address Form</h1>
<br>	
	
	
	<p>
			<select name="type">
  				<option selected value="visa">VISA</option>
  				<option value="mastercard">MASTER CARD</option>
  				<option value="americanexpress blizzard">AMERICAN EXPRESS</option>
  				<option value="discover">DISCOVER</option>
  			</select>
		</p>
		
		<p>
			<input type="text" name="pan" placeholder="PAN"/>
		</p>
		
		
		<p>
			<input type="text" name="cvv" placeholder="CVV"/>
		</p>
		
		<p>
			Expiration Date: <select name="month">
  				<option value="1">January</option>
  				<option value="2">February</option>
 				<option selected value="3">March</option>
 				<option value="4">April</option>
 				<option value="5">May</option>
 				<option value="6">June</option>
 				<option value="7">July</option>
 				<option value="8">August</option>
 				<option value="9">September</option>
 				<option value="10">October<option>
 				<option value="11">November</option>
 				<option value="12">December</option>
			</select>
  				

			<select name="year">
				<option selected value="2017">2017</option>
				<option value="2012">2018</option>
  				<option value="2012">2019</option>
  				<option value="2013">2020</option>
  				<option value="2012">2021</option>
  				<option value="2013">2022</option>
  				<option value="2012">2023</option>
  				<option value="2013">2024</option>
  				<option value="2012">2025</option>
  				<option value="2011">2026</option>
			</select>
		</p>
		
		
		 <div class="submit">
        	<input type="submit" name="commit" value="Add Payment">
        </div>
	</form>
	</div>
	</section>
	
<footer>
			<div class="container_12">
				<div class="grid_12">
					<div class="socials">
						<a href="#" class="fa fa-facebook"></a>
						<a href="#" class="fa fa-twitter"></a>
						<a href="#" class="fa fa-google-plus"></a>
					</div>
					<div class="copy">
						Your Trip (c) 2014 | <a href="#">Privacy Policy</a> | Website Template Designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a>
					</div>
				</div>
			</div>
		</footer>
		<script>
			$(function (){
				$('#bookingForm').bookingForm({
					ownerEmail: '#'
				});
			})
			$(function() {
				$('#bookingForm input, #bookingForm textarea').placeholder();
			});
		</script>
		
		
</body>
</html>