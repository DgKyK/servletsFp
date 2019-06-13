<%@include file="../parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Login</th>
            <th scope="col">Tests</th>
            <th scope="col">Passed</th>
            <th scope="col">Failed</th>
            <th scope="col">Activity</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${generalStatistic}" var="stat">
        <tr>
            <th scope="row">${stat.getLogin()}</th>
            <td>${stat.getTests()}</td>
            <td>${stat.getPassed()}</td>
            <td>${stat.getFailed()}</td>
            <td>${stat.getActivity()}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>







<%--<html>
<head>
    <title>Admin statistic</title>
</head>
<body>
    <h2>Admin stat</h2><br>
    <h3><a href="${pageContext.request.contextPath}/admin/admin_base">go to admin main page</a></h3>
</body>
</html>--%>
