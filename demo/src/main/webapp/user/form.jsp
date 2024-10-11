<%--
  Created by IntelliJ IDEA.
  User: cksdn
  Date: 24. 10. 11.
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h2>${user == null ? "new user" : "edit user"}</h2>
<%--user가 null이 아니면 --%>
    <form action="${user == null ? 'insert': 'update'}" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <input type="text" name="name" value="${user.name}">
        <br>
        <input type="text" name="email" value="${user.email}">
        <br>
        <input type="text" name="country" value="${user.country}">
        <br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
