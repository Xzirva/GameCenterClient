<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Product"%>
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
		<script src="js/jquery.js"></script>
		<script src="js/jquery-migrate-1.2.1.js"></script>
		<script src="js/script.js"></script>
		<script src="js/superfish.js"></script>
		<script src="js/jquery.ui.totop.js"></script>
		<script src="js/jquery.equalheights.js"></script>
		<script src="js/jquery.mobilemenu.js"></script>
		<script src="js/jquery.easing.1.3.js"></script>
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
								<li><a href="http://localhost:8080/GameCenterClient/orders">OUR GAMES</a></li>
								<li><a href="index-2.html"> SALES </a></li>
								<li><a href="LoginFormCustomer.jsp">MY ACCOUNT</a></li>
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

     <%
		Object obj = request.getAttribute("Product");
	
		Product p = (Product)obj;
	%>
	<!--==============================Content=================================-->
	
		<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - February 10, 2014!</div>
			<div class="container_12">
				<div class="grid_8">
					<h3>Special offers</h3>
					<div class="block2">
						<img src="images/page3_img1.jpg" alt="" class="img_inner fleft">
						<div class="extra_wrapper">
							<div class="text1 col1"><%=p.getName()%> BY <%=p.getPublisher()%></div>
							<div class="text1 col1"><%=p.getConsole() %></div>
							<p> Age Min: <%=p.getAgemin()%></p>
							<p> Released: <%=p.getReleasedate()%></p>
							<p> Price: <%=p.getPrice()%></p>
							<p><%= p.getDescription() %></p>
							<br>
							<a href="#" class="link1">Add to Cart</a>
						</div>
					</div>
					
				</div>
				<div class="grid_3 prefix_1">
					<h5>CHOOse the country</h5>
					<form method="post" action="orders">
						<input type="number" class="demoInputBox" name="quantity" placeholder="Quantity">
						<input type="hidden" name="productid" value="<%=p.getId()%>">
						<div class="submit">
			 			<input type="submit" name="register-user" value="Add to Cart" class="btnRegister"> 
					</input>
					</div>
					</form>
			</div>
		</div>
<!--==============================footer=================================-->
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
		</script>

</body>
</html>