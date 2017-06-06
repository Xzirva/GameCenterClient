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

<div id="sidebar">
<div class="grid_3 prefix_1">
					<h3 class="head1">Filter By</h3>
					<ul class="list">
						<li><a href="#">Username</a></li>
						<li><a href="#">Lastname</a></li>
						<li><a href="#">Firstname </a></li>		
					</ul>
					
		<h3 class="head2"><a href="LoginFormCustomer.jsp">Add New Product</a></h3>
					
		
</div>
</div>

<table class="container">
	<thead>
	<tr>
          <th><h1>Id</h1></th>
          <th><h1>IFirstname</h1></th>
          <th><h1>ILastname</h1></th>
          <th><h1>IGender</h1></th>
          <th><h1>IUsername</h1></th>
          <th><h1>IEmail</h1></th>
          <th><h1>IAction</h1></th>
       </tr>
       </thead>
       <%
		Object obj = request.getAttribute("CustomersList");
		if(obj!=null)
		{
			List<Customer> lc = (List<Customer>)obj;
			for(Customer u : lc)
			{
	%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getFirstname()%></td>
				<td><%=u.getLastname()%></td>
				<td><%=u.getGender()%></td>
				<td><%=u.getUsername()%></td>
				<td><%=u.getEmail()%></td>
				<td>
				
					<a href="addresses?action=get&id=<%=u.getId()%>">Addresses</a>
					<a href="orders?action=get&id=<%=u.getId()%>">Orders</a>
					<a href="customers?action=delete&id=<%=u.getId()%>">Delete</a>
					<a href="customers?action=put&id=<%=u.getId()%>">Edit</a>	
				</td>
			</tr>
	<%
			}
			
			
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