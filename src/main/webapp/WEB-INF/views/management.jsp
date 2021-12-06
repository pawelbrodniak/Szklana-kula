<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Szklana kula - zarządzanie grą</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <aside class="categories">
        <%@ include file="../segments/barManagement.jspf" %>
    </aside>

    <main>
        <article >
            <h2>Zasady gry:</h2>
            <p>Najważniejsza jest uczciwość graczy!</p>
        </article>
    </main>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>