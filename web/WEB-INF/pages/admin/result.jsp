<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="../template/header.jsp"/>
<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <h1><spring:message code="admin.result.add"/> </h1>
      </div>
    </div>
  </div>
</div>
<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-sm-10">
        <fo class="form-group">
          <c:url var="addResultPath" value="/admin/add/result/addJson"/>
          <form:form method="post" action="${addResultPath}" enctype="multipart/form-data" commandName="race">
            <label for="id" class="col-sm-3 control-label"><b><spring:message code="admin.result.add.enterrace"/></b></label>
            <div class="col-sm-3">
              <form:select items="${racesList}"  path="id" itemValue="id" itemLabel="name"/>
            </div>
            <div class="col-sm-3">
              <input name="race-results" id="race-results" type="file">
            </div>
            <div class="col-sm-3">
              <button type="submit" class="btn pull-right"><spring:message code="admin.result.add.results.button"/> </button>
            </div>
              </form:form>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../template/footer.jsp"/>