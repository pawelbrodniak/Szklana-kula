<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Szklana kula - zarządzanie grą</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/xxx.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <aside class="categories">
        <%@ include file="../segments/barManagement.jspf" %>
    </aside>

    <main>
        <article >
            <h2>Przypomnienie najważniejszych obowiązków administratora:</h2>
            <ul>
                <li>Administrator zobowiązany jest dodawać nowe wydarzenia sportowe</li>
                <li>Administrator powinien niezłoczni po zakończonym wydarzeniu sportowym dodać jego wynik końocwy</li>
                <li>W razie pomyłki administrator ma możliwość zmiany wyniku końcowego wydarzenia sportowego</li>
                <li>Administrator ma możliwość zresetowania całej rozgrywki</li>
                <li>Administrator nie jest graczem - nie ma możliwości typowania wyników wydarzeń sportowych</li>
            </ul>
        </article>
        <a href="${pageContext.request.contextPath}/group/addevent" class="discovery-add-button">
            <i class="fa fa-plus"></i>
        </a>
    </main>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>