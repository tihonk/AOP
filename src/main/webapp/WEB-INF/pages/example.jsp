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

    <title>Order</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3>Information about order:</h3>
    <h4>№: ${value}</h4>
    <h3 style="color: lime">${orderName}</h3>
    <br>
    This package will be sent from:
    <h4>${landlordAddress}</h4>
    To:
    <h4>${tenantAddress}</h4>
    <br><br>
    <h3>Status of this purchase:</h3>
    <h4> ${tenantStatus} ---> ${landlordStatus}  ${orderPayment}</h4>
    <br><br>
    <h4 style="color: red">Total price: ${orderPrice}$</h4>
    <br><br>
    <button><a href="/Deposit/order">Back</a> </button>



</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>