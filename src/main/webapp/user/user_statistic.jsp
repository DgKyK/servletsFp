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
    <nav aria-label="Navigation for success">
        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/user/user_statistic?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li class="page-item active"><a class="page-link">
                                ${i} <span class="sr-only">(current)</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}/user/user_statistic?recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/user/user_statistic?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>


</div>
