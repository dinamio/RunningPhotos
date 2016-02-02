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
    </div>
  </div>
</div>
<!-- End Homepage Search Form -->
<!-- Press Coverage -->
<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-sm-6">
        <div class="in-press press-wired">
          <a href="#"><c:out value="${runner}"/></a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="in-press press-mashable">
          <a href="#">Morbi eleifend congue elit nec sagittis. Praesent aliquam lobortis tellus, nec consequat vitae</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="in-press press-techcrunch">
          <a href="#">Morbi eleifend congue elit nec sagittis. Praesent aliquam lobortis tellus, nec consequat vitae</a>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Press Coverage -->

<!-- Services -->
<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-sm-6">
        <div class="service-wrapper">
          <img src="<c:url value="resources/img/service-icon/diamond.png"/>" alt="Service 1">
          <h3>Aliquam in adipiscing</h3>
          <p>Praesent rhoncus mauris ac sollicitudin vehicula. Nam fringilla turpis turpis, at posuere turpis aliquet sit amet condimentum</p>
          <a href="#" class="btn">Read more</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="service-wrapper">
          <img src="<c:url value="resources/img/service-icon/ruler.png"/>" alt="Service 2">
          <h3>Curabitur mollis</h3>
          <p>Suspendisse eget libero mi. Fusce ligula orci, vulputate nec elit ultrices, ornare faucibus orci. Aenean lectus sapien, vehicula</p>
          <a href="#" class="btn">Read more</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="service-wrapper">
          <img src="<c:url value="resources/img/service-icon/box.png"/>" alt="Service 3">
          <h3>Vivamus mattis</h3>
          <p>Phasellus posuere et nisl ac commodo. Nulla facilisi. Sed tincidunt bibendum cursus. Aenean vulputate aliquam risus rutrum scelerisque</p>
          <a href="#" class="btn">Read more</a>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Services -->

<!-- Call to Action Bar -->
<div class="section section-white">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="calltoaction-wrapper">
          <h3>It's a free multipurpose Bootstrap 3 template!</h3> <a href="http://www.dragdropsite.com" class="btn btn-orange">Download here!</a>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Call to Action Bar -->

<!-- Testimonials -->
<div class="section">
  <div class="container">
    <h2>Testimonials</h2>
    <div class="row">
      <!-- Testimonial -->
      <div class="testimonial col-md-4 col-sm-6">
        <!-- Author Photo -->
        <div class="author-photo">
          <img src="<c:url value="resources/img/user1.jpg"/>" alt="Author 1">
        </div>
        <div class="testimonial-bubble">
          <blockquote>
            <!-- Quote -->
            <p class="quote">
              "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut."
            </p>
            <!-- Author Info -->
            <cite class="author-info">
              - Name Surname,<br>Managing Director at <a href="#">Some Company</a>
            </cite>
          </blockquote>
          <div class="sprite arrow-speech-bubble"></div>
        </div>
      </div>
      <!-- End Testimonial -->
      <div class="testimonial col-md-4 col-sm-6">
        <div class="author-photo">
          <img src="<c:url value="resources/img/user5.jpg"/>" alt="Author 2">
        </div>
        <div class="testimonial-bubble">
          <blockquote>
            <p class="quote">
              "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo."
            </p>
            <cite class="author-info">
              - Name Surname,<br>Managing Director at <a href="#">Some Company</a>
            </cite>
          </blockquote>
          <div class="sprite arrow-speech-bubble"></div>
        </div>
      </div>
      <div class="testimonial col-md-4 col-sm-6">
        <div class="author-photo">
          <img src="<c:url value="resources/img/user2.jpg"/>" alt="Author 3">
        </div>
        <div class="testimonial-bubble">
          <blockquote>
            <p class="quote">
              "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
            </p>
            <cite class="author-info">
              - Name Surname,<br>Managing Director at <a href="#">Some Company</a>
            </cite>
          </blockquote>
          <div class="sprite arrow-speech-bubble"></div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Testimonials -->

<!-- Pricing Table -->
<div class="section">
  <div class="container">
    <h2>Pricing</h2>
    <div class="row">
      <!-- Pricing Plans Wrapper -->
      <div class="pricing-wrapper col-md-12">
        <!-- Pricing Plan -->
        <div class="pricing-plan">
          <!-- Pricing Plan Ribbon -->
          <div class="ribbon-wrapper">
            <div class="price-ribbon ribbon-red">Popular</div>
          </div>
          <h2 class="pricing-plan-title">Starter</h2>
          <p class="pricing-plan-price">FREE</p>
          <!-- Pricing Plan Features -->
          <ul class="pricing-plan-features">
            <li><strong>1</strong> user</li>
            <li><strong>Unlimited</strong> projects</li>
            <li><strong>2GB</strong> storage</li>
          </ul>
          <a href="index.html" class="btn">Order Now</a>
        </div>
        <!-- End Pricing Plan -->
        <div class="pricing-plan">
          <h2 class="pricing-plan-title">Advanced</h2>
          <p class="pricing-plan-price">$49<span>/mo</span></p>
          <ul class="pricing-plan-features">
            <li><strong>10</strong> users</li>
            <li><strong>Unlimited</strong> projects</li>
            <li><strong>20GB</strong> storage</li>
          </ul>
          <a href="index.html" class="btn">Order Now</a>
        </div>
        <!-- Promoted Pricing Plan -->
        <div class="pricing-plan pricing-plan-promote">
          <h2 class="pricing-plan-title">Premium</h2>
          <p class="pricing-plan-price">$99<span>/mo</span></p>
          <ul class="pricing-plan-features">
            <li><strong>Unlimited</strong> users</li>
            <li><strong>Unlimited</strong> projects</li>
            <li><strong>100GB</strong> storage</li>
          </ul>
          <a href="index.html" class="btn">Order Now</a>
        </div>
        <div class="pricing-plan">
          <!-- Pricing Plan Ribbon -->
          <div class="ribbon-wrapper">
            <div class="price-ribbon ribbon-green">New</div>
          </div>
          <h2 class="pricing-plan-title">Mega</h2>
          <p class="pricing-plan-price">$199<span>/mo</span></p>
          <ul class="pricing-plan-features">
            <li><strong>Unlimited</strong> users</li>
            <li><strong>Unlimited</strong> projects</li>
            <li><strong>100GB</strong> storage</li>
          </ul>
          <a href="index.html" class="btn">Order Now</a>
        </div>
      </div>
      <!-- End Pricing Plans Wrapper -->
    </div>
  </div>
</div>
<!-- End Pricing Table -->

<!-- Our Clients -->
<div class="section">
  <div class="container">
    <h2>Our Clients</h2>
    <div class="clients-logo-wrapper text-center row">
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/canon.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/cisco.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/dell.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/ea.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/ebay.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/facebook.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/google.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/hp.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/microsoft.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/mysql.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/sony.png"/>" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="<c:url value="resources/img/logos/yahoo.png"/>" alt="Client Name"></a></div>
    </div>
  </div>
</div>
<jsp:include page="template/footer.jsp"/>
<!-- End Our Clients -->
