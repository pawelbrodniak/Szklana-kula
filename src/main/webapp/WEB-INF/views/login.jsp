<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Szklana kula - logowanie</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/headerLogin.jspf" %>

    <form action="j_security_check" method="post" class="user-form">
        <h2 class="user-form-title">Zaloguj się do Szklanej kuli</h2>
        <input name="j_username" placeholder="Nazwa użytkownika" required>
        <input name="j_password" placeholder="Hasło" type="password" required>
        <button class="user-form-button">Zaloguj się</button>
        <p>Nie masz konta? <a href="${pageContext.request.contextPath}/signup">Zarejestruj się</a></p>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>