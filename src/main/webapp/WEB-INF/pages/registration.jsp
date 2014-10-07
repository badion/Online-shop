<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />

<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/additional-methods.js"></script>
<script type="text/javascript" src="js/registration.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<title>Registration form</title>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<!-- Example row of columns -->
	<div class="jumbotron">
	<div class="container">
		<div class="row">
			<h1 align="center">Registration form</h1>
			<form action="registration" id="registrationId" method="post">
				<fieldset>

					<div class="form-group">
						<label class="control-label" for="firstName">First name:</label>
						<div class="input-group">
							<input type="text" name="firstName" id="firstName" size="40px"
								class="form-control" value="${firstName}"
								placeholder="Enter your first name" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="lastName">Last name:</label>
						<div class="input-group">
							<input type="text" name="lastName" size="40px"
								class="form-control" value="${lastName}"
								placeholder="Enter your second name" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="phone">Phone:</label>
						<div class="input-group">
							<input type="text" name="phone" size="40px" class="form-control"
								value="${phone}" placeholder="Enter your phone number" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="email">Email:</label>
						<div class="input-group">
							<input type="text" name="email" size="40px" class="form-control"
								value="${email}" placeholder="Enter your email" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="login">Login:</label>
						<div class="input-group">
							<input type="text" name="login" size="40px" class="form-control"
								value="${login}" placeholder="Enter your future login" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="password">Password:</label>
						<div class="input-group">
							<input type="password" name="password" id="passwordId"
								size="40px" class="form-control" value="${password}"
								placeholder="Enter your future password" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="repeatPassword">Repeat
							password:</label>
						<div class="input-group">
							<input type="password" name="repeatPassword" size="40px"
								class="form-control" value="${repeatPassword}"
								placeholder="Repeat your password" />
						</div>
					</div>
				</fieldset>
				<p />
				<input type="submit" class="btn btn-success" value="registration" />
			</form>
		</div>
		<jsp:include page="../footer/footer.jsp" />
	</div>
	</div>
</html>