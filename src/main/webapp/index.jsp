
<%@include file="./parts/imports.jsp"%>
<jsp:include page="parts/common.jsp"/>
<div class="container mt-5 mb-5" >
    <div class="mt-10">
        <h2 class="text-center"><fmt:message key="message.welcome"/></h2>

        <h3 class="text-center"><fmt:message key="message.continue"/></h3>
        <h3 class="text-center">
            <a href="${pageContext.request.contextPath}/loginFirst"><fmt:message key="message.signin"/></a> or <a href="${pageContext.request.contextPath}/registrationFirst"><fmt:message key="message.register"/></a></h3>
    </div>
</div>