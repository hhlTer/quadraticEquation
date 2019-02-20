<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quadratic Equation Calculate</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<label th:text="${rationalValueA.whole}"></label>
<form:form modelAttribute="test2">
        <form:label path="whole"></form:label>
</form:form>
<label>${test}</label>
<label>${test2.whole} ${test2.numerator}/${test2.denominator}</label>
<label>${test2.doubleValue}</label>
</body>