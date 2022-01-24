<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>New Table</title>
</head>
<body>
<div class="container">
    <span style="font-size: 25px; color: orange">New Table </span> | <a href="/logout">LogOut</a>
    <br>
    <form:form method="POST" action="/tables/new" modelAttribute="master">
        <p>
            <form:label path="name">Guest Name:</form:label>
            <form:input type="text" path="name"/>
            <form:errors path="name" cssStyle="color: red"/>
        </p>
        <p>
            <form:label path="num_of_guest">Num of Guests:</form:label>
            <form:input type="number" path="num_of_guest"/>
            <form:errors path="num_of_guest" cssStyle="color: red"/>
        </p>
        <p>
            <form:label path="note">Notes:</form:label>
            <form:textarea type="text" path="note"/>
            <form:errors path="note" cssStyle="color: red"/>
        </p>
        <form:input path="waiter" type="hidden" value="${userID}"/>
        <input type="submit" class="btn btn-info" value="Submit" />
        <a href="/home">Cancel</a>
    </form:form>
</div>
</body>
</html>