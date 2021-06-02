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
  <form:form method="POST" modelAttribute="editUser">
    <h2>Редактирование пользователя</h2>
    <div>
      Пользователь - ${editUser.username}
<%--      <form:input type="text" path="username" placeholder="Username"--%>
<%--                  autofocus="true"></form:input>--%>
<%--      <form:errors path="username"></form:errors>--%>
<%--        ${usernameError}--%>
    </div>
    <div>
      <form:input type="password" path="password" placeholder="New password"></form:input>
    </div>
    <div>
      <form:input type="password" path="passwordConfirm"
                  placeholder="Confirm new password"></form:input>
      <form:errors path="password"></form:errors>
        ${passwordError}
    </div>
    <br><button type="submit">Редактировать</button><br><br>
  </form:form>
  <a href="/">Главная</a>
</div>
</body>
</html>