<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Running photos</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">

  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/resources/css/icomoon-social.css"/>">
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="<c:url value="/resources/css/leaflet.css"/>" />
  <!--[if lte IE 8]>
  <link rel="stylesheet" href="<c:url value="/resources/css/leaflet.ie.css"/>" />
  <![endif]-->
  <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">

  <script src="<c:url value="/resources/js/modernizr-2.6.2-respond-1.1.0.min.js"/>"></script>
  <!-- Javascripts -->
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script>window.jQuery || document.write('<script src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"><\/script>')</script>
  <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  <script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>
  <script src="<c:url value="/resources/js/jquery.fitvids.js"/>"></script>
  <script src="<c:url value="/resources/js/jquery.sequence-min.js"/>"></script>
  <script src="<c:url value="/resources/js/jquery.bxslider.js"/>"></script>
  <script src="<c:url value="/resources/js/template.js"/>"></script>
  <script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script src="<c:url value="/resources/js/template.js"/>"></script>

  <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

</head>
<body>
<!--[if lt IE 7]>
<p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
<![endif]-->


<!-- Navigation & Logo-->
<div class="mainmenu-wrapper">
  <div class="container">
    <div class="menuextras">
      <div class="extras">
        <ul>
        <sec:authorize access="hasAnyRole('ROLE_ANONYMOUS','Runner')">
          <li class="active">
              <i class="glyphicon glyphicon-shopping-cart icon-white"></i>
                    <a href="/basket"><spring:message code="homepage.basket"/></a>
                </li>
            </sec:authorize>
          <li>
              <spring:message var="lang" code="language"/>
              <c:choose>
                  <c:when test="${lang == 'en'}">
                      <div class="dropdown choose-country">
                          <a class="#" data-toggle="dropdown" href="?lang=en"><img src="<c:url value="/resources/img/flags/gb.png"/>" alt="Great Britain"> EN</a>
                          <ul class="dropdown-menu" role="menu">
                              <li role="menuitem"><a href="?lang=ru"><img src="<c:url value="/resources/img/flags/ru.png"/>" alt="Russia"> RU</a></li>
                          </ul>
                      </div>
                  </c:when>
                  <c:otherwise>
                      <div class="dropdown choose-country">
                          <a class="#" data-toggle="dropdown" href="?lang=ru"><img src="<c:url value="/resources/img/flags/ru.png"/>" alt="Great Britain"> RU</a>
                          <ul class="dropdown-menu" role="menu">
                              <li role="menuitem"><a href="?lang=en"><img src="<c:url value="/resources/img/flags/gb.png"/>" alt="English"> EN</a></li>
                          </ul>
                      </div>
                  </c:otherwise>
              </c:choose>
          </li>
          <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
              <spring:message code="homepage.welcome"/>, <strong>${pageContext.request.userPrincipal.name}</strong>
              <li><a href="<c:url value="/logout" />" ><spring:message code="homepage.logout"/></a></li>
            </c:when>
            <c:otherwise>
              <li><a href="<c:url value="/login"/>"><spring:message code="homepage.login"/></a></li>
            </c:otherwise>
          </c:choose>

                </ul>
            </div>
        </div>
      <nav id="mainmenu" class="mainmenu">
          <ul>

                <li class="logo-wrapper"><a href="<c:url value="/"/>"><img src="<c:url value="/resources/img/mPurpose-logo.png"/>" alt="Multipurpose Twitter Bootstrap Template"></a></li>
                <li class="active">
                    <a href="<c:url value="/"/>"><spring:message code="homepage.home"/></a>
                </li>
                <sec:authorize access="hasAnyRole('ROLE_ANONYMOUS','Photographer','Runner')">
                <li class="active">
                    <a href="/buyPhotos"><spring:message code="homepage.buyPhotos"/></a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ANONYMOUS','Runner')">
                <li class="active">
                    <a href="<c:url value="/results"/>"><spring:message code="homepage.results"/></a>
                </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('Admin','Operator')">
                    <li class="active">
                        <a href="credits.html"><spring:message code="homepage.tagPhotos"/></a>
                    </li>
                  </sec:authorize>
                 <sec:authorize access="hasRole('Admin')">
                <li class= "has-submenu active">
                    <a href="#"><spring:message code="homepage.add"/></a>
                    <div class="mainmenu-submenu">
                        <div class="mainmenu-submenu-inner">
                            <div>
                                <ul>
                                    <li><a href="<c:url value="/admin/addRace"/>"><Strong>Races</Strong></a></li>
                                    <li><a href="index.html"><Strong>Results</Strong></a></li>
                                </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="has-submenu active">
                        <a href="#"><spring:message code="homepage.change"/></a>
                        <div class="mainmenu-submenu">
                            <div class="mainmenu-submenu-inner">
                                <div>
                                    <ul>
                                        <li><a href="index.html"><Strong>Races</Strong></a></li>
                                        <li><a href="index.html"><Strong>Results</Strong></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('Runner')">
                    <li class="active">
                        <a href="credits.html">My Races</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('Photographer')">
                <li class="active">
                    <a href="credits.html">Upload Photos</a>
                </li>
                <li class="active">
                    <a href="credits.html">My Photos</a>
                </li>
                </sec:authorize>
            </ul>
            </nav>
        </div>
    </div>
</body>
</html>
        </nav>
    </div>
</div>
