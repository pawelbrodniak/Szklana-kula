<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Szklana kula - wyniki końcowe</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <aside class="categories">
        <%@ include file="../segments/barGroup.jspf" %>
    </aside>
    <aside class="categoriess">
        <h2>Kategorie</h2>
        <%@ include file="../segments/barCategory.jspf" %>
    </aside>

    <main>
        <h2>Dodawanie wyników końcowych:</h2>
        <%@ include file="../segments/eventFinallList.jspf" %>
        <a href="${pageContext.request.contextPath}/group/addevent" class="discovery-add-button">
            <i class="fa fa-plus"></i>
        </a>
    </main>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>