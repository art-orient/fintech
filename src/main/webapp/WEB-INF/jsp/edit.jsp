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
      Пользователь - <c:out value="${editUser.username}"/>
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
    <div>
      <form:input type="text" path="firstName" placeholder="firstName"></form:input>
    </div>
    <div>
      <form:input type="text" path="lastName" placeholder="lastName"></form:input>
    </div>
    <div>
      <form action="status">
      <select>
        <option value="ACTIVE">ACTIVE</option>
        <option value="INACTIVE">INACTIVE</option>
      </select>
      </form>
    </div>
    <div>
      <form action="role">
        <select>
          <option value="ROLE_USER;">USER</option>
          <option value="ROLE_ADMIN;">ADMIN</option>
        </select>
      </form>
    </div>
    <br><button type="submit">Редактировать</button><br><br>
  </form:form>
  <a href="/">Главная</a>
</div>
</body>
</html>