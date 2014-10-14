<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <link rel="icon" type="image/png" href="images/Shopping-Cart-32.png">

<style>

#myModalLabel {
color: #ffffff;
}
#myModalBody {
color: #ffffff;
}

.modal {
background: rgba(0, 0, 0, 0.7);
}
</style>

<script>
$(document).ready(function(){
  $("#clear").click(function(){
    $("#div1").remove();
  });
});
</script>


  <div class="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
  <br>
    <br>
    <br>
    <br>
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
    
    <h3 id="myModalLabel">Modal header</h3>
  </div>
  <div class="modal-body">
    <p id="myModalBody">One fine body</p>
    <p id="myModalBody">
    <%response.setIntHeader("Refresh", 2);%>
    <c:if test="${prevProduct.size() == null}">
			<p id="myModalBody">Your shopping cart is empty</p>    	
    	</c:if>
    	<div id="div1">
    	<table id="myModalBody" class="table table-hover">
    	<tr>
    		<th>ID</th>
    		<th>Name</th>
    		<th>Description</th>
    		<th>Price</th>
    	</tr>
    	<c:forEach items="${prevProduct}" var="products">
    	<tr>
    		<td>${products.idCheckoutProduct}</td>
    		<td>${products.name}</td>
    		<td>${products.description}</td>
    		<td>${products.price} $</td>
    		<td><a class="btn btn-primary" id="clear" href="clearCart?productId=${products.idProduct}&idChout=${products.idCheckoutProduct}&oid=${products.idCheckout}">Remove</a></td>
    	</tr>
 		   	
    	</c:forEach>
    	<td>Total sum: ${checkout.priceSum} $</td> 
    	</table>
    	</div>
    	
    	
    </p>
  </div>
 
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
    <button class="btn btn-primary">Save changes</button>
  </div>
</div> 


<div class="registration_login_form">
<c:choose>
<c:when  test='${customer == null}'>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
       <jsp:include page="message.jsp" />
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="home">Online-shop</a>
        </div>
        <div class="navbar-collapse collapse">
          <form name="Login form" action="authorization" method="post" class="navbar-form navbar-right" role="form">
            <div class="form-group">
              <input type="text" placeholder="Login" name="login" value="${session.login}" class="form-control">
              <c:remove var="session_login" scope="session"/>
            </div>
            <div class="form-group">
              <input type="password" name="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" name="authorization_button" class="btn btn-success">Sign in</button>
            <c:remove var="session_authorization_error_message" scope="session" />
			<a class="btn btn-info" type="button" href="registration">Registration</a>
			
          </form>
        </div>
      </div>
    </div>
    </c:when>
    <c:otherwise>
    Login message<c:out value="${customer.login}"></c:out>
      <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="home">Online-shop</a>
        </div>
        <div class="navbar-collapse collapse">
          <form name="Login form" action="authorization" method="post" class="navbar-form navbar-right" role="form">
            <button type="submit" name="log_out_button" class="btn btn-success">Logout</button>
        	<a data-toggle="modal" href="#myModal"> Cart()</a>
          </form>
          
<!-- 			User profile -->
        </div><!--/.navbar-collapse -->
      </div>
    </div>
		</c:otherwise>
    </c:choose>
    </div>