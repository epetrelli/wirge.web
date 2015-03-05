<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <title>${nmTitle}</title>
  <meta name="description" content="${nmDescription}">
  <meta name="viewport" content="width=device-width">
  <!-- build:css(.tmp) styles/vendor.css -->
  <!-- bower:css -->
  <link rel="stylesheet" href="bower_components/leaflet/dist/leaflet.css" />
  <!-- endbower -->
  <!-- endbuild -->

  <!-- build:css(.tmp) styles/main.css -->
  <link rel="stylesheet" href="../styles/wirge-bootstrap.css">
  <link rel="stylesheet" href="../styles/main.css">
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
        <li><a href="#">Home</a></li>
        <li><a href="/chi-siamo.html">Chi siamo</a></li>
        <li><a href="/portfolio.html">Portfolio</a></li>
        <li><a href="/contattaci.html">Contattaci</a></li>
      </ul>
    </div>

  </nav>

  <h1>${nmTitle}</h1>
  <p class="lead">${nmSubtitle}</p>

  <hr>

  <p>${txText}</p>

</div>

<div class="container">
  <footer class="footer">
    <p>&copy; 2015 WIRGE &middot; PI 01351660996</p>
  </footer>
</div>

<!-- build:js(.) scripts/vendor.js -->
<!-- bower:js -->
<script src="bower_components/es5-shim/es5-shim.js"></script>
<script src="bower_components/angular/angular.js"></script>
<script src="bower_components/json3/lib/json3.js"></script>
<script src="bower_components/angular-animate/angular-animate.js"></script>
<script src="bower_components/angular-cookies/angular-cookies.js"></script>
<script src="bower_components/angular-messages/angular-messages.js"></script>
<script src="bower_components/angular-resource/angular-resource.js"></script>
<script src="bower_components/angular-route/angular-route.js"></script>
<script src="bower_components/angular-sanitize/angular-sanitize.js"></script>
<script src="bower_components/angular-touch/angular-touch.js"></script>
<script src="bower_components/leaflet/dist/leaflet.js"></script>
<script src="bower_components/leaflet/dist/leaflet-src.js"></script>
<!-- endbower -->
<!-- endbuild -->

<!-- build:js scripts/scripts.js -->
<script src="../scripts/WirgeApp.js"></script>
<script src="../scripts/WirgeUrlsService.js"></script>
<script src="../scripts/userMessage/UserMessageService.js"></script>
<script src="../scripts/userMessage/UserMessageController.js"></script>
<!-- endbuild -->

</body>
</html>
