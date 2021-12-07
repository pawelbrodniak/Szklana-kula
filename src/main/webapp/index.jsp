<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Szklana kula - strona główna</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>
<body>
<div class="container">
    <%@ include file="./WEB-INF/segments/header.jspf" %>

    <aside class="categories">
        <%@ include file="./WEB-INF/segments/barGroup.jspf" %>
    </aside>
    <aside class="categoriess">
        <h2>Kategorie</h2>
        <%@ include file="./WEB-INF/segments/barCategory.jspf" %>
    </aside>

    <main>
        <h2>Dostępne wydarzenia sportowe do typowania:</h2>
        <%@ include file="./WEB-INF/segments/eventList.jspf" %>
    </main>
    <%@ include file="./WEB-INF/segments/footer.jspf" %>
</div>
</body>
</html>