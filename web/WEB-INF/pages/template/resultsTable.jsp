<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: eugenegodun
  Date: 2/18/16
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="col-sm-12">
  <div class="tabbable">
    <!-- Tabs -->
     <ul class="nav nav-tabs product-details-nav">
      <c:forEach var="distance" items="${distances}" varStatus="loopCounter">
        <c:choose>
          <c:when test="${loopCounter.first}">
            <li class="active">
          </c:when>
          <c:otherwise>
            <li>
          </c:otherwise>
        </c:choose>
        <a href="#tab${loopCounter.index+1}" data-toggle="tab">${distance}</a></li>
      </c:forEach>
     </ul>
    <!-- Search Runner-->

    <!-- Tab Content (Full Description) -->
    <div class="tab-content product-detail-info">
      <div class="form-group pull-right">
        <input class="search form-control" id="livesearch" placeholder="<spring:message code="search.findRunner"/>" type="text" />
      </div>
      <c:forEach var="distance" items="${distances}" varStatus="distanceCounter">
        <c:choose>
          <c:when test="${distanceCounter.first}">
          <div class="tab-pane active" id="tab${distanceCounter.index+1}">
          </c:when>
          <c:otherwise>
            <div class="tab-pane" id="tab${distanceCounter.index+1}">
          </c:otherwise>
            </c:choose>

            <c:set var="tableId" value="table${distanceCounter.index+1}"/>
            <table id="${tableId}" class="table table-bordered table-striped">
              <thead>
              <tr>
                <th class="info"><spring:message code="runner.number"/></th>
                <th class="info"><spring:message code="runner.name"/></th>
                <th class="info"><spring:message code="runner.surname"/></th>
                <th class="info"><spring:message code="runner.time"/></th>
                <th class="info"><spring:message code="runner.sex"/></th>
              </tr>
              </thead>
              <c:forEach var="result" items="${results}">
                <c:if test="${result.distance.name==distance}">
                  <tbody>
                  <tr class="active">
                    <td>${result.number}</td>
                    <td>${result.runner.name}</td>
                    <td>${result.runner.surname}</td>
                    <td>${result.time.timeToString}</td>
                    <td><spring:message code ="sex.${result.runner.sex}"/></td>
                  </tr>
                  </tbody>
              </c:if>
              </c:forEach>
            </table>
            </div>
            <script>
              $(document).ready(function() {
                $("#${tableId}").simplePagination();
                $('input#livesearch').liveSearch({
                  table : 'table' // table selector
                });
              });
            </script>
      </c:forEach>
          </div>
    </div>
  </div>
</div>
<script src="<c:url value="/resources/js/jquery.simplePagination.js"/>"></script>
<script src="<c:url value="/resources/js/livesearch.js"/>"></script>
<script src="<c:url value="/resources/js/livesearch.min.js"/>"></script>

