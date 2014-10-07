<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
          </form>
<!-- 			User profile -->
        </div><!--/.navbar-collapse -->
      </div>
    </div>
		</c:otherwise>
    </c:choose>
    </div>