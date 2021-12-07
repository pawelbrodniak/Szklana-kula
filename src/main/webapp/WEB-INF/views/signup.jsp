<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Szklana kula - rejestracja</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/xxx.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form action="${pageContext.request.contextPath}/signup" method="post" class="user-form">
        <h2 class="user-form-title">Zarejestruj się do Szklanej kuli</h2>
        <input name="username" placeholder="Nazwa użytkownika" required>
        <input name="email" placeholder="Adres e-mail (xyz@example.com)" type="email"  required>
        <input name="password" placeholder="Hasło" type="password" required>
        <button class="user-form-button">Zarejestruj się</button>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>