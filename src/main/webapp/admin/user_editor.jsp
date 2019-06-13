<%@include file="../parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >
<div>
    <h2 class="text-center mb-4">User Editor</h2>
</div>
    <div class = "mt-2">
        <form action="${pageContext.request.contextPath}/admin/admin_base" method="post">
            <input type="hidden" name="userId" value="${editUser.getId()}" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group row">
                <label class ="col-sm-2" >Login</label>
                <div class = "col-sm-5">
                    <input type="text" class="form-control" name="newLogin" value="${editUser.getLogin()}">
                </div>
            </div>
            <div class = "form-group row">
                <label class ="col-sm-2" >Email</label>
                <div class = "col-sm-5">
                    <input type="text" class="form-control" name="newEmail" value="${editUser.getEmail()}">
                </div>
            </div>
            <c:forEach items="${roles}" var="role">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="newRole" id="exampleRadios1" value="${role}" <c:if test="${editUser.getRole() == role}">checked</c:if>>
                    <label class="form-check-label" >
                            ${role}
                    </label>
                </div>
            </c:forEach>
            <button type="submit" class="btn btn-primary">Edit</button>
        </form>
    </div>
</div>
