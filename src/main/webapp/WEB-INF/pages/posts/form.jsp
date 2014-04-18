<!doctype html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <form:form modelAttribute="post" method="${method}" class="form-horizontal" id="add-post-form" role="form">
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <form:errors path="*" cssClass="alert alert-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Title*</label>

                <div class="col-sm-10">
                    <form:input path="title" maxlength="100"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${post['new']}">
                            <button type="submit" class="btn btn-primary">Add post</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-primary">Update post</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
        <a href='<spring:url value="/posts" htmlEscape="true"/>'>Back to list</a>
    </div>
</div>
</body>