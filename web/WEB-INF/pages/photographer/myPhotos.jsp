<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Tensa
  Date: 09.02.2016
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../template/header.jsp"/>
<html>
<head>
    <title>myPhotos</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/blueimp-gallery.css"/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/resources/css/blueimp-gallery-indicator.css"/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/resources/css/myPhoto-gallery.css"/>" type="text/css" />
</head>
<body>
<div class="section section-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1><spring:message code ="myPhoto.MyPhoto"/></h1>
            </div>
        </div>
    </div>
</div>

    <div id="gallery-container">
        <c:forEach items="${photos}" var="raceList" >
            <div class="race-label">${raceList.key}</div>
            <div id="links-${raceList.key}" class="links">
            <c:forEach items="${raceList.value}" var="photosList" ><a href=<c:url value="/photo_b/${photosList.path}"/>" title="${raceList.key}" data-gallery=""><img src="<c:url value="/photo_s/${photosList.path}"/>" alt=""></a></c:forEach>
            </div>
        </c:forEach>
    </div>
    <div id="blueimp-gallery" class="blueimp-gallery">
        <div class="slides"></div>
        <h3 class="title"></h3>
        <a class="prev">‹</a>
        <a class="next">›</a>
        <a class="close">×</a>
        <a class="play-pause"></a>
        <ol class="indicator"></ol>
    </div>

    <%--Scripts--%>
    <script type="text/javascript" src="<c:url value="/resources/js/blueimp-helper.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/blueimp-gallery.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/blueimp-gallery-fullscreen.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/blueimp-gallery-indicator.js" />"></script>
    <script>

    $('#gallery-container .links').on('click', function (event) {
        event = event || window.event;
        var target = event.target || event.srcElement,
            link = target.src ? target.parentNode : target,
            options = {index: link, event: event},
            links = this.getElementsByTagName('a');
        blueimp.Gallery(links, options);
    });


    </script>
</body>
</html>
<jsp:include page="../template/footer.jsp"/>
