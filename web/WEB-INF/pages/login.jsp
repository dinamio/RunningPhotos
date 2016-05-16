<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="template/header.jsp"/>

        <!-- Page Title -->
		<div class="section section-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1><spring:message code="login.login"/></h1>
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
					<c:url value="/j_spring_security_check" var="loginUrl" />
					<form name='loginForm' action="${loginUrl}" method='POST'>
						<c:if test="${not empty error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="alert alert-success">${msg}</div>
						</c:if>
						<div class="form-group">
							<label for="login-username"><i class="icon-user"></i> <b><spring:message code="login.username"/></b></label>
							<input class="form-control" id="login-username" name="login" type="text" placeholder="">
						</div>
						<div class="form-group">
							<label for="login-password"><i class="icon-lock"></i> <b><spring:message code="login.password"/></b></label>
							<input class="form-control" id="login-password" name="password" type="password" placeholder="">
						</div>
						<div class="form-group">
							<label class="checkbox">
								<input type="checkbox" name="remember-me"><spring:message code="login.rememberMe"/>
							</label>

							<button type="submit" class="btn pull-right"><spring:message code="login.loginButton"/></button>
							<div class="clearfix"></div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							   value="${_csrf.token}" />
					</form>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</div>
<jsp:include page="template/footer.jsp"/>