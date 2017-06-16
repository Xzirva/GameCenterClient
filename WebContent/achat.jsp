
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; text/css; charset=UTF-8" pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>GAME CENTER</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="css/style.css">
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
<body>

<div id="sidebar">
<form method="get" action="products">
Search : <input type="text" name="product" placeholder="Username" />
<br>
  			
<input type="submit" value="Search">
</form>

<div class="grid_3 prefix_1">
					<h3 class="head1">Filter By</h3>
					<ul class="list">
						<li><a href="#">Price Asc</a></li>
						<li><a href="#">Price Desc </a></li>
						<li><a href="#">Last Released </a></li>
						<li><a href="#">Members Favorites</a></li>		
					</ul>
					
					<h3 class="head1">Consoles</h3>
					<ul class="list">
						<li><a href="#">Nintendo DS </a></li>
						<li><a href="#">XBox </a></li>
						<li><a href="#">Wii </a></li>
						<li><a href="#">Wii U </a></li>
						<li><a href="#">PSP </a></li>
						<li><a href="#">Play Station </a></li>
						<li><a href="#">Game Cube </a></li>		
					</ul>
					
					<h3 class="head1">Genres</h3>
					<ul class="list">
						<li><a href="#">All</a></li>
						<li><a href="#">Action</a></li>
						<li><a href="#">Adventure </a></li>
						<li><a href="#">Race </a></li>
						<li><a href="#">Dance</a></li>
						<li><a href="#">Educational </a></li>		
					</ul>
</div>
</div>

     <div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - February 10, 2014!</div>
	<div class="container_12">
	 <div class="banners">
     <%
        int i = 0;
		Object obj = request.getAttribute("ProductsList");
		if(obj!=null)
		{
			List<Product> lp = (List<Product>)obj;
			for(Product u : lp)
		{
	%>
				<%if(i>0 && i%3 == 0) {%>
					<div class="clear"></div>
					<%} %>
						
					<div class="grid_4">
						<div class="banner">
							<img src="images/page2_img1.jpg" alt="">
							<div class="label">
								<div class="title"><%=u.getName()%></div>
								<div class="subtitle"><%=u.getConsole() %></div>
								<div class="price"><%=u.getPrice()%></div>							
								<a href="orders?action=showProduct&id=<%=u.getId()%>">LEARN MORE</a>
							</div>
						</div>
				</div>		
			
		
				<% i = i+1;
				%>
			
			<%
			}%>
			</div>
		
			</div>
			
		<%	
		}
		else
		{
			%><h1>Game Center Empty</h1>
			<%
			
		}
	%>
	
	
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