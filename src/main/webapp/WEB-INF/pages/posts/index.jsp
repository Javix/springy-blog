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
        <div class="span8 offset2">
            <c:if test="${!empty posts}">
                <h3>Posts</h3>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Post title</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${posts}" var="post">
                        <tr>
                            <td>${post.title}</td>
                            <td><a href="posts/${post.id}">Comments</a></td>
                            <td><a href="posts/edit/${post.id}">Edit</a></td>
                            <td>
                                <form:form action="posts/${post.id}" method="delete">
                                    <button type="submit" class="btn btn-xs btn-danger">Destroy</button>
                                </form:form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <a href='<spring:url value="/posts/new" htmlEscape="true"/>'>Add Post</a>
    </div>
</div>

</body>
</html>