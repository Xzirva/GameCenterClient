
<html>
<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <title>User Input Form</title>
</head>
 
<body>
<h2>Customer Input Form</h2>
<form method="post" action="http://localhost:8080/GameCenter/web-services/auth/register">
	<table border="0" width="500" align="center" class="demo-table">
		<?php if(!empty($success_message)) { ?>	
		<div class="success-message"><?php if(isset($success_message)) echo $success_message; ?></div>
		<?php } ?>
		<?php if(!empty($error_message)) { ?>	
		<div class="error-message"><?php if(isset($error_message)) echo $error_message; ?></div>
		<?php } ?>
		<tr>
			<td>User Name</td>
			<td><input type="text" class="demoInputBox" name="username" ></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" class="demoInputBox" name="first_name" ></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" class="demoInputBox" name="last_name" ></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" class="demoInputBox" name="pwd" value=""></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><input type="password" class="demoInputBox" name="confirm_password" value=""></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" class="demoInputBox" name="email" value=""></td>
		</tr>
		<tr>
			<td>Gender</td>
			 <td>
				 <input type="radio" name="gender" value="m" checked />Male
			 	<input type="radio" name="gender" value="f" checked />Female
			 </td>
		</tr>
		<tr>
			<td colspan=2>
			<input type="checkbox" name="terms"> I accept Terms and Conditions
		</tr>
		<tr>
			<td>
			 <input type="submit" name="register-user" value="Register" class="btnRegister">
			 </td>
		</tr>
	</table>
</form>
</html>