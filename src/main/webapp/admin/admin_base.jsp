<%@include file="../parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >

    <h2>Hello ADMIN</h2>
    <p>
        <a class="btn btn-primary"
           data-toggle="collapse"
           href="#multiCollapseExample1"
           role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Users list</a>
    </p>
    <div class="row">
        <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample1">
                <div class="list-group col-sm-5">
                    <c:forEach items="${allUsers}" var="usr">
                        <a href="/admin/admin/${usr.getId()}" class="list-group-item list-group-item-action">${usr.getLogin()}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<html>
<head>
    <title>AdminBase</title>
</head>
<body>
<h1><b>Admin main page</b></h1>
<br>
<h3><a href="${pageContext.request.contextPath}/admin_statistic">Admin statistic</a></h3>
<h3><a href="${pageContext.request.contextPath}/logout">LOG_OUT</a></h3>

</body>
</html>--%>
