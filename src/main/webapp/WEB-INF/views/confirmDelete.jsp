<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Szklana kula - reset</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form class="user-form">
        <h2 class="user-form-title">Czy na pewno chcesz zrestartować grę?</h2>
        <aside class="categories">
            <%@ include file="../segments/barConfirm.jspf" %>
        </aside>
    </form>
    <a href="${pageContext.request.contextPath}/group/addevent" class="discovery-add-button" title="Dodaj wydarzenie">
        <i class="fa fa-plus"></i>
    </a>
    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>