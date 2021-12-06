<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Reset - potwierdzenie</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form class="user-form">
        <h2 class="user-form-title">Czy na pewno chcesz zrestartować grę?</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/deleteall">Tak, usuń wszystko</a></li>
            <li><a href="${pageContext.request.contextPath}/delete">Tak, usuń wydarzenia i typy</a></li>
            <li><a href="${pageContext.request.contextPath}/">Nie</a></li>
        </ul>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>