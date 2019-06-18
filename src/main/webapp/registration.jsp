<%@include file="./parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >
    <div class = "mb-5">
        <h2><fmt:message key="message.registration"/></h2>
    </div>
    <c:if test="${userExistError}">
    <div class="alert alert-danger col-sm-4" role="alert">
        <fmt:message key="message.exist"/>
    </div>
    </c:if>
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <div class="form-group row">
            <label class ="col-sm-2" ><fmt:message key="message.login"/> </label>
            <div class = "col-sm-5">
                <input type="text"
                       class="form-control <c:if test="${loginRegisterError}">is-invalid</c:if>"
                       name="login"
                       placeholder="<fmt:message key="message.enterlogin"/>">
                <c:if test="${loginRegisterError}">
                <div class = "invalid-feedback">
                    <fmt:message key="message.loginrules"/>
                </div>
                </c:if>
            </div>
        </div>
        <div class = "form-group row">
            <label class ="col-sm-2" ><fmt:message key="message.password"/> </label>
            <div class = "col-sm-5">
                <input type="password" class="form-control <c:if test="${passwordRegisterError}">is-invalid</c:if>" name="password"
                       placeholder="<fmt:message key="message.password"/>">
                <c:if test="${passwordRegisterError}">
                    <div class = "invalid-feedback">
                        <fmt:message key="message.passwordbigger"/>
                    </div>
                </c:if>
            </div>
        </div>
        <div class = "form-group row">
            <label class ="col-sm-2"><fmt:message key="message.email"/></label>
            <div class = "col-sm-5">
                <input type="text" class="form-control <c:if test="${emailRegisterError}">is-invalid</c:if>"
                       name="email" placeholder="<fmt:message key="message.email"/>">
                <c:if test="${emailRegisterError}">
                    <div class = "invalid-feedback">
                        <fmt:message key="message.emailcorrect"/>
                    </div>
                </c:if>
            </div>
        </div>
        <button type="submit" class="btn btn-primary"><fmt:message key="message.register"/></button>
    </form>
</div>
