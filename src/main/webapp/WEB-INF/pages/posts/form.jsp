<!doctype html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Spring MVC Blog | Post</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Latest compiled and minified JavaScript -->
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>

<body>
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