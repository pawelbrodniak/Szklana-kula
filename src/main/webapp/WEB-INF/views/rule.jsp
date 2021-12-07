<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Szklana kula - zasady gry</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/xxx.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <aside class="categories">
        <%@ include file="../segments/barGroup.jspf" %>
    </aside>

    <main>
        <article >
            <h2>Zasady gry:</h2>
            <ul>
                <li>Szklana kula to gra typu "typer" o charakterze rozrywkowym</li>
                <li>Szklana kula nie jest grą hazadrową</li>
                <li>Gra polega na prawidłowym typowaniu zwycięsców (lub remisu) wydarzeń sportowych </li>
                <li>Gracz ma możliwość typowania wydarzenia sportowego do momentu, gdy administrator doda wynik końcowy danego wydarzenia</li>
                <li>Za każdy prawidłowy typ gracz otrzymuje punkty wyliczane za pomocą wzoru: 1 * współczynnik</li>
                <li>Punkty zdobyte przez danego gracza są sumowane, w celu stworzenia klasyfikacji graczy</li>
                <li>Nie ma punktów ujemnych</li>
                <li>Zwycięscą jest gracz, który w momencie wyznaczonym przez administratora posiada największą liczbę punktów</li>
                <li>Gra toczy się do momentu wyznaczonego przez administratora</li>
            </ul>
        </article>
    </main>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>