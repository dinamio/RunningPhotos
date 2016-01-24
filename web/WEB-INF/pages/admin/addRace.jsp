<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../template/header.jsp"/>
<!-- Page Title -->
<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <h1>Add race</h1>
      </div>
    </div>
  </div>
</div>

<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-sm-9">
        <!-- Add race Form -->
        <div class="contact-form-wrapper">
          <form:form class="form-horizontal" method="post" commandName="race"
                     action="">
            <div class="form-group">
                <c:if test="${not empty msg}">
                    <div class="alert alert-success">${msg}</div>
                </c:if>
                <label for="Name" class="col-sm-3 control-label"><b>Race name</b></label>
              <div class="col-sm-4">
                <form:input path="name" class="form-control" id="Name" type="text" placeholder=""/>
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
              <div class="col-sm-4">
                <form:input path="raceDate" id="raceDate"/>
              </div>
              <div class="col-sm-5">
                <form:errors path="raceDate" cssClass="alert alert-danger"/>
              </div>
            </div>
            <div class="form-group">
              <div class="col-sm-12">
                <button type="submit" class="btn pull-right">Send</button>
              </div>
            </div>
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
<jsp:include page="../template/footer.jsp"/>