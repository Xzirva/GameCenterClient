<html>
<body>
	<h1>Address Form</h1>

	<form action="" method="post">
	
	<p>
			Type: <select name="type">
  				<option selected value="visa">VISA</option>
  				<option value="mastercard">MASTER CARD</option>
  				<option value="americanexpress blizzard">AMERICAN EXPRESS</option>
  				<option value="discover">DISCOVER</option>
  			</select>
		</p>
		
		<p>
			PAN : <input type="text" name="pan" />
		</p>
		
		
		<p>
			CVV : <input type="text" name="cvv" />
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

			<select name="day">
  				<option value="1">1</option>
  				<option value="2">2</option>
  				<option selected value="3">3</option>
  				<option value="4">4</option>
  				<option value="5">5</option>
  				<option value="6">6</option>
  				<option value="7">7</option>
  				<option value="8">8</option>
  				<option value="9">9</option>
  				<option value="10">10</option>
  				<option value="11">11</option>
  				<option value="12">12</option>
  				<option value="13">13</option>
  				<option value="14">14</option>
  				<option value="15">15</option>
  				<option value="16">16</option>
  				<option value="17">17</option>
  				<option value="18">18</option>
  				<option value="19">19</option>
  				<option value="20">20</option>
  				<option value="21">21</option>
  				<option value="22">22</option>
  				<option value="23">23</option>
  				<option value="24">24</option>
  				<option value="25">25</option>
  				<option value="26">26</option>
  				<option value="27">27</option>
  				<option value="28">28</option>
  				<option value="29">29</option>
  				<option value="30">30</option>
  				<option value="31">31</option>
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
		
		
		<input type="submit" value="Add Payment" />
	</form>

</body>
</html>