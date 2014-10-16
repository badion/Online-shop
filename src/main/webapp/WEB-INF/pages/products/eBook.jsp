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

<title>eBook categories</title>
</head>
<body>

	<jsp:include page="../../header/header.jsp"></jsp:include>
	
	

	<br>
	<div class="main_wraper">
	<div class="container">
<c:if test="${param.message != null}">	
 <script>alert('Product is successfully add to the basket');</script>
 </c:if>
		<c:if test="${productList.size() == null}"> 
		We don't have any producs
		<br>
		</c:if>
		<c:forEach begin="0" end="${productList.size()-1}" var="products">
		
			<div class="modal fade bs-example-modal-lg" id="${products}" tabindex="-1"
				role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>								     
									<h4 class="modal-title">${productList.get(products).name}</h4>
							</div>
							<div class="modal-body">
								<table>
									<tr>
										<td><img align=""
											src="../../OnlineShop/images/${productList.get(products).name}.jpg" />
										</td>
										<td>
											<p>Quantity: ${productList.get(products).quantity}</p>
											<p>${productList.get(products).description}</p> <br> <br>
											<br> <br> <br> <br> <br> <br> <br>
											<br> <br> <br> <br>
											<h1>${productList.get(products).price}$</h1>
										</td>
									</tr>
								</table>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<c:choose>
								<c:when test="${customer == null}">
									You can't buy. First you have to register and log in system.
								</c:when>
								<c:when test="${customer != null && productList.get(products).quantity > 0}">
									<a type="button" href="contentFromCategory?productId=${productList.get(products).id}" onclick="alert('${productList.get(products).name} is successfully add in shopping cart');" class="btn btn-primary">Add to basket</a>
								</c:when>
								<c:when test="${productList.get(products).quantity <= 0}">
									<a>Sorry, but we haven't this model yet.</a>
								</c:when>
								</c:choose>
								
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<c:if test="${products % 3 == 0}">
				<div class="service service_left">
					<form action="" method="post">
						<center>
							<h2>${productList.get(products).name}</h2>
						</center>
						<a class="thumbnail" data-toggle="modal" data-target="#${products}"  ><img
							src="../../OnlineShop/images/${productList.get(products).name}.jpg"
							width="100px" height="66px" border="0" /><span><img
								src="../../OnlineShop/images/${productList.get(products).name}.jpg" />
								${productList.get(products).description}</span></a>
						<center>Click on the photo to see more information</center>
					</form>
				</div>
			</c:if>
			<c:if test="${products % 3 == 1}">
				<div class="service service_left">
					<form action="" method="post">
						<center>
							<h2>${productList.get(products).name}</h2>
						</center>
						<a class="thumbnail"
							 data-toggle="modal" id="openBtn" data-target="#${products}"  ><img
							src="../../OnlineShop/images/${productList.get(products).name}.jpg"
							width="100px" height="66px" border="0" /><span><img
								src="../../OnlineShop/images/${productList.get(products).name}.jpg" />
								${productList.get(products).description}</span></a>
							<center>Click on the photo to see more information</center>
					</form>
				</div>
			</c:if>
			<c:if test="${products % 3 == 2}">
				<div class="service service_left">
					<form action="" method="post">
						<center>
							<h2>${productList.get(products).name}</h2>
						</center>
						<a class="thumbnail"
							data-toggle="modal" id="openBtn" data-target="#${products}" ><img
							src="../../OnlineShop/images/${productList.get(products).name}.jpg"
							width="100px" height="66px" border="0" /><span><img
								src="../../OnlineShop/images/${productList.get(products).name}.jpg" />
								${productList.get(products).description}</span></a>
							<center>Click on the photo to see more information</center>
					</form>
				</div>
			</c:if>
		</c:forEach>
	</div>

	<jsp:include page="../../footer/footer.jsp" />
	</div>
</html>