<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Project Manager Dashboard</title>
</head>
<body>
<div class="container">
    <h1>All Tables</h1> | <a href="/home">Home</a>
    <h3>Tables</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>Guest Name</th>
                    <th># Guest</th>
                    <th>Arrived at</th>
                    <th>Server</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${table}" var="tab">
                    <tr>
                        <td>${tab.name}</td>
                        <td>${tab.num_of_guest}</td>
                        <td>${tab.createdAt}</td>
                        <td>${tab.waiter.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
</div>
</body>
</html>


