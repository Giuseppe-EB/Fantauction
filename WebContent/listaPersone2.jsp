<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  
</head>

<body>

        CCCCCCCCCCCCCCCweFD3WCCCCCcc
        <c:forEach var="persone" items="${persone}">
      	 	<div class="post-preview">
      	 	${persone}       		
      		</div>
      	 	 <hr>
      	 </c:forEach>
</body>
	
</html>