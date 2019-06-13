<%@include file="../parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Test name</th>
                <th scope="col">Theme</th>
                <th scope="col">Questions</th>
                <th scope="col">Write</th>
                <th scope="col">Wrong</th>
                <th scope="col">Status</th>
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
