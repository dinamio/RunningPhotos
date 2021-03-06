<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="template/header.jsp"/>
<!-- Page Title -->
<div class="section section-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1><spring:message code="register.register"/></h1>
            </div>
        </div>
    </div>
</div>

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
<script src="<c:url value="/resources/js/date.format.js"/>"></script>
<script>
    $(document).ready(function() {
        $(function() {
            $("#birthday").datepicker({
                changeMonth:true,
                changeYear:true,
                yearRange: "-100:+0"
            });
        });
    });
</script>
</div>
<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
<script src="<c:url value="/resources/js/searchform.js" />"></script>
<script>
    $(function() {
        $( document ).tooltip();
    });
</script>
<jsp:include page="template/footer.jsp"/>
