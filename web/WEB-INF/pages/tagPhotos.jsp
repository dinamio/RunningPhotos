<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tensa
  Date: 09.02.2016
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<html>
<head>
    <title>Tag Photos</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/basic.css"/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/resources/css/galleriffic-5.css"/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/resources/css/white.css"/>" type="text/css" />
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.galleriffic.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.opacityrollover.js"/>"></script>
    <style text="css">
        div.navigation a.prev {
            background-image: url(<c:url value="/resources/img/gallery/prevPageArrow.gif"/>);
        }
        div.navigation a.next {
            background-image: url(<c:url value="/resources/img/gallery/nextPageArrow.gif"/>);
        }
        div.loader {
            background-image: url(<c:url value="/resources/img/gallery/loader.gif"/>);
        }
        .added-mark{
            padding : 6px;
        }

        ul {
            list-style-type: none;
        }
    </style>
</head>
<body>
<div class="section section-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Tag photos</h1>
            </div>
        </div>
    </div>
</div>

<!-- Start Advanced Gallery Html Containers -->
<div id="page">
<div id="container">
        <div class="content">

            <div class="slideshow-container">
                <div id="controls" class="controls"></div>
                <div id="loading" class="loader"></div>
                <div id="slideshow" class="slideshow"></div>
            </div>
            <div id="caption" class="caption-container">
                <div style="margin:5px;">
                    <form name="selectPhoto" id="marks-select-form" method="POST" action="<c:url value="/${pageContext.request.userPrincipal.name}/tagPhotos"/>">
                        <div class="btn-group" data-toggle="buttons">
                            <label class="btn btn-primary active">
                                <input type="radio" name="marks" id="option2" value="unmarked" autocomplete="off" checked> Unmarked
                            </label>
                            <label class="btn btn-primary">
                                <input type="radio" name="marks" id="option3" value="marked" autocomplete="off"> Marked
                            </label>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <div id="selected-marks">
                        <input type="text"  id="add-mark-number" placeholder=" Enter number"/>
                        <input id="add-mark-btn" type="button" class="btn" value="Add mark"/>
                        <div id="marks-container" style="width:200px">
                            <h4>Marks in photo:</h4>
                            <ul id="added-marks-ul">

                            </ul>
                        </div>
                    </div>
                    <div id="save-mark" >
                        <input type="button" id="mark-save-btn" class="btn" value="Save mark">
                    </div>
                </div>
                <div class="photo-index"></div>
            </div>
        </div>

        <div class="navigation-container">
            <div id="thumbs" class="navigation">
                <a class="pageLink prev" style="visibility: hidden;" href="#" title="Previous Page"></a>
                </a>
                <ul class="thumbs noscript">
                    <c:forEach items="${photos}" var="photosList" >
                        <li>
                            <a id="${photosList.id}" class="thumb" name="leaf" href="<c:url value="/photo_m/${photosList.path}" />" title="Title #0">
                                <img src="<c:url value="/photo_s/${photosList.path}" />" alt="Title #0" />
                            </a>
                            <div hidden class="caption">${photosList.id}</div>

                        </li>

                    </c:forEach>
                </ul>
                <a class="pageLink next" style="visibility: hidden;" href="#" title="Next Page"></a>
            </div>
        </div>
</div>
</div>
<!-- End Gallery Html Containers -->
<div style="clear: both;"></div>
<script type="text/javascript" src="<c:url value="/resources/js/tagPhoto.js" />"></script>
<script type="text/javascript">

			    if( '${marks}'){
  	$("form .active" ).removeClass('active')
  	$( "input[value=${marks}]" ).prop( "checked", true ).parent().addClass("active");
  	};

</script>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				// We only want these styles applied when javascript is enabled
				$('div.content').css('display', 'block');

				// Initially set opacity on thumbs and add
				// additional styling for hover effect on thumbs
				var onMouseOutOpacity = 0.67;
				$('#thumbs ul.thumbs li, div.navigation a.pageLink').opacityrollover({
					mouseOutOpacity:   onMouseOutOpacity,
					mouseOverOpacity:  1.0,
					fadeSpeed:         'fast',
					exemptionSelector: '.selected'
				});

				// Initialize Advanced Galleriffic Gallery
				var gallery = $('#thumbs').galleriffic({
					delay:                     2500,
					numThumbs:                 10,
					preloadAhead:              10,
					enableTopPager:            false,
					enableBottomPager:         false,
					imageContainerSel:         '#slideshow',
					controlsContainerSel:      '#controls',
					captionContainerSel:       '#caption',
					loadingContainerSel:       '#loading',
					renderSSControls:          false,
					renderNavControls:         true,
					<!-- playLinkText:              'Play Slideshow', -->
					pauseLinkText:             'Pause Slideshow',
					prevLinkText:              '&lsaquo; Previous Photo',
					nextLinkText:              'Next Photo &rsaquo;',
					nextPageLinkText:          'Next &rsaquo;',
					prevPageLinkText:          '&lsaquo; Prev',
					enableHistory:             false,
					autoStart:                 false,
					syncTransitions:           true,
					defaultTransitionDuration: 900,
					onSlideChange:             function(prevIndex, nextIndex) {
						// 'this' refers to the gallery, which is an extension of $('#thumbs')
						this.find('ul.thumbs').children()
							.eq(prevIndex).fadeTo('fast', onMouseOutOpacity).end()
							<%--.eq(nextIndex).fadeTo('fast', 1.0);--%>

						// Update the photo index display
						this.$captionContainer.find('div.photo-index')
							.html('Photo '+ (nextIndex+1) +' of '+ this.data.length);

					},
					onPageTransitionOut:       function(callback) {
						this.fadeTo('fast', 0.0, callback);
					},
					onPageTransitionIn:        function() {
						var prevPageLink = this.find('a.prev').css('visibility', 'hidden');
						var nextPageLink = this.find('a.next').css('visibility', 'hidden');

						// Show appropriate next / prev page links
						if (this.displayedPage > 0)
							prevPageLink.css('visibility', 'visible');

						var lastPage = this.getNumPages() - 1;
						if (this.displayedPage < lastPage)
							nextPageLink.css('visibility', 'visible');

						this.fadeTo('fast', 1.0);
					}
				});

				/**************** Event handlers for custom next / prev page links **********************/

				gallery.find('a.prev').click(function(e) {
					gallery.previousPage();
					e.preventDefault();
				});

				gallery.find('a.next').click(function(e) {
					gallery.nextPage();
					e.preventDefault();
				});

				/****************************************************************************************/



				/****************************************************************************************/
			});
		</script>
</body>
</html>
<jsp:include page="template/footer.jsp"/>