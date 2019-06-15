
<%@include file="./parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >

    <h3><fmt:message key="message.loginpage"/></h3>
    <c:if test="${loginError}">
        <div class="alert alert-danger col-sm-3" role="alert">
            <fmt:message key="message.invalidpassword"/>
        </div>
    </c:if>
    <c:if test="${doubleAuthError}">
        <div class="alert alert-danger col-sm-3" role="alert">
            <fmt:message key="message.alreadyauthorized"/>
        </div>
    </c:if>

    <div>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group row">
                <label class ="col-sm-2"><fmt:message key="message.login"/></label>
                <div class = "col-sm-5">
                    <input type="text" class="form-control" name="login" placeholder="<fmt:message key="message.enterlogin"/>">
                </div>
            </div>
            <div class = "form-group row">
                <label class ="col-sm-2" ><fmt:message key="message.password"/> </label>
                <div class = "col-sm-5">
                    <input type="password" class="form-control" name="password" placeholder="<fmt:message key="message.password"/>">
                </div>
            </div>
            <button type="submit" class="btn btn-primary"><fmt:message key="message.signin"/></button>
            <a href = "${pageContext.request.contextPath}/registrationFirst"><ins><fmt:message key="message.registration"/></ins></a>
        </form>
    </div>
</div>
