<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet" href="Css/login.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Login Page</title>
</head>

<body>

   <section class="container">
    <div class="login">
      <h1>Login to Game Center</h1>
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