<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
									<div class="error">${error}</div>
								</c:if>
								<c:if test="${not empty msg}">
									<div class="msg">${msg}</div>
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
									<a href="page-password-reset.html" class="forgot-password">Forgot password?</a>
									<button type="submit" class="btn pull-right">Login</button>
									<div class="clearfix"></div>
								</div>
								<input type="hidden" name="${_csrf.parameterName}"
									   value="${_csrf.token}" />
							</form>
							<div class="not-member">
								<p>Not a member? <a href="page-register.html">Register here</a></p>
							</div>
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>
			</div>
		</div>

<jsp:include page="template/footer.jsp"/>