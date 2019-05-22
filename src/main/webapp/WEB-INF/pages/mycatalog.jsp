<%--
  Created by IntelliJ IDEA.
  User: t.kasko
  Date: 14.2.19
  Time: 18.47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" --%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Hello Spring MVC</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <h2>Name: ${name}</h2>
    <table>
        <c:forEach var= "value" items="${values}">
        <tr>
            <td>id: ${value.id}  <button type=“submit”><a href="/Deposit/${name}/${value.id}">Show more</a> </button></td>
        </tr>
        </c:forEach>
    </table>

    <h3 style="color:#00ff00">${value} </h3>
    ${paramm}
    <br>
    ${paramm2}
    <h4>${paramm3} ${paramm4} ${paramm5}</h4>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
