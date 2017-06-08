<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>	
	<link rel="stylesheet" href="css/login.css"/>
	<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/form.css">
		<link rel="stylesheet" href="css/divide.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	
	<title>Login Page</title>
</head>e>Login Page</title>
</head>
<body >
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
							<!-- <img src="images/logo.png" alt="Your Happy Family"> -->
						</a>
					</h1>
				</div>
			</div>
		</header>

   <section class="container">
    <div class="login">
      <h1>Login to Game Center As Admin</h1>
      <form method="post" action="index.html">
        <input type="text" name="username" value="" placeholder="Username">
        <input type="password" name="password" value="" placeholder="Password">
        
        <div class="submit">
        	<input type="submit" name="commit" value="Login">
        </div>
      </form>
    </div>

    <div class="login-help">
      <p>Forgot your password? <a href="reset.html">Click here to reset it</a>.</p>
    </div>
    
    <div class="login-help">
      <p>Not Member? <a href="CustomerForm.html">Click here to Register!</a>.</p>
    </div>
    
  </section>

  <section class="about">
     <p class="about-links">
      <a href="products" target="_parent">Continue without Loging in</a>
    </p>

  </section>
</body>
</html>