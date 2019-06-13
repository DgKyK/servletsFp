<%@include file="../parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>

<div class="container mt-5 mb-5">

    <h2> Hello from test  </h2>
    <c:forEach items="${checkedTest}" var="answ">
        <c:choose>
            <c:when test="${answ.value}">
                <div class="alert alert-success w-25 p-3" role="alert">
                        ${answ.key}
                </div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger w-25 p-3" role="alert">
                        ${answ.key}
                </div>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <div >
        <a href="${pageContext.request.contextPath}/user/user_base" type="button" class="btn btn-primary btn-lg">Thanks</a>
    </div>
</div>

