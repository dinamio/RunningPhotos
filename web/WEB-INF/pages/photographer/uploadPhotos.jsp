<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Tensa
  Date: 09.02.2016
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../template/header.jsp"/>

<html>
<head>
<style text="css">
    label{
        float: left;
        vertical-align: middle;
    }
    </style>
    <title>uploadPhotos</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery.fileupload.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery.fileupload-ui.css"/>">
</head>
<body>
<!-- Page Title -->
<div class="section section-breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1><spring:message code ="uploadPhoto.addPhoto"/></h1>
            </div>
        </div>
    </div>
</div>
<form id="fileupload" action="/uploadPhotos" method="POST" enctype="multipart/form-data">
    <form:form id="fileupload" class="form-horizontal" method="POST" commandName="addphoto"
               action="" enctype="multipart/form-data">
<div class="form-group">
    <div class="container">
        <div class="row ">
            <label class="control-label"><b><spring:message code ="uploadPhoto.selectRace"/></b></label>
            <div class="col-sm-4">
                <select class="form-control" id="select-update-race">
                    <%--<c:set var="raceId" value="${race.id}"/>--%>
                    <%--<option >select race...</option>--%>
                    <c:forEach var="race" items="${races}">
                        <option
                            <%--<c:if test="${race.id == raceId}" > selected</c:if>--%>
                                value="<c:out value="${race.id}"/>" ><c:out value="${race.name}"/></option>
                    </c:forEach>
                </select>
                <input id="race-id" type="hidden" name="raceId" value="">
            </div>
        </div>
    </div>
    </div>
        <div class="container">
            <div class="row">
                <!-- The file upload form used as target for the file upload widget -->
            <!-- Redirect browsers with JavaScript disabled to the origin page -->
            <%--<noscript><input type="hidden" name="redirect" value="https://blueimp.github.io/jQuery-File-Upload/"></noscript>--%>
            <!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->

            <div class="row fileupload-buttonbar">
                <div class="col-lg-7">
                    <!-- The fileinput-button span is used to style the file input field as button -->
                    <span class="btn btn btn-success fileinput-button">
                        <i class="glyphicon glyphicon-plus"></i>
                        <span><spring:message code ="uploadPhoto.add"/></span>
                        <input type="file" name="photographer-photos" multiple>
                    </span>
                    <button type="submit" class="btn  btn-primary start">
                        <i class="glyphicon glyphicon-upload"></i>
                        <span><spring:message code ="uploadPhoto.startUpload"/></span>
                    </button>
                    <button type="reset" class="btn btn-warning cancel">
                        <i class="glyphicon glyphicon-ban-circle"></i>
                        <span><spring:message code ="uploadPhoto.сancelUpload"/></span>
                    </button>
                    <span class="fileupload-process"></span>
                </div>
                <!-- The global progress state -->
                <div class="col-lg-5 fileupload-progress fade">
                    <!-- The global progress bar -->
                    <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
                        <div class="progress-bar progress-bar-success" style="width:0%;"></div>
                    </div>
                    <!-- The extended global progress state -->
                    <div class="progress-extended">&nbsp;</div>
                </div>
            </div>
            <!-- The table listing the files available for upload/download -->
            <table role="presentation" class="table table-striped"><tbody class="files"></tbody></table>
        <%--</form>--%>
</form:form>
        <br>
    </div>
</div>
        <!-- Modal window -->
        <div id="endLoadModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title"><spring:message code ="uploadPhoto.modalHeader"/></h4>
                    </div>
                    <div class="modal-body">
                        <p> <a href="<c:url value="/photographer/myPhotos"/>"><spring:message code ="uploadPhoto.modalClick"/></a>
                            <spring:message code ="uploadPhoto.modalText"/> </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

        <script>
         var id = $('#select-update-race :selected').val();
        $('#race-id').val(id);
        $('#select-update-race').change(function(){
         id = $('#select-update-race :selected').val();
          $('#race-id').val(id);

    })
</script>
        <!-- The template to display files available for upload -->
<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            <strong class="error text-danger"></strong>
        </td>
        <td>
            <p class="size"><spring:message code ="uploadPhoto.processing"/></p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="progress-bar progress-bar-success" style="width:0%;"></div></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <div class="start"></div>
            {% } %}
            {% if (!i) { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span><spring:message code ="uploadPhoto.cancel"/></span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}

</script>

        <!-- The template to display files available for download -->
        <script id="template-download" type="text/x-tmpl">
<%--{% for (var i=0, file; file=o.files[i]; i++) { %}--%>
    <%--&lt;%&ndash;<tr class="template-download fade">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<button class="delete btn" >Delete</button>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<input type="checkbox" name="delete" value="1" class="toggle">&ndash;%&gt;--%>
        <%--&lt;%&ndash;</td>&ndash;%&gt;--%>


<%--{% } %}--%>

 <div class="template-download fade"></div>
{%
if ( $('.template-upload').length == 1){

    $('#endLoadModal').modal('show');
    $('div.template-download').remove();

 };
 %}

</script>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<%--<script src="<c:url value="/resources/js/vendor/jquery.ui.widget.js" />"></script>--%>
<!-- The Templates plugin is included to render the upload/download listings -->
<script src="https://blueimp.github.io/JavaScript-Templates/js/tmpl.min.js"></script>
<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
<script src="https://blueimp.github.io/JavaScript-Load-Image/js/load-image.all.min.js"></script>
<!-- The Canvas to Blob plugin is included for image resizing functionality -->
<script src="https://blueimp.github.io/JavaScript-Canvas-to-Blob/js/canvas-to-blob.min.js"></script>
<!-- Bootstrap JS is not required, but included for the responsive demo navigation -->
<%--<script src="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>--%>
<!-- blueimp Gallery script -->
<script src="https://blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="<c:url value="/resources/js/jquery.iframe-transport.js" />"></script>
<!-- The basic File Upload plugin -->
<script src="<c:url value="/resources/js/jquery.fileupload.js" />"></script>
<!-- The File Upload processing plugin -->
<script src="<c:url value="/resources/js/jquery.fileupload-process.js" />"></script>
<!-- The File Upload image preview & resize plugin -->
<script src="<c:url value="/resources/js/jquery.fileupload-image.js" />"></script>
<!-- The File Upload validation plugin -->
<script src="<c:url value="/resources/js/jquery.fileupload-validate.js" />"></script>
<!-- The File Upload user interface plugin -->
<script src="<c:url value="/resources/js/jquery.fileupload-ui.js" />"></script>
<!-- The main application script -->
<script src="<c:url value="/resources/js/main.js" />"></script>
<!-- The XDomainRequest Transport is included for cross-domain file deletion for IE 8 and IE 9 -->
<!--[if (gte IE 8)&(lt IE 10)]>
<%--<!--<script src="<c:url value="/resources/js/jquery.xdr-transport.js" />"></script>-->--%>
<script src="js/cors/jquery.xdr-transport.js"></script>
<![endif]-->
</body>
</html>
<jsp:include page="../template/footer.jsp"/>
