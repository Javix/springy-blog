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
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <h1>Post Details</h1>

        <label>${post.title}</label>

        <div class="row">
            <c:choose>
                <c:when test="${empty comments}">
                    <h3>There are no comments yet, Go ahead and create one !</h3></c:when>
                <c:otherwise>
                    <h3>Available comments</h3>

                    <div class="span8 offset2">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Comment</th>
                                <th>&nbsp;</th>
                                <th>&nbsp;</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${comments}" var="comment">
                                <tr>
                                    <td>${comment.text}</td>
                                    <td><a href="${post.id}/comments/${comment.id}/edit">Edit</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </c:otherwise>
            </c:choose>

            <p>
                <a href='<spring:url value="/posts" htmlEscape="true"/>'>Back to posts</a>
            </p>
        </div>
    </div>
</div>

</body>
</html>