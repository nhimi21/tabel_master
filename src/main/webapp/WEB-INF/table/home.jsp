<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Project Manager Dashboard</title>
    <style>
        
    </style>
</head>
<body>
<div class="container">
   <h1 style="color: orange">Welcome back, <c:out value="${users.name}"/>.</h1><a href="/logout" style="float: right">Logout</a>
    <h3>Your Table</h3>
    <table class="table">
        <thead>
        <tr>
            <th>Guest Name</th>
            <th># Guest</th>
            <th>Arrived at</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users.table}" var="tab">
            <tr>
                <td>${tab.name}</td>
                <td>${tab.num_of_guest}</td>
                <td>${tab.createdAt}</td>
                <td><a href="/tables/${tab.id}/edit">finished</a> | <a href="/tables/${tab.id}/edit"> edit </a> | <a href="/givetable/${tab.id}"> Give Up Table </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <button type="button" class="btn btn-info"><a href="/tables/new" style="text-decoration: none; color: white">new table</a></button>
    <a href="/tables">See Other Tables</a>
</div>
</body>
</html>

