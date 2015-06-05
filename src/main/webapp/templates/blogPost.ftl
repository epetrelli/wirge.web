<#ftl encoding="utf-8">
<!doctype html>
<html class="no-js">
<head>
  <title>${nmTitle}</title>
  <meta charset="utf-8">
  <meta name="description" content="${nmDescription}">
  <meta name="viewport" content="width=device-width">
  <!-- build:css(.tmp) /styles/vendor.css -->
  <!-- bower:css -->
  <link rel="stylesheet" href="/bower_components/leaflet/dist/leaflet.css" />
  <link rel="stylesheet" href="/bower_components/blueimp-gallery/css/blueimp-gallery.css" />
  <link rel="stylesheet" href="/bower_components/blueimp-gallery/css/blueimp-gallery-indicator.css" />
  <link rel="stylesheet" href="/bower_components/blueimp-gallery/css/blueimp-gallery-video.css" />
  <!-- endbower -->
  <!-- endbuild -->

  <!-- build:css(.tmp) /styles/main.css -->
  <link rel="stylesheet" href="/styles/wirge-bootstrap.css">
  <link rel="stylesheet" href="/styles/main.css">
  <!-- endbuild -->
</head>

<body>

<div itemscope itemtype="http://schema.org/Article" class="container">

    <nav class="navbar navbar-default">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><img src="/images/wirge_logo.png" alt="WIRGE Home Page"></a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/#">Home</a></li>
                <li><a href="/chi-siamo.html">Chi siamo</a></li>
                <!--li><a href="/portfolio.html">Portfolio</a></li-->
                <li class="active"><a href="/blog.html">Blog</a></li>
                <li><a href="/contattaci.html">Contattaci</a></li>
            </ul>
        </div>

    </nav>

    <div class="row">
      <div class="col-sm-12">
        <#if storedImage??>
            <img itemprop="image" class="img img-responsive img-rounded pull-left" style="margin:20px 20px 20px 0;" src="/blogImages/${ulLink?remove_ending(".html")}/360/${storedImage.nmFile}" alt="${nmTitle}">
        </#if>
        <h1 itemprop="name">${nmTitle}</h1>
      </div>
    </div>

    <p itemprop="articleSection" class="lead">${nmSubtitle}</p>

    <#if storedImages?size != 0>
      <hr>
      <div id="links">
        <#list storedImages as storedImage>
          <a href="/blogImages/${ulLink?remove_ending(".html")}/${storedImage.nmFile}" title="${nmTitle}" data-gallery>
              <img class="img img-rounded" src="/blogImages/${ulLink?remove_ending(".html")}/80/${storedImage.nmFile}" alt="${nmTitle}">
          </a>
        </#list>
      </div>
      <div id="blueimp-gallery" class="blueimp-gallery blueimp-gallery-controls">
          <!-- The container for the modal slides -->
          <div class="slides"></div>
          <!-- Controls for the borderless lightbox -->
          <h3 class="title"></h3>
          <a class="prev">‹</a>
          <a class="next">›</a>
          <a class="close">×</a>
          <a class="play-pause"></a>
          <ol class="indicator"></ol>
          <!-- The modal dialog, which will be used to wrap the lightbox content -->
          <div class="modal fade">
              <div class="modal-dialog">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" aria-hidden="true">&times;</button>
                          <h4 class="modal-title"></h4>
                      </div>
                      <div class="modal-body next"></div>
                      <div class="modal-footer">
                          <button type="button" class="btn btn-default pull-left prev">
                              <i class="glyphicon glyphicon-chevron-left"></i>
                              Previous
                          </button>
                          <button type="button" class="btn btn-primary next">
                              Next
                              <i class="glyphicon glyphicon-chevron-right"></i>
                          </button>
                      </div>
                  </div>
              </div>
          </div>
      </div>
    </#if>

    <hr>
    <span itemprop="articleBody"><p>${txText.value}</p></span>
    <hr>

    <p class="text-center">
        <a class="btn btn-default" style="margin-top: 20px;" href="/blog.html"><span class="glyphicon glyphicon-chevron-left"></span>&nbsp;Torna al Blog</a>
    </p>

</div>

<div class="container">
    <footer class="footer">
        <p>
            &copy; 2015 WIRGE &middot; PI 01351660996 &middot; <a href="/privacy.html">Privacy</a>
            <a class="text-muted" style="margin:0 0 0 10px" href="https://www.facebook.com/wirge.it"><i class="fa fa-lg fa-facebook-square"></i></a>
            <a class="text-muted" style="margin:0 0 0 10px" href="https://www.linkedin.com/company/9225701"><i class="fa fa-lg fa-linkedin-square"></i></a>
            <a class="text-muted" style="margin:0 0 0 10px" href="https://plus.google.com/+WirgeItPlus/about"><i class="fa fa-lg fa-google-plus-square"></i></a>
            <a class="text-muted" style="margin:0 0 0 10px" href="https://github.com/wirge"><i class="fa fa-lg fa-github-square"></i></a>
        </p>
    </footer>
</div>

<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
    ga('create', 'UA-46615962-1', 'auto');
    ga('send', 'pageview');
</script>

<!-- build:js(.) /scripts/vendor.js -->
<!-- bower:js -->
<script src="/bower_components/es5-shim/es5-shim.js"></script>
<script src="/bower_components/angular/angular.js"></script>
<script src="/bower_components/json3/lib/json3.js"></script>
<script src="/bower_components/angular-animate/angular-animate.js"></script>
<script src="/bower_components/angular-cookies/angular-cookies.js"></script>
<script src="/bower_components/angular-messages/angular-messages.js"></script>
<script src="/bower_components/angular-resource/angular-resource.js"></script>
<script src="/bower_components/angular-route/angular-route.js"></script>
<script src="/bower_components/angular-sanitize/angular-sanitize.js"></script>
<script src="/bower_components/angular-touch/angular-touch.js"></script>
<script src="/bower_components/leaflet/dist/leaflet.js"></script>
<script src="/bower_components/leaflet/dist/leaflet-src.js"></script>
<script src="/bower_components/angularytics/dist/angularytics.min.js"></script>
<script src="/bower_components/blueimp-gallery/js/blueimp-helper.js"></script>
<script src="/bower_components/blueimp-gallery/js/blueimp-gallery.js"></script>
<script src="/bower_components/blueimp-gallery/js/blueimp-gallery-fullscreen.js"></script>
<script src="/bower_components/blueimp-gallery/js/blueimp-gallery-indicator.js"></script>
<script src="/bower_components/blueimp-gallery/js/blueimp-gallery-video.js"></script>
<script src="/bower_components/blueimp-gallery/js/blueimp-gallery-vimeo.js"></script>
<script src="/bower_components/blueimp-gallery/js/blueimp-gallery-youtube.js"></script>
<!-- endbower -->
<!-- endbuild -->

<!-- build:js /scripts/scripts.js -->
<script src="/bower_components/jquery/dist/jquery.js"></script>
<script src="/bower_components/bootstrap/dist/js/bootstrap.js"></script>
<script src="/scripts/WirgeApp.js"></script>
<script src="/scripts/WirgeUrlsService.js"></script>
<script src="/scripts/userMessage/UserMessageService.js"></script>
<script src="/scripts/userMessage/UserMessageController.js"></script>
<!-- endbuild -->

</body>
</html>
