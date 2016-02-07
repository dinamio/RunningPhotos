<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="template/header.jsp"/>

        <!-- Page Title -->
		<div class="section section-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1>Login</h1>
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
		        				 	<label for="login-username"><i class="icon-user"></i> <b>Username</b></label>
									<input class="form-control" id="login-username" name="login" type="text" placeholder="">
								</div>
								<div class="form-group">
		        				 	<label for="login-password"><i class="icon-lock"></i> <b>Password</b></label>
									<input class="form-control" id="login-password" name="password" type="password" placeholder="">
								</div>
								<div class="form-group">
									<label class="checkbox">
										<input type="checkbox" name="remember-me"> Remember me
									</label>

                                 <sec:authorize access="hasAnyRole('ROLE_ANONYMOUS')">
									<a href="/forgotPassword" class="active"><spring:message code="homepage.forgotPassword"/></a>
								 </sec:authorize>

									<button type="submit" class="btn pull-right">Login</button>
									<div class="clearfix"></div>
								</div>
								<input type="hidden" name="${_csrf.parameterName}"
									   value="${_csrf.token}" />
							</form>
							<sec:authorize access="hasAnyRole('ROLE_ANONYMOUS')">
								<li class="active">
									<p>Not a member? <a href="/register"><spring:message code="homepage.register"/></a></p>
								</li>
							</sec:authorize>
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>
			</div>
		</div>

<jsp:include page="template/footer.jsp"/>