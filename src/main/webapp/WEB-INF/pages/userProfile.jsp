<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/styleGroup.css" />



<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/additional-methods.js"></script>
<script type="text/javascript" src="js/registration.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		$('#changeEmail').validate({ // initialize the plugin
			rules : {
				mail : {
					required : true,
					email : true
				},
				
				emailPass : {
					required: true,
					minLength : 5
				}
				
			},
			messages : {
				mail : {
					email : "Email is incorrect",
					required : "Mail is required"
				}, 
				
				emailPass : {
					required : "Your password is required",
					minlength : "Minimal length is 5"
				}
			}

		});

	});
	
	
	$(document).ready(function() {
		$('#changePassword').validate({ // initialize the plugin
			rules : {
				
				oldPassword : {
					required : true,
					minlength : 5
				},
				
				newPass : {
					required : true,
					minlength : 5
				}, 
				
				confirmPassword	: {
					required : true,
					equalTo : "#newPass"
				}
			},
			messages : {
			
			oldPassword : {
				required : "Old password is required",
				minlength : "Minimal length is 5"
			}, 
			
			newPass: {
				required : "New password is required",
				minlength : "Minimal length is 5"
			},
			
			confirmPassword : {
				required : "You must to confirm your new password",
				equalTo : "Passwords is not equals"
			}
			}
		});
	});
		
			
</script>


</style>
<title>User profile</title>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>

	<br>
	<div class="profile">
		<div class="container">
			<h1 align="center">User profile</h1>
			<form action="userProfile" id="registrationId" method="POST" accept-charset="utf-8">
				<fieldset>
				<div class="form-group">
				<label class="control-label" for="firstName">First name:</label>
						<div class="input-group">
							<input type="text" name="firstName" id="firstName" size="30px"
								class="form-control" value="${customer.firstName}"/>
						</div>
				</div>
							<div class="form-group">
						<label class="control-label" for="lastName">Last name:</label>
						<div class="input-group">
							<input type="text" name="lastName" size="30px"
								class="form-control" value="${customer.lastName}"
								 />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="phone">Phone:</label>
						<div class="input-group">
							<input type="text" name="phone" size="30px" class="form-control"
								value="${customer.phone}" />
						</div>
						${samePhoneMessage}
					</div>
					<div class="form-group">
						<label class="control-label" for="email">Email:</label>
						<div class="input-group">
							<input type="text" name="email" size="30px" class="form-control"
								value="${customer.email}" readonly />
						</div>
						${sameMailMessage}
					</div>
					<div class="form-group">
						<label class="control-label" for="login">Login:</label>
						<div class="input-group">
							<input type="text" name="login" size="30px" class="form-control"
								value="${customer.login}"  />
						</div>
						${sameLoginMessage}
					</div>	
				</fieldset>
					
				<button type="submit" class="btn btn-success" id="btn_save">
					Save
				</button>
					<br /> <br />
			</form>
			
			<button class="btn btn-primary btn-default" data-toggle="modal"
				data-target="#chPass">
				Change password
			</button>
			<div class="modal fade" id="chPass" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" >
								Change password
							</h4>
						</div>
						<div class="modal-body">

							<form action="changePassword" method="post" id="changePassword"
								accept-charset="utf-8">
								<fieldset>
									<div class="form-group">
										<label class="control-label" for="oldPassword">Old password:</label>
										<div class="input-group">
											<input type="text" name="oldPassword" id="oldPassword"
												size="30px" class="form-control"
												 />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label" for="newPass">New password:</label>
										<div class="input-group">
											<input type="text" name="newPass" id="newPass"
												size="30px" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="control-label" for="confirmPassword">Confirmed password:</label>
										<div class="input-group">
											<input type="text" name="confirmPassword" id="confirmPassword"
												size="30px" class="form-control" />
										</div>
									</div>

									</fieldset>
									<div class="modal-footer">
										<button type="submit" class="btn btn-default">Save</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
							</form>
								</div>
					</div>
				</div>
			</div>
			
			
				<!-- Button trigger modal -->
			<button class="btn btn-primary btn-default" data-toggle="modal"
				data-target="#chMail">
				Change email
			</button>
			<!-- Modal -->
			<div class="modal fade" id="chMail" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<form action="changeEmail" method="post" id="changeEmail"
					accept-charset="utf-8">

					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title">
									Change email
								</h4>
							</div>
							<div class="modal-body">
							<table class="table table-striped">
									<tr>
										<td>New email</td>
										<td><input type="text" name="mail" id="mail" class="form-control"
											value="${customer.email}"></td>
									</tr>
									<tr>
										<td>Current password</td>
										<td><input type="text" id="emailPass" name="emailPass"
											class="form-control"></td>

									</tr>
								</table>
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-default">
									Save
								</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">
									Close
								</button>
							</div>
						</div>
					</div>
				</form>
			</div>
			
			
		</div>
		<jsp:include page="../footer/footer.jsp" />
	</div>
	<br>

</body>
</html>

