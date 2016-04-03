<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="template/header.jsp"/>

<!-- Page Title -->
<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1><spring:message code="forgotPassword.title"/></h1>
      </div>
    </div>
  </div>
</div>

<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-sm-3"></div>
      <div class="col-sm-6">
        <div class="basic-login">
<form:form method="post" commandName="user"
           action="">
    <c:if test="${not empty successfulMessage}">
        <div class="alert alert-success">${successfulMessage}</div>
    </c:if>
    <c:if test="${not empty notFoundMessage}">
        <div class="alert alert-danger">${notFoundMessage}</div>
    </c:if>
            <div class="form-group">
              <label for="forgotPassword-email"><i class="icon-user"></i> <b><spring:message code="forgotPassword.email"/></b></label>
              <form:input path="mail" class="form-control" id="forgotPassword-email" name="forgotPassword-email" type="text" placeholder=""/>
            </div>

            <div class="form-group">
                <button type="submit" class="btn pull-right"><spring:message code="forgotPassword.send"/></button>
              <div class="clearfix"></div>
            </div>
          </form:form>
        </div>
      </div>
      <div class="col-sm-3"></div>
    </div>
  </div>
</div>

<jsp:include page="template/footer.jsp"/>