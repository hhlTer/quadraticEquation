<%--
  Created by IntelliJ IDEA.
  User: valeriy
  Date: 2/18/19
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quadratic Equation Calculate</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<script>
    function loadResult() {

        console.log("Entered to function");
        var valA = document.getElementById("valueA").value;
        var valB = document.getElementById("valueB").value;
        var valC = document.getElementById("valueC").value;

        var body = 'valueA=' + valA +
                '&valueB=' + valB +
                '&valueC=' + valC;

        var myRequest = new XMLHttpRequest();

        myRequest.open('GET', '/quadraticEquation_war/calculate?'+body, true);

        myRequest.onreadystatechange = function (ev) {
            console.log("onreadystate");
            if (myRequest.readyState === 4){
                alert(myRequest.responseText);
            }
        };

        myRequest.send(body);


    }
</script>
<body>
<div class="w3-container w3-blue">
    <h2>Input values of A B C</h2>
</div>

<div class="w3-container" align="center">

<form id="formsubmit" action="/quadraticEquation_war/calculate" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin w3-center" style="width: 25%">
    <p>
        <label>Enter A</label>
        <input class="w3-input" name="valueA" id="valueA" type="text" required pattern="([0-9]+\.[0-9]+)|[1-9]|^[0-9][0-9]+|([-][0-9]+\.[0-9]+)|[-][0-9]+|[0-9]+|([0-9]+\.[0-9]+)" title="This field must contain only digits that are separated by a dot (For example: 5.2; 2; 0.33) and not contains zero 0"></p>
        <%--<input class="w3-input" name="variableA" type="text" required pattern="([0-9]+\.[0-9]+)|[1-9]|^[0-9][0-9]+" title="This field must contain only digits that are separated by a dot (For example: 5.2; 2; 0.33) and not contains zero 0"></p>--%>
    <p>
        <label>Enter B</label>
        <input class="w3-input" name="valueB" id="valueB" type="text" required pattern="([-][0-9]+\.[0-9]+)|[-][0-9]+|[0-9]+|([0-9]+\.[0-9]+)" title="The field must contain only digits that are separated by a dot (For example: 5.2; 2; 0.33)"></p>
    <p>
        <label>Enter C</label>
        <input class="w3-input" name="valueC" id="valueC" type="text" required pattern="([-][0-9]+\.[0-9]+)|[-][0-9]+|[0-9]+|([0-9]+\.[0-9]+)" title="The field must contain only digits that are separated by a dot (For example: 5.2; 2; 0.33)"></p>
    <p>
        <input class="w3-button" type="button" onclick="loadResult()" value="Submit query"/>
        <%--<input class="w3-button" type="submit" onclick="loadResult()"/>--%>
    </p>
</form>
</div>
</body>
</html>