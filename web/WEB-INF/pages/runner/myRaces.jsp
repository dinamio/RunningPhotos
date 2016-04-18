<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Tensa
  Date: 09.02.2016
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../template/header.jsp"/>
<html>
<head>
    <title>myRaces</title>
</head>
<body>
<c:set var="runner" value="${runner}"/>
<c:set var="resultList" value="${resultList}"/>
<c:set var="distances" value="${distances}"/>
<c:set var="races" value="${races}"/>
<c:set var="speeds" value="${speeds}"/>
<c:set var="allSpeed" value="${allSpeed}"/>
<c:set var="allLength" value="${allLength}"/>
<c:set var="allRaces" value="${allRaces}"/>
<style>
    .leftstr, .rightstr {
        float: left; /* Обтекание справа */
        width: 50%; /* Ширина текстового блока */
    }
    .rightstr {
        text-align: right; /* Выравнивание по правому краю */
    }
</style>
<style>
    .bluebloc{
        background-color:#7da7d9;
        color:black;
        padding:3px;
        border-radius: 5px 5px 0 0;}
</style>
<h2><p class="leftstr"><span class="bluebloc"><c:out value="${runner.surname}"/> <c:out value="${runner.name}"/></span></p>
    <p class="rightstr"><span class="bluebloc"><spring:message code="MyRaces.personalStatistics"/></span></p></h2>
     <div style="clear: left"></div>
<p class="rightstr"><div align="right"><spring:message code="MyRaces.allRaces"/>: <c:out value="${allRaces}"/></div></p>
<p class="rightstr"><div align="right"><spring:message code="MyRaces.allLength"/>: <c:out value="${allLength}"/> <spring:message code="MyRaces.km"/></div></p>
<p class="rightstr"><div align="right"><spring:message code="MyRaces.allSpeed"/>: <c:out value="${allSpeed}"/> <spring:message code="MyRaces.minKm"/></div></p>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <table class="events-list">
                    <tr>
                        <td>
                            <div class="event-date">
                                <div class="event-day"><spring:message code="MyRaces.day"/></div>
                                <div class="event-month"><spring:message code="MyRaces.month"/></div>
                            </div>
                        </td>
                        <td>
                            <spring:message code="MyRaces.raceName"/>
                        </td>
                        <td class="event-venue hidden-xs"><i class="icon-map-marker"></i>
                            <spring:message code="MyRaces.raceLength"/>
                        </td>
                        <td class="event-venue hidden-xs"><i class="icon-map-marker"></i>
                            <spring:message code="MyRaces.runnerNumber"/>
                        </td>
                        <td class="event-venue hidden-xs"><i class="icon-map-marker"></i>
                            <spring:message code="MyRaces.raceTime"/>
                        </td>
                        <td class="event-venue hidden-xs"><i class="icon-map-marker"></i>
                            <spring:message code="MyRaces.speed"/></td>
                        <td class="event-price hidden-xs"></td>
                    </tr>
                    <c:forEach var="result" items="${resultList}" varStatus="status">
                    <tr>
                        <td>
                            <div class="event-date">
                                <div class="event-day"><c:out value="${result.race.raceDate.getDate()}"/></div>
                                <script>
                                    var months = ['<spring:message code="MyRacesMonths.Jan"/>',
                                        '<spring:message code="MyRacesMonths.Feb"/>',
                                        '<spring:message code="MyRacesMonths.Mar"/>',
                                        '<spring:message code="MyRacesMonths.Apr"/>',
                                        '<spring:message code="MyRacesMonths.May"/>',
                                        '<spring:message code="MyRacesMonths.Jun"/>',
                                        '<spring:message code="MyRacesMonths.Jul"/>',
                                        '<spring:message code="MyRacesMonths.Aug"/>',
                                        '<spring:message code="MyRacesMonths.Sep"/>',
                                        '<spring:message code="MyRacesMonths.Oct"/>',
                                        '<spring:message code="MyRacesMonths.Nov"/>',
                                        '<spring:message code="MyRacesMonths.Dec"/>'];
                                    var numMonth = ${result.race.raceDate.getMonth()};
                                    document.write('<div class="event-month">' +  months[Math.floor(numMonth)]+'</div>');
                                </script>
                            </div>
                        </td>
                        <td>
                            <c:out value="${result.race.name}"/>
                        </td>
                        <td>
                            <c:out value="${result.distance.length}"/> <spring:message code="MyRaces.km"/></td>
                        </td>
                        <td>
                            <c:out value="${result.number}"/>
                        </td>
                        <td>
                            <c:out value="${result.time}"/>
                        </td>
                        <td class="event-venue hidden-xs"><i class="icon-map-marker"></i>
                            <c:out value="${speeds.get(status.getIndex())}"/> <spring:message code="MyRaces.minKm"/></td>
                        </td>
                        <td><a href="#" class="btn btn-grey btn-sm event-more"><spring:message code="MyRaces.viewPhoto"/></a></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- Javascripts -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/jquery-1.9.1.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js"></script>
<script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>
<script src="js/jquery.fitvids.js"></script>
<script src="js/jquery.sequence-min.js"></script>
<script src="js/jquery.bxslider.js"></script>
<script src="js/main-menu.js"></script>
<script src="js/template.js"></script>

</body>
</html>
<jsp:include page="../template/footer.jsp"/>
