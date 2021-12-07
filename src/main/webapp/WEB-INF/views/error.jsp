<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Szklana kula - brak uprawnień</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>



    <main>
        <article >
            <h2>Brak uprawnień</h2>
            <a href="${pageContext.request.contextPath}/" > Przejdź do strony głównej </a>
        </article>
    </main>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>