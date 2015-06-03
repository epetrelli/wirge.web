<#ftl encoding="utf-8">
<!doctype html>
<html class="no-js">
<head>
    <title>Blog</title>
    <meta charset="utf-8">
    <meta name="description" content="Raccolta di pensieri, proposte, dubbi e qualche soluzione">
    <meta name="viewport" content="width=device-width">
    <!-- build:css(.tmp) /styles/vendor.css -->
    <!-- bower:css -->
    <link rel="stylesheet" href="/bower_components/leaflet/dist/leaflet.css" />
    <!-- endbower -->
    <!-- endbuild -->

    <!-- build:css(.tmp) /styles/main.css -->
    <link rel="stylesheet" href="/styles/wirge-bootstrap.css">
    <link rel="stylesheet" href="/styles/main.css">
    <!-- endbuild -->
</head>

<body>

<div class="container">

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

    <h1>Blog</h1>

    <p class="lead">Pensieri, ragionamenti, dubbi...</p>

    <hr>

    <#list blogPosts as blogPost>
      <#if blogPost.published>
        <div class="row">
            <div class="col-sm-12">
              <#if blogPost.storedImages?size != 0>
                <a href="/blog/${blogPost.ulLink}">
                  <img class="img img-responsive img-rounded pull-left" style="margin-right:10px;" src="/blogImages/${blogPost.ulLink?remove_ending(".html")}/240/${blogPost.storedImages[0].nmFile}" alt="${blogPost.nmTitle}">
                </a>
              </#if>

              <h2>${blogPost.nmTitle}</h2>

              <h3>${blogPost.nmSubtitle}</h3>

              <p class="small">${blogPost.dhCreated?string('dd/MM/yyyy')}</p>
              <p>
              <#if blogPost.txText.value?length &gt; 250>
                ${blogPost.txText.value[0..249]}... <a href="/blog/${blogPost.ulLink}">Continua <span class="glyphicon glyphicon-chevron-right"></span></a></p>
              <#else>
                ${blogPost.txText.value} <a href="/blog/${blogPost.ulLink}">Continua <span class="glyphicon glyphicon-chevron-right"></span></a>
                </p>
              </#if>
              <br class="clear:both;">
            </div>
        </div>
        <hr>
      </#if>
    </#list>


</div>

<div class="container">
    <footer class="footer">
        <p>
            &copy; 2015 WIRGE &middot; PI 01351660996
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
