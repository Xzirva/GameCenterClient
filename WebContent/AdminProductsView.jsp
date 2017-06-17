<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Product"%>
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
	
<!--==============================header=================================-->
	
<body>
		<header>
			<div class="container_12">
				<div class="grid_12">
					<div class="menu_block">
						<nav class="horizontal-nav full-width horizontalNav-notprocessed">
							<ul class="sf-menu">
								<li class="current"><a href="index.html">ABOUT</a></li>
								<li><a href="http://localhost:8080/GameCenterClient/adminproducts?action=showAll">OUR GAMES</a></li>
								<li><a href="index-2.html"> SALES </a></li>
								<li><a href="http://localhost:8080/GameCenterClient/admincustomers?action=showAll">OUR CUSTOMERS</a></li>
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
<form method="get" action="adminproducts">
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

<h3 class="head1"><a href="productForm.html">Add New Product</a></h3>
</div>
</div>

<table class="container">
	<thead>
        <tr>
            <th><h1>Product</h1></th>
            <th><h1>Genre</h1></th>
            <th><h1>Publisher</h1></th>
            <th><h1>Minimum age</h1></th>
            <th><h1>Console</h1></th>
            <th><h1>Released date</h1></th>
            <th><h1>Price</h1></th>
            <th><h1>Stock</h1></th>
        </tr>
    </thead>
     <tbody>
     <%
		Object obj = request.getAttribute("ProductsList");
		if(obj!=null)
		{
			List<Product> lp = (List<Product>)obj;
			for(Product u : lp)
		{
	%>
	<tr>
				<td><%=u.getName()%> </td>
				<td><%=u.getMaingenre()%> </td>
				<td><%=u.getPublisher()%> </td>
				<td><%=u.getAgemin()%> </td>
				<td><%=u.getAgemin()%> </td>
				<td><%=u.getConsole()%> </td>
				<td><%=u.getReleasedate()%> </td>
				<td><%=u.getPrice()%> </td>
				<td><%=u.getQuantity()%> </td>
	</tr>
			</tbody>
			<%
			}
			
			
		}
		else
		{
			%><h1>Game Center Empty</h1>
			<%
			
		}
	%>

</table>


    

</body>
</html>