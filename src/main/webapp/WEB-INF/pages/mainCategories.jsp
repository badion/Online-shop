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

<title>Main categories</title>
</head>
<body>
	<jsp:include page="../header/header.jsp"></jsp:include>
	<br>
	<div class="main_wraper">
	<div class="container">
	<jsp:include page="../header/message.jsp"></jsp:include>
		<c:if test="${groups.size() == null}"> 
		We don't have any group
		<br>
		</c:if>
		<c:forEach begin="0" end="${groups.size()-1}" var="groupsOfProduct">
			<c:if test="${groupsOfProduct % 3 == 0}">
			<div class="service service_left">
				<form action="" method="post">
							<center><h2>${groups.get(groupsOfProduct).name}</h2></center>
							<center><img src="../../OnlineShop/images/${groups.get(groupsOfProduct).name}.png" width="250" height="150"/></center>
							<center><a class="btn btn-success" href="contentFromCategory?name=${groups.get(groupsOfProduct).name}" type="button">Open ${groups.get(groupsOfProduct).name} catalog</a></center>
				</form>
			</div>
			</c:if>
			<c:if test="${groupsOfProduct % 3 == 1}">
			<div class="service service_left">
					<form action="" method="post">
							<center><h2>${groups.get(groupsOfProduct).name}</h2></center>
							<center><img src="../../OnlineShop/images/${groups.get(groupsOfProduct).name}.png"  width="250" height="150"/></center>
							<center><a class="btn btn-success" href="contentFromCategory?name=${groups.get(groupsOfProduct).name}" type="button">Open ${groups.get(groupsOfProduct).name} catalog</a></center>
				</form>
			</div>
			</c:if>
			<c:if test="${groupsOfProduct % 3 == 2}">
			<div class="service service_left">
					<form action="" method="post">
							<center><h2>${groups.get(groupsOfProduct).name}</h2></center>
							<center><img src="../../OnlineShop/images/${groups.get(groupsOfProduct).name}.png"  width="250" height="150"/></center>
							<center><a class="btn btn-success" href="contentFromCategory?name=${groups.get(groupsOfProduct).name}" type="button">Open ${groups.get(groupsOfProduct).name} catalog</a></center>
					</form>
			</div>
			</c:if>
		</c:forEach>
		</div>
		<jsp:include page="../footer/footer.jsp" />
		</div>
</html>