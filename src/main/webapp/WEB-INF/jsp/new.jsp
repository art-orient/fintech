<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Регистрация</title>
</head>

<body>
<div>
  <form:form method="POST" modelAttribute="userForm">
    <h2>Регистрация</h2>
    <div>
      <form:input type="text" path="username" placeholder="Username"
                  autofocus="true"></form:input>
      <form:errors path="username"></form:errors>
        ${usernameError}
    </div>
    <div>
      <form:input type="password" path="password" placeholder="Password"></form:input>
    </div>
    <div>
      <form:input type="password" path="passwordConfirm"
                  placeholder="Confirm your password"></form:input>
      <form:errors path="password"></form:errors>
        ${passwordError}
    </div>
    <div>
      <form:input type="text" path="firstName" placeholder="First name"></form:input>
    </div>
    <div>
      <form:input type="text" path="lastName" placeholder="Last name"></form:input>
    </div>
    <br><button type="submit">Зарегистрироваться</button><br><br>
  </form:form>
  <a href="/">Главная</a>
</div>
</body>
</html>