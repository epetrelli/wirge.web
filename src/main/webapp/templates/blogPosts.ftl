<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <title>Blog</title>
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
            <li><a href="/portfolio.html">Portfolio</a></li>
            <li class="active"><a href="/blog.html">Blog</a></li>
            <li><a href="/contattaci.html">Contattaci</a></li>
        </ul>
    </div>

  </nav>

  <h1>Blog</h1>
  <p class="lead">Pensieri, ragionamenti, dubbi e soluzioni</p>

  <hr>

  <#list blogPosts as blogPost>
    <#if blogPost.published>
      <h2>${blogPost.nmTitle}</h2>
      <h3>${blogPost.nmSubtitle}</h3>
      <p class="small">${blogPost.dhCreated?string('dd/MM/yyyy')}</p>
      <p>
      <#if blogPost.txText.value?length &gt; 250>
        ${blogPost.txText.value[0..249]}... <a href="/blog/${blogPost.ulLink}">Continua <span class="glyphicon glyphicon-chevron-right"></span></a></p>
      <#else>
        ${blogPost.txText.value} <a href="/blog/${blogPost.ulLink}">Continua <span class="glyphicon glyphicon-chevron-right"></span></a></p>
      </#if>
    </#if>
  </#list>


</div>

<div class="container">
  <footer class="footer">
    <p>&copy; 2015 WIRGE &middot; PI 01351660996</p>
  </footer>
</div>

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
<script src="/scripts/WirgeApp.js"></script>
<script src="/scripts/WirgeUrlsService.js"></script>
<script src="/scripts/userMessage/UserMessageService.js"></script>
<script src="/scripts/userMessage/UserMessageController.js"></script>
<!-- endbuild -->

</body>
</html>
