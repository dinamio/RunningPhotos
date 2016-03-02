<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<!--Page Title-->
<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1><spring:message code="userInfo.title"/></h1>
      </div>
    </div>
  </div>
</div>
<!--Update userInfo-->
<div class="section">
  <div class="container">
    <div class="row">
      <div class="basic-login">
        <jsp:include page="template/registerForm.jsp"/>
      </div>
    </div>
    <div class="col-sm-3"></div>
  </div>
</div>
</div>

<jsp:include page="template/footer.jsp"/>
