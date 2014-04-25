<!doctype html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<jsp:include page="../shared/header.jsp"/>
<body>
<jsp:include page="../shared/navbar.jsp"/>
<div class="container">
    <c:choose>
        <c:when test="${post['new']}"><c:set var="method" value="post"/></c:when>
        <c:otherwise><c:set var="method" value="put"/></c:otherwise>
    </c:choose>
    <div class="row">
        <h2>
            <c:choose>
                <c:when test="${post['new']}">Create Post</c:when>
                <c:otherwise>Update Post</c:otherwise>
            </c:choose>
        </h2>
        <form:form modelAttribute="post" method="${method}" id="post_${post.id}_form" role="form">
            <t:input path="title" required="true"/>

            <c:choose>
                <c:when test="${post['new']}">
                    <button type="submit" class="btn btn-primary">Add post</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="btn btn-primary">Update post</button>
                </c:otherwise>
            </c:choose>


        </form:form><br/>
        <a href='<spring:url value="/posts" htmlEscape="true"/>'>Back to list</a>
    </div>
</div>
</body>