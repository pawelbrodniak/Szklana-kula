<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Szklana kula - klasyfikacja</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <aside class="categories">
        <%@ include file="../segments/barGroup.jspf" %>
    </aside>

    <main>
        <article >
            <h2>Klasyfikacja generalna graczy:</h2>
            <c:forEach var="classification" items="${requestScope.classifications}">
                <li><a>
                    <c:out value="${classification.name}"/> -> <c:out value="${classification.points}"/></a></li>
            </c:forEach>
        </article>
    </main>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>