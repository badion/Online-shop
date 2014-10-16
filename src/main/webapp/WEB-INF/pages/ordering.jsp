<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">

<link rel="stylesheet" type="text/css" href="css/datepicker.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/styleGroup.css" />


<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/additional-methods.js"></script>
<script type="text/javascript" src="js/registration.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>



<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery('.delivery').hide();
		jQuery("#ship").change(function() {
			if (jQuery(this).find("option:selected").val() == "pickup") {
				jQuery(".delivery").hide();
				jQuery(".addressOfCompany").show();
			}
			if (jQuery(this).find("option:selected").val() == "courier") {
				jQuery(".delivery").show();
				jQuery(".addressOfCompany").hide();
			}
		});
	});
</script>



<title>Ordering</title>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>

	<br>
	<div class="main_wraper">
		<div class="container">
			<h1 align="center">Ordering</h1>
			<div class="row">
				<div class="col-md-6">
					<form action="orderSuccess" id="registrationId" method="post">
						<input type="hidden" name="sumToDb" value="${priceSum}" />
						<fieldset class="main_table">
							<div class="form-group">
								<label class="control-label" for="firstName">First name:</label>
								<div class="input-group">
									<input type="text" name="firstName" id="firstName" size="40px"
										class="form-control" value="${customer.firstName}"
										placeholder="Enter your first name" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="lastName">Last name:</label>
								<div class="input-group">
									<input type="text" name="lastName" size="40px"
										class="form-control" value="${customer.lastName}"
										placeholder="Enter your second name" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="phone">Phone:</label>
								<div class="input-group">
									<input type="text" name="phone" size="40px"
										class="form-control" value="${customer.phone}"
										placeholder="Enter your phone number" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="email">Email:</label>
								<div class="input-group">
									<input type="text" name="email" size="40px"
										class="form-control" value="${customer.email}"
										placeholder="Enter your email" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="shippingType">Shipping
									type:</label>
								<div class="input-group">
									<select id="ship" name="ship" class="form-control">
										<option id="pickup" value="pickup">Pickup</option>
										<option id="courier" value="courier">Сourier delivery</option>
									</select>
								</div>
							</div>
							<div class="addressOfCompany">
								<div class="form-group">
									<div class="input-group">
										<label class="control-label" for="addressOfCompany">Address:
											Ukraine, Lviv Shevchenka 25 str.</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="delivery">
									<label class="control-label" for="deliveryOptions">Delivery
										options:</label> <br> <label class="control-label"
										for="deliveryCountry">Country:</label>
									<div class="input-group">
										<input type="text" name="deliveryCountry" class="form-control"
											value="" size="40px" placeholder="Enter your country" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="delivery">
									<br> <label class="control-label" for="deliveryCity">City:</label>
									<div class="input-group">
										<input type="text" name="deliveryCity" class="form-control"
											value="" size="40px" placeholder="Enter your city" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="delivery">
									<br> <label class="control-label" for="deliveryAddress">Address:</label>
									<div class="input-group">
										<input type="text" name="deliveryAddress" class="form-control"
											value="" size="40px" placeholder="Enter your address" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<label class="control-label" for="date">Date:
										${prevProduct.get(0).date}</label>
								</div>
							</div>

						</fieldset>

						<p />
						<input type="submit" onclick="alert('Order is completed')"
							class="btn btn-success" name="makeOrder">Make order</a>
					</form>
				</div>
				<div class="col-md-6">
					<form action="ordering" method="get">
						<label class="control-label" for="firstName">Products:</label>
						<c:forEach items="${prevProduct}" var="products">
							<fieldset>
								<div class="form-group">
									<div class="input-group">
										<a class="thumbnail"> ${products.name} /
											${products.description}<span><img
												src="../OnlineShop/images/${products.name}.jpg" />
												${products.description}</span>
										</a>
										<h3>price: ${products.price}$</h3>
									</div>
								</div>
							</fieldset>
						</c:forEach>
						<h2>Total price: ${priceSum}$</h2>
					</form>
				</div>
			</div>
		</div>

		<jsp:include page="../footer/footer.jsp" />
	</div>
	<br>

</body>
</html>

