<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
setTimeout(function() {
	$('#alert').fadeOut('fast');
}, 3000);
</script>

 <c:choose> 
<c:when test='${msg != null}'> 
 		<div class="alert alert-${msg.type}" id="alert" role="alert"> 
 			<strong>${msg.main}</strong>${msg.context}</div>
 	</c:when> 
 </c:choose> 
 
 <c:choose>
 	<c:when test='${sms1!=null}'>
 		<div class="alert alert-${sms1}" role="alert">
 			<strong>${sms1}</strong>
 		</div>
 	</c:when>
 </c:choose>
 
 	
 