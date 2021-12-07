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
        <c:if test="${not empty requestScope.classifications}">
            <section class = table>
                <h2>Klasyfikacja generalna graczy:</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Nazwa użytkownika</th>
                        <th>Punkty</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="classification" items="${requestScope.classifications}">
                        <tr>
                            <td><c:out value="${classification.name}"/></td>
                            <td>${classification.points}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </section>
        </c:if>
    </main>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>