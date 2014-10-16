<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" href="images/Shopping-Cart-32.png">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/styleGroup.css" />
<!-- <link rel="stylesheet" type="text/css" href="css/style.css" /> -->


<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/additional-methods.js"></script>
<script type="text/javascript" src="js/registration.js"></script> 
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<style>
.jumbotron {
background-color: white;
}

</style>
    <title>Online-shop home page</title>
  </head>
  <body>
   	 <jsp:include page="../header/header.jsp"></jsp:include>
  <div class="main_wraper">
    <div class="jumbotron">
      <div class="container">
      
       	<img src="../OnlineShop/images/sale.jpg"/>
      	<p> Looking for top brand smartphones(Apple, HTC, Samsung, Nokia), or something else?</p>
        <p> and more are here...</p>
        <p><a class="btn btn-primary btn-lg" role="button" href="mainCategories">Shop now&raquo;</a></p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Laptops</h2>
          <img src="../OnlineShop/images/Laptops.png" width="220px" height="150px"/>
          <p><a class="btn btn-default" href="http://localhost:8080/OnlineShop/contentFromCategory?name=Laptops" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Phones</h2>
            <img src="../OnlineShop/images/Phones.png" width="220px" height="150px"/>
          <p><a class="btn btn-default" href="http://localhost:8080/OnlineShop/contentFromCategory?name=Phones" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Tablets</h2>
             <img src="../OnlineShop/images/Tablets.png" width="220px" height="150px"/>
          <p><a class="btn btn-default" href="http://localhost:8080/OnlineShop/contentFromCategory?name=Tablets" role="button">View details &raquo;</a></p>
        </div>
      </div>

    
     <jsp:include page="../footer/footer.jsp"/>
     
    </div> <!-- /container -->
</div>

  </body>
</html>
