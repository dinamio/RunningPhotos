<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form class="form-horizontal" method="post" commandName="user"
           action="">
  <c:if test="${not empty msg}">
    <div class="alert alert-success">${msg}</div>
  </c:if>
  <label for ="selectRole" class="class="col-sm-3 control-label"><b><spring:message code="register.you"/></b></label>
  <form:select path="role" id="selectRole">
    <form:option value="RUNNER"><spring:message code="register.runner"/></form:option>
    <form:option value="PHOTOGRAPHER"><spring:message code="register.photographer"/></form:option>
  </form:select>
  <c:choose>
    <c:when test="${not empty user.id}">
      <div class="form-group">
        <div class="col-sm-4">
          <form:input path="login" class="form-control" id="login" type="hidden" placeholder=""/>
        </div>
        <div class="col-sm-5">
          <form:errors path="login" cssClass="alert alert-danger"/>
        </div>
      </div>
    </c:when>
    <c:otherwise>
      <div class="form-group">
        <label for="Login" class="col-sm-3 control-label"><b><spring:message code="register.login"/></b></label>
        <div class="col-sm-4">
          <form:input path="login" class="form-control" id="login" type="text" placeholder=""/>
        </div>
        <div class="col-sm-5">
          <form:errors path="login" cssClass="alert alert-danger"/>
        </div>
      </div>
    </c:otherwise>
  </c:choose>
  <div class="form-group">
    <label for="Password" class="col-sm-3 control-label"><b><spring:message code="register.password"/></b></label>
    <div class="col-sm-4">
      <form:input path="password" class="form-control" id="password" type="password" placeholder=""/>
    </div>
    <div class="col-sm-5">
      <form:errors path="password" cssClass="alert alert-danger"/>
    </div>
  </div>
  <c:choose>
    <c:when test="${not empty user.id}">
      <div class="form-group">
        <label for="confirmPassword" class="col-sm-3 control-label"><b><spring:message code="register.currentPassword"/></b></label>
        <div class="col-sm-4">
          <input class="form-control" name = "confirmPassword" id="confirmPassword" type="password" placeholder=""/>
        </div>
        <div class="col-sm-5">
          <form:errors path="password" cssClass="alert alert-danger"/>
        </div>
      </div>
    </c:when>
    <c:otherwise>
      <div class="form-group">
        <label for="confirmPassword" class="col-sm-3 control-label"><b><spring:message code="register.ConfirmPass"/></b></label>
        <div class="col-sm-4">
          <input class="form-control" name = "confirmPassword" id="confirmPassword" type="password" placeholder=""/>
        </div>
        <div class="col-sm-5">
          <form:errors path="password" cssClass="alert alert-danger"/>
        </div>
      </div>
      <div class="form-group">
        <label for="Mail" class="col-sm-3 control-label"><b><spring:message code="register.mail"/></b></label>
        <div class="col-sm-4">
          <form:input path="mail" class="form-control" id="mail" type="text" placeholder=""/>
        </div>
        <div class="col-sm-5">
          <form:errors path="mail" cssClass="alert alert-danger"/>
        </div>
      </div>
    </c:otherwise>
  </c:choose>

  <div class="form-group">
    <label for="name" class="col-sm-3 control-label"><b><spring:message code="register.name"/></b></label>
    <div class="col-sm-4">
      <form:input path="name" class="form-control" id="name" type="text" placeholder=""/>
    </div>
    <div class="col-sm-5">
      <form:errors path="name" cssClass="alert alert-danger"/>
    </div>
  </div>
  <div class="form-group">
    <label for="Surname" class="col-sm-3 control-label"><b><spring:message code="register.surname"/></b></label>
    <div class="col-sm-4">
      <form:input path="surname" class="form-control" id="surname" type="text" placeholder=""/>
    </div>
    <div class="col-sm-5">
      <form:errors path="surname" cssClass="alert alert-danger"/>
    </div>
  </div>
  <div class="form-group">

    <label for="City" class="col-sm-3 control-label"><b><spring:message code="register.city"/></b></label>
    <div class="col-sm-4">
      <form:input path="city" class="form-control" id="city" type="text" placeholder=""/>
    </div>
    <div class="col-sm-5">
      <form:errors path="city" cssClass="alert alert-danger"/>
    </div>
  </div>
  <div class="form-group">
    <label for="birthday" class="col-sm-3 control-label"><b><spring:message code="register.birthday"/></b></label>
    <div class="col-sm-4">
      <form:input id="birthday" type="text" name="birthday" value="" class="dropdate" path="birthDate"/>
    </div>
    <div class="col-sm-5">
      <form:errors path="birthDate" cssClass="alert alert-danger"/>
    </div>
  </div>
  <c:if test="${not empty user.id}">
    <div class="form-group">
      <div class="col-sm-4">
        <form:input path="id" class="form-control" id="id" type="hidden" placeholder=""/>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-5">
        <form:input path="mail" class="form-control" id="mail" type="hidden" placeholder=""/>
      </div>
    </div>
  </c:if>
  <div class="form-group">
    <div class="col-sm-12">
      <button type="submit" class="btn pull-right"><spring:message code="register.sendButton"/></button>
    </div>
</form:form>