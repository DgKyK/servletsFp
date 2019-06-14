<%@ include file="imports.jsp"%>
<!doctype html>
<html lang="${locale}">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>FTS</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand"
            <c:choose>
                <c:when test="${user.isAdmin() || user.isUser()}">
                    href="#"
                </c:when>
                <c:otherwise>
                    href="${pageContext.request.contextPath}"
                </c:otherwise>
            </c:choose>>FTS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:if test="${user.isAdmin() || user.isUser()}">
                <li class="nav-item active">
                    <a class="nav-link"
                            <c:choose>
                                <c:when test="${user.isAdmin()}">
                                    href="${pageContext.request.contextPath}/admin/admin_base"
                                </c:when>
                                <c:when test="${user.isUser()}">
                                    href="${pageContext.request.contextPath}/user/user_base"
                                </c:when>
                            </c:choose>><fmt:message key="message.home"/><span class="sr-only">(current)</span></a>
                </li>
            </c:if>
            <c:if test="${user.isUser()}">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/user/user_statistic?currentPage=1"><fmt:message key="message.mystatistic"/><span class="sr-only">(current)</span></a>
                </li>
            </c:if>
            <c:if test="${user.isAdmin()}">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/admin_statistic"><fmt:message key="message.usersstatistic"/><span class="sr-only">(current)</span></a>
                </li>
            </c:if>
        </ul>
    </div>
    <div class = "mr-2">
        <select id="locales" class="form-control" style="width: 125px;">
            <option value=""><fmt:message key="message.language"/></option>
            <option value="US">EN</option>
            <option value="UA">UA</option>
        </select>
    </div>
    <div class = "navbar-text mr-2">${user.getLogin()}</div>
        <c:if test="${user.isAdmin() || user.isUser()}">
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <%--<input type="hidden" name="_csrf" value="${_csrf.token}" />--%>
                <button type="submit" class="btn btn-primary"><fmt:message key="message.loguot"/></button>
            </form>
        </c:if>
</nav>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#locales").change(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption != ''){
                window.location.replace(window.location.origin + window.location.pathname + '?sessionLocale=' + selectedOption);
            }
        });
    });
</script>