'use strict';

var WirgeApp = angular.module('WirgeApp', ['ngAnimate','ngCookies','ngMessages','ngResource','ngRoute','ngSanitize','ngTouch']);

if(document.getElementById('links')!=null) {
  document.getElementById('links').onclick = function (event) {
    event = event || window.event;
    var target = event.target || event.srcElement;
    var link = target.src ? target.parentNode : target;
    var options = {index: link, event: event};
    var links = this.getElementsByTagName('a');
    blueimp.Gallery(links, options);
  };
}
