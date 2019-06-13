<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 26.05.2019
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@include file="./parts/imports.jsp"%>
<jsp:include page="/parts/common.jsp"/>
<div class="container mt-5 mb-5" >

    <form method="post" action="${pageContext.request.contextPath}/login">
        <input type="text" name="login"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="Enter">
    </form>

</div>