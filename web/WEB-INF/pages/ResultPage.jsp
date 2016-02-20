<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="template/header.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1>LATEST RESULTS</h1>
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
            <a href="<c:url value="/results/resultspageinfo/${raceList.id}"/><img src="<c:url value="/image/${raceList.photo}"/>"></a>
            <div class="post-title">
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
<!-- End Posts List -->
