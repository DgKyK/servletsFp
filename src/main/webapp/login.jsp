
<%@include file="./parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >

    <h3>Login page</h3>
    <c:if test="${loginError}">
        <div class="alert alert-danger col-sm-3" role="alert">
            Invalid password or login
        </div>
    </c:if>
    <%--<c:if test="${logout}">
        <div class="alert alert-success col-sm-3" role="alert">
            You have been logged out
        </div>
    </c:if>--%>
    <div>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group row">
                <label class ="col-sm-2">Login </label>
                <div class = "col-sm-5">
                    <input type="text" class="form-control" name="login" placeholder="Enter login">
                </div>
            </div>
            <div class = "form-group row">
                <label class ="col-sm-2" >Password </label>
                <div class = "col-sm-5">
                    <input type="password" class="form-control" name="password" placeholder="Password">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
            <a href = "/registration"><ins>Registration</ins></a>
        </form>
    </div>
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
