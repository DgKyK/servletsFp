<%@include file="../parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col"><fmt:message key="message.testname"/></th>
                <th scope="col"><fmt:message key="message.theme"/></th>
                <th scope="col"><fmt:message key="message.questions"/></th>
                <th scope="col"><fmt:message key="message.write"/></th>
                <th scope="col"><fmt:message key="message.wrong"/></th>
                <th scope="col"><fmt:message key="message.status"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${success}" var="ss">
            <tr>
                <th scope="row">${ss.getTest().getName()}</th>
                <td>${ss.getTest().getTheme()}</td>
                <td>${ss.getQuestNumber()}</td>
                <td>${ss.getWriteAnswer()}</td>
                <td>${ss.getWrongAnswer()}</td>
                <td>${ss.getStatus()}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</div>
