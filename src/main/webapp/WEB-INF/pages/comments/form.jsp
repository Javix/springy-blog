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
        <c:when test="${comment['new']}"><c:set var="method" value="comment"/></c:when>
        <c:otherwise><c:set var="method" value="put"/></c:otherwise>
    </c:choose>
    <div class="row">
        <h2>
            <c:choose>
                <c:when test="${comment['new']}">Create Comment</c:when>
                <c:otherwise>Update Comment</c:otherwise>
            </c:choose>
        </h2>
        <form:form modelAttribute="comment" method="${method}" id="comment_form" role="form">
            <t:input path="text" required="true"/>

            <c:choose>
                <c:when test="${comment['new']}">
                    <button type="submit" class="btn btn-primary">Add comment</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="btn btn-primary">Update comment</button>
                </c:otherwise>
            </c:choose>


        </form:form><br/>
        <a href='<spring:url value="/posts/${comment.post.id}" htmlEscape="true"/>'>Back to Post</a>
    </div>
</div>
</body>