<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <meta charset="UTF-8">
  <title>Project Manager</title>
  <style>
    .container h1{
      text-align: center;
      color: orange;
    }
    .box{
      display: flex;
      justify-content: space-around;
      align-items: center;
    }
    input{
      margin: 7px;
    }
    .form-control{
      border: 1px solid black;
    }
    .btn{
      border-radius: 10px;
      width: 100%;
    }
    .box-2 p{
      color: red;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>TableMaster</h1>
  <div class="box">
    <div class="box-1">
      <h2>New Waitstaff</h2>
      <form:form method="POST" action="/register" modelAttribute="user">
        <table>
          <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td>
              <form:input type="text" path="name" class="form-control" placeholder="Enter full name.."/>
              <form:errors path="name" cssStyle="color: red"/>
            </td>
          </tr>
          <tr>
            <td><form:label path="email">Email:</form:label></td>
            <td>
              <form:input type="email" path="email" class="form-control" placeholder="Enter email.."/>
              <form:errors path="email" cssStyle="color: red"/>
            </td>
          </tr>
          <tr>
            <td><form:label path="password">Password:</form:label></td>
            <td>
              <form:password path="password" class="form-control" placeholder="Enter password.."/>
              <form:errors path="password" cssStyle="color: red"/>
            </td>
          </tr>
          <tr>
            <td><form:label path="confirmPassword">Confirm Password:</form:label></td>
            <td>
              <form:password path="confirmPassword" class="form-control" placeholder="Again password.."/>
              <form:errors path="confirmPassword" cssStyle="color: red"/>
            </td>
          </tr>
          <tr>
            <td></td>
            <td><input type="submit" class="btn btn-primary" value="Register"/></td>
          </tr>
        </table>
      </form:form>
    </div>
    <div class="box-2">
      <h2>Log In</h2>
      <p><c:out value="${loginError}"/></p>
      <form method="post" action="/login">
        <table>
          <tr>
            <td><label for="email">Email</label></td>
            <td><input type="text" id="email" name="email" class="form-control" placeholder="email"/></td>
          </tr>
          <tr>
            <td><label for="password">Password</label></td>
            <td><input type="password" id="password" name="password" class="form-control" placeholder="password"/></td>
          </tr>
          <tr>
            <td></td>
            <td><input type="submit" class="btn btn-primary" value="Log In"/></td>
          </tr>
        </table>
      </form>
    </div>
  </div>

</div>
</body>
</html>
