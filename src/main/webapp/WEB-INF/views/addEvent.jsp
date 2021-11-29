<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Nowe wydarzenie</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form action="${pageContext.request.contextPath}/group/addevent" method="post" class="user-form">
        <h2 class="user-form-title">Dodaj nowe wydarzenie sportowe</h2>
        <input name="teamA" placeholder="Nazwa drużyny A" required>
        <input name="teamB" placeholder="Nazwa drużyny B"  required>
        <select name="categoryId">
            <c:forEach var="category" items="${requestScope.categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <h2 class="user-form-title">Współczynnik (opcjonalny)</h2>
        <select name="rate">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>
        <button class="user-form-button">Dodaj wydarzenie</button>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>