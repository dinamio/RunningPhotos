<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../template/header.jsp"/>
<!-- Page Title -->
<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <h1><spring:message code="${pLabel}"/></h1>
      </div>
    </div>
  </div>
</div>

<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-sm-10">
        <div class="contact-form-wrapper">
          <form:form class="form-horizontal" method="post" commandName="race"
                     action="" enctype="multipart/form-data">
            <div class="form-group">
              <c:if test="${not empty msg}">
                <div class="alert alert-success">${msg}</div>
              </c:if>
              <!-- Update race select -->
              <c:if test="${not empty races}">
                <label for="Name" class="col-sm-3 control-label"><b>Select updated race</b></label>
                  <div class="col-sm-4">
                    <select class="form-control" id="select-update-race">
                      <c:set var="raceId" value="${race.id}"/>
                      <option >select race...</option>
                      <c:forEach var="race" items="${races}">
                        <option
                               <c:if test="${race.id == raceId}" > selected</c:if>
                                value="<c:out value="${race.id}"/>"><c:out value="${race.name}"/></option>
                      </c:forEach>
                    </select>
                  </div>
              </c:if>
            </div>
            <!-- End update race select -->
            <!-- Add race Form -->
            <div class="form-group">
                <label for="Name" class="col-sm-3 control-label"><b>Race name</b></label>
              <div class="col-sm-4">
                <form:input path="name" class="form-control" id="name" type="text" placeholder=""/>
              </div>
              <div class="col-sm-5">
                <form:errors path="name" cssClass="alert alert-danger"/>
              </div>
            </div>
            <div class="form-group">
              <label for="city" class="col-sm-3 control-label"><b>City</b></label>
              <div class="col-sm-4">
                <form:input path="city" class="form-control" id="city" type="text" placeholder=""/>
              </div>
              <div class="col-sm-5">
                <form:errors path="city" cssClass="alert alert-danger"/>
              </div>
            </div>
            <div class="form-group">
              <label for="raceDate" class="col-sm-3 control-label"><b>Date</b></label>
              <div class="col-sm-2">
                <form:input path="raceDate" class="form-control" id="raceDate"/>
              </div>
              <div class="col-sm-5">
                <form:errors path="raceDate" cssClass="alert alert-danger"/>
              </div>
            </div>
            <div class="form-group">
              <label for="race-photo" class="col-sm-3 control-label"><b>Race photo</b></label>
              <div class="col-sm-4">
                <input name="race-photo" id="race-photo" type="file">
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-12">
                <button type="submit" class="btn pull-right">Send</button>
              </div>
            </div>
            <%--<!--input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/-->--%>
            <form:input path="id" type="hidden" value=""/>
            <form:input path="photo" type="hidden" value=""/>
          </form:form>
        </div>
        <!-- End Contact Info -->
      </div>
    </div>
  </div>
</div>
<script>
  $(document).ready(function() {
    $(function() {
      $("#raceDate").datepicker();
    });
  });
</script>
<script src="<c:url value="/resources/js/race.update.js"/>"></script>
<jsp:include page="../template/footer.jsp"/>