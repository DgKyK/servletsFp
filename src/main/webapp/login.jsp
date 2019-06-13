
<%@include file="./parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >

    <h3>Login page</h3>
    <c:if test="${loginError}">
        <div class="alert alert-danger col-sm-3" role="alert">
                ${rc.getMessage("message.invalidpassword")}
        </div>
    </c:if>
    <c:if test="${logoutError}">
        <div class="alert alert-success col-sm-3" role="alert">
                ${rc.getMessage("message.beenlogedout")}
        </div>
    </c:if>
</div>





<%--
<%@include file="./parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >

    <form method="post" action="${pageContext.request.contextPath}/login">
        <input type="text" name="login"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="Enter">
    </form>

</div>--%>
