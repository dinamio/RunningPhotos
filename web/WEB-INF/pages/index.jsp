<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="template/header.jsp"/>
<!-- Homepage Slider -->
<div class="homepage-slider">
  <div id="sequence">
    <ul class="sequence-canvas">
      <!-- Slide 1 -->
      <li class="bg4">
        <!-- Slide Title -->
        <h2 class="title">Responsive</h2>
        <!-- Slide Text -->
        <h3 class="subtitle">It looks great on desktops, laptops, tablets and smartphones</h3>
        <!-- Slide Image -->
        <img class="slide-img" src="<c:url value="resources/img/homepage-slider/slide1.png"/>" alt="Slide 1" />
      </li>
      <!-- End Slide 1 -->
      <!-- Slide 2 -->
      <li class="bg3">
        <!-- Slide Title -->
        <h2 class="title">Color Schemes</h2>
        <!-- Slide Text -->
        <h3 class="subtitle">Comes with 5 color schemes and it's easy to make your own!</h3>
        <!-- Slide Image -->
        <img class="slide-img" src="<c:url value="resources/img/homepage-slider/slide2.png"/>" alt="Slide 2" />
      </li>
      <!-- End Slide 2 -->
      <!-- Slide 3 -->
      <li class="bg1">
        <!-- Slide Title -->
        <h2 class="title">Feature Rich</h2>
        <!-- Slide Text -->
        <h3 class="subtitle">Huge amount of components and over 30 sample pages!</h3>
        <!-- Slide Image -->
        <img class="slide-img" src="<c:url value="resources/img/homepage-slider/slide3.png"/>" alt="Slide 3" />
      </li>
      <!-- End Slide 3 -->
    </ul>
    <div class="sequence-pagination-wrapper">
      <ul class="sequence-pagination">
        <li>1</li>
        <li>2</li>
        <li>3</li>
      </ul>
    </div>
  </div>
</div>
<!-- End Homepage Slider -->

<!-- Search Form -->
<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-sm-2">
      </div>
      <div class="search-label col-sm-6">
        <strong><spring:message code="homepage.searchFormLabel"/></strong>
      </div>

    </div>
    <div class="row">
      <div class="col-sm-2">
      </div>
      <form id="search-form" action="photos">
        <div class="col-md-4 col-sm-6">
          <input type="text"  name="racename" class="form-control font-stl" id="race-input-search" value="" placeholder="<spring:message code="homepage.enterRace"/>" >
        </div>
        <div class="col-md-3 col-sm-4">
          <input type="text" name="number" class="form-control font-stl" id="number-input-search" value="" placeholder="<spring:message code="homepage.enterNumber"/>">
        </div>
        <div class="col-md-2 col-sm-2">
          <a id="search-btn" href="#"  class="sbtn sbtn-d btn btn-orange"><spring:message code="homepage.search"/></a>
        </div>
      </form>
      <jsp:include page="template/resultsTable.jsp"/>
    </div>
  </div>
</div>

<!-- End Homepage Search Form -->

<!--  Footer -->
<jsp:include page="template/footer.jsp"/>
<!-- End Footer -->
