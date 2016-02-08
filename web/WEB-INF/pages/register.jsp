<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="template/header.jsp"/>
<!-- Page Title -->
<div class="section section-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Register</h1>
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
                    <form:form class="form-horizontal" method="post" commandName="user"
                               action="">
                        <label for ="selectRole" class="class="col-sm-3 control-label"><b>You are:</b></label>
                        <form:select path="role" id="selectRole">
                            <form:option value="RUNNER">Runner</form:option>
                            <form:option value="PHOTOGRAPHER">Photographer</form:option>
                        </form:select>
                        <div class="form-group">
                        <label for="Login" class="col-sm-3 control-label"><b>Login</b></label>
                        <div class="col-sm-4">
                            <form:input path="login" class="form-control" id="login" type="text" placeholder=""/>
                        </div>
                        <div class="col-sm-5">
                            <form:errors path="login" cssClass="alert alert-danger"/>
                        </div>
                    </div>
                        <div class="form-group">
                            <label for="Password" class="col-sm-3 control-label"><b>Password</b></label>
                            <div class="col-sm-4">
                                <form:input path="password" class="form-control" id="password" type="password" placeholder=""/>
                            </div>
                            <div class="col-sm-5">
                                <form:errors path="password" cssClass="alert alert-danger"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword" class="col-sm-3 control-label"><b>Confirm Password</b></label>
                            <div class="col-sm-4">
                                <input class="form-control" name = "confirmPassword" id="confirmPassword" type="password" placeholder=""/>
                            </div>
                            <div class="col-sm-5">
                                <form:errors path="password" cssClass="alert alert-danger"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Mail" class="col-sm-3 control-label"><b>Mail</b></label>
                            <div class="col-sm-4">
                                <form:input path="mail" class="form-control" id="mail" type="text" placeholder=""/>
                            </div>
                            <div class="col-sm-5">
                                <form:errors path="mail" cssClass="alert alert-danger"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label"><b>Name</b></label>
                            <div class="col-sm-4">
                                <form:input path="name" class="form-control" id="name" type="text" placeholder=""/>
                            </div>
                            <div class="col-sm-5">
                                <form:errors path="name" cssClass="alert alert-danger"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Surname" class="col-sm-3 control-label"><b>Surname</b></label>
                            <div class="col-sm-4">
                                <form:input path="surname" class="form-control" id="surname" type="text" placeholder=""/>
                            </div>
                            <div class="col-sm-5">
                                <form:errors path="surname" cssClass="alert alert-danger"/>
                            </div>
                        </div>
                        <div class="form-group">

                            <label for="City" class="col-sm-3 control-label"><b>City</b></label>
                            <div class="col-sm-4">
                                <form:input path="city" class="form-control" id="city" type="text" placeholder=""/>
                            </div>
                            <div class="col-sm-5">
                                <form:errors path="city" cssClass="alert alert-danger"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthday" class="col-sm-3 control-label"><b>Birthday</b></label>
                            <div class="col-sm-4">
                                <form:input path="birthDate" id="birthday"/>
                            </div>
                            <div class="col-sm-5">
                                <form:errors path="birthDate" cssClass="alert alert-danger"/>
                            </div>
                        </div>
                        <c:if test="${not empty msg}">
                            <div class="alert alert-success">${msg}</div>
                        </c:if>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <button type="submit" class="btn pull-right">Send</button>
                            </div>
                    </form:form>

                </div>
            </div>
            </div>
        <div class="col-sm-3"></div>
        </div>
    </div>

</div>
<script>
    $(document).ready(function() {
        $(function() {
            $("#birthday").datepicker();
        });
    });
</script>
<jsp:include page="template/footer.jsp"/>
