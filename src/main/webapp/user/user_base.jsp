<%@include file="../parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >
    <div>
        <h2> <fmt:message key="message.hello"/> ${user.getLogin()}</h2>
    </div>
    <div >
        <Strong><fmt:message key="message.choosetest"/></Strong>
    </div>

    <form action="${pageContext.request.contextPath}/user/test" method="post" name="test">
        <div>
            <select class="custom-select col-sm-5 mt-2" name="chosenTest">
                <c:forEach items="${allTests}" var="test">
                    <option>
                        <div>
                            <b>${test.getId()}</b>
                            <strong>|</strong>
                            <span>${test.getName()}</span>
                            <strong>|</strong>
                            <i>${test.getTheme()}</i>
                        </div>
                    </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary mt-2"><fmt:message key="message.passtest"/></button>
    </form>
</div>
