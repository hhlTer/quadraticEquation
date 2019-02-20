<%--
  Created by IntelliJ IDEA.
  User: valeriy
  Date: 2/18/19
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<script>--%>

// function InvalidMsg(textbox) {
//     if (textbox.value === '') {
//         textbox.setCustomValidity('Required value');
//     } else if (textbox.validity.typeMismatch){
//         textbox.setCustomValidity('Field should be contain only digits splitting by dot');
//     } else {
//         textbox.setCustomValidity('');
//     }
//
// return true;
// }
<%--</script>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quadratic Equation Calculate</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="w3-container w3-blue">
    <h2>Input values of A B C</h2>
</div>
<div class="w3-container" align="center">

<form action="/quadraticEquation_war/calculate" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin w3-center" style="width: 25%">
    <p>
        <label>Enter A</label>
        <input class="w3-input" name="valueA" type="text" required pattern="([0-9]+\.[0-9]+)|[1-9]|^[0-9][0-9]+|([-][0-9]+\.[0-9]+)|[-][0-9]+|[0-9]+|([0-9]+\.[0-9]+)" title="This field must contain only digits that are separated by a dot (For example: 5.2; 2; 0.33) and not contains zero 0"></p>
        <%--<input class="w3-input" name="variableA" type="text" required pattern="([0-9]+\.[0-9]+)|[1-9]|^[0-9][0-9]+" title="This field must contain only digits that are separated by a dot (For example: 5.2; 2; 0.33) and not contains zero 0"></p>--%>
    <p>
        <label>Enter B</label>
        <input class="w3-input" name="valueB" type="text" required pattern="([-][0-9]+\.[0-9]+)|[-][0-9]+|[0-9]+|([0-9]+\.[0-9]+)" title="The field must contain only digits that are separated by a dot (For example: 5.2; 2; 0.33)"></p>
    <p>
        <label>Enter C</label>
        <input class="w3-input" name="valueC" type="text" required pattern="([-][0-9]+\.[0-9]+)|[-][0-9]+|[0-9]+|([0-9]+\.[0-9]+)" title="The field must contain only digits that are separated by a dot (For example: 5.2; 2; 0.33)"></p>
    <p>
        <input class="w3-button" type="submit"/>
    </p>
</form>
</div>
</body>
</html>