<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<jsp:include page="../shared/header.jsp"/>
<body>
<jsp:include page="../shared/navbar.jsp"/>

<div class="container">
    <div class="row">
        <h1>Post Details</h1>
        <label>${post.title}</label>

        <p>
            <a href='<spring:url value="/posts" htmlEscape="true"/>'>Back to list</a>
        </p>
    </div>

</div>

</body>
</html>