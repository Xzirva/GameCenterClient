<!DOCTYPE html>
<html>
	<head>
		<title>GAME CENTER</title>
		<meta charset="utf-8">
		<meta name="format-detection" content="telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/form.css">
		<link rel="stylesheet" href="css/login.css">
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
<body>
<h1>Become Member of Game Center</h1>
<section class="container">
<div class="login">
	<form method="post" action="auth">
	
			<input type="text" class="demoInputBox" name="username" placeholder="Username">
		

			<input type="text" class="demoInputBox" name="firstname" placeholder="Firstname">
		
		
			
			<input type="text" class="demoInputBox" name="lastname" placeholder="Lastname">

			<input type="password" class="demoInputBox" name="password" value="" placeholder="Password">
		
		
			<input type="password" class="demoInputBox" name="confirm_password" value="" placeholder="Confirm Password">
	

			<input type="text" class="demoInputBox" name="email" value="" placeholder="Email">

			<p>
			<input type="radio" name="gender" value="m" checked />Male
			<input type="radio" name="gender" value="f" checked />Female
			</p>
			
			<input type="hidden" name="typeaction" value="add" />
			
		<p>
		 <div class="submit">
			<input type="checkbox" name="terms"> I accept Terms and Conditions
		</div>
		</p>
			 <div class="submit">
			 <input type="submit" name="register-user" value="Register" class="btnRegister">

		 </div>
</form>		
</div>

</section>
</body>