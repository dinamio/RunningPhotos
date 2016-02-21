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
    <!-- Tab Content (Full Description) -->
    <div class="tab-content product-detail-info">
      <c:forEach var="distance" items="${distances}" varStatus="distanceCounter">
        <c:choose>
          <c:when test="${distanceCounter.first}">
          <div class="tab-pane active" id="tab${distanceCounter.index+1}">
          </c:when>
          <c:otherwise>
            <div class="tab-pane" id="tab${distanceCounter.index+1}">
          </c:otherwise>
            </c:choose>


            <table class="table table-bordered">
              <thead>
              <tr>
                <th class="info"><spring:message code="runner.number"/></th>
                <th class="info"><spring:message code="runner.name"/></th>
                <th class="info"><spring:message code="runner.surname"/></th>
                <th class="info"><spring:message code="runner.time"/></th>
                <th class="info"><spring:message code="runner.sex"/></th>
              </tr>
              </thead>
              <c:forEach var="result" items="${results}"  varStatus="resultCounter">
                <c:if test="${result.distance.name==distance}">
                  <tbody>
                  <tr class="active">
                    <td>${result.number}</td>
                    <td>${result.runner.name}</td>
                    <td>${result.runner.surname}</td>
                    <td>${result.time.timeToString}</td>
                    <td>${result.runner.sex}"/>
                    </td>
                  </tr>
                  </tbody>
                </c:if>
              </c:forEach>
            </table>
            </div>
      </c:forEach>
          </div>
    </div>
  </div>
</div>
