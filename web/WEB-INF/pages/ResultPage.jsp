<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="template/header.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style type="text/css">
  .post-title{
    width: 350px;
    height: 200px;
  }
  .post-summary {
    margin-top: 35px;
    margin-bottom: 0px;
  }
</style>

<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1><spring:message code ="results.header"/></h1>
      </div>
    </div>
  </div>
</div>

<div class="section blog-posts-wrapper">
  <div class="container">
    <div class="row">
      <c:forEach items="${races}" var="raceList" >
        <!-- Post -->
        <div class="col-md-4 col-sm-6">
          <div class="blog-post">
            <!-- Post Info -->
            <div class="post-info">
              <div class="post-date">
                <div class="date">
                  <calendar:formatDate  value="${raceList.raceDate}"
                                        pattern="dd-MM-yyyy"/>
                </div>
              </div>
              <div class="post-comments-count">
                <a href="<c:url value="/results/resultspageinfo/${raceList.id}"/>"></a>
              </div>
            </div>
            <!-- End Post Info -->
            <!-- Post Image -->
            <div class="post-title">
            <a href="<c:url value="/results/resultspageinfo/${raceList.id}"/>"><img src="<c:url value="/image/${raceList.photo}" />"></a>
              <h3> <a href="<c:url value="/results/resultspageinfo/${raceList.id}"/>">
                  ${raceList.name},${raceList.city}
              </a></h3>
            </div>
            <div class="post-summary">
              <p>Information</p>
            </div>
            <!-- End Post Title & Summary -->
          </div>
        </div>
      </c:forEach>
      <!-- End Post -->
    </div>
  </div>
</div>
<script>
  <%--jQuery(function ($) {--%>
    function fix_size() {
        var images = $('.post-title img');
        images.each(setsize);
        function setsize() {
            var img = $(this),
                img_dom = img.get(0),
                container = img.parents('.post-title');
            if (img_dom.complete) {
                resize();
            } else img.one('load', resize);

            function resize() {
                if ((container.width() / container.height()) < (img_dom.width / img_dom.height)) {
                    img.width('100%');
                    img.height('auto');
                    img.css('margin-top',(container.height()-img_dom.height)/2);
                    return;
                }
                img.height('100%');
                img.width('auto');
                img.css('margin-left',(container.width()-img_dom.width)/2);
            }
        }
    }
    $(window).on('resize', fix_size);
    fix_size();
<%--});--%>

</script>
<!-- End Posts List -->
