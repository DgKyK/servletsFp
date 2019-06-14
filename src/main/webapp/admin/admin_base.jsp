<%@include file="../parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >

    <h2><fmt:message key="message.helloadmin"/></h2>
    <p>
        <a class="btn btn-primary"
           data-toggle="collapse"
           href="#multiCollapseExample1"
           role="button" aria-expanded="false" aria-controls="multiCollapseExample1"><fmt:message key="message.userslist"/></a>
    </p>
    <div class="row">
        <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample1">
                <div class="list-group col-sm-5">
                    <form method="post" action="${pageContext.request.contextPath}/admin/user_editor">
                    <c:forEach items="${allUsers}" var="usr">
                        <button type="submit"
                                class="list-group-item list-group-item-action"
                                value="${usr.getId()}" name="userId">${usr.getLogin()}</button>
                    </c:forEach>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
