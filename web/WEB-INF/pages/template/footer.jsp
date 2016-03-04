<%--
  Created by IntelliJ IDEA.
  User: eugenegodun
  Date: 1/19/16
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Footer -->
<div class="footer">
  <div class="container">
    <div class="row">
      <div class="col-footer col-md-4 col-xs-6">
        <h3><spring:message code="footer.contacts"/></h3>
        <p class="contact-us-details">
          <b><spring:message code="footer.address"/></b> 123 Fake Street, LN1 2ST, London, United Kingdom<br/>
          <b><spring:message code="footer.phone"/></b> +44 123 654321<br/>
          <b><spring:message code="footer.email"/></b> <a href="mailto:getintoutch@yourcompanydomain.com">getintoutch@yourcompanydomain.com</a>
        </p>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="footer-copyright"><spring:message code="footer.copyright"/></div>
      </div>
    </div>
  </div>
</div>
<%--<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>--%>
<script src="<c:url value="/resources/js/main-menu.js"/>"></script>
</body>
</html>
