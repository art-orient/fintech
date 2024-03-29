<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Log in with your account</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
  <table>
    <thead>
    <th>ID</th>
    <th>UserName</th>
    <th>Roles</th>
    <th>FirstName</th>
    <th>LastName</th>
    <th>Status</th>
    <th>Created At</th>
    </thead>
    <c:forEach items="${allUsers}" var="user">
      <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.username}"/></td>
        <td>
          <c:forEach items="${user.roles}" var="role"><c:out value="${role.name}"/> </c:forEach>
        </td>
        <td><c:out value="${user.firstName}"/></td>
        <td><c:out value="${user.lastName}"/></td>
        <td><c:out value="${user.status}"/></td>
        <td><c:out value="${user.createdAt}"/></td>
        <td>
          <form action="${pageContext.request.contextPath}/admin" method="post">
            <input type="hidden" name="userId" value="${user.id}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit">Delete</button>
          </form>

        </td>

      </tr>
    </c:forEach>
  </table>
  <h4><a href="/">Главная</a></h4>
  <sec:authorize access="isAuthenticated()">
    <h4><a href="/logout">Выйти</a></h4>
  </sec:authorize>
</div>
</body>
</html>