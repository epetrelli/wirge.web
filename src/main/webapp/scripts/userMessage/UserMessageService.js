'use strict';

WirgeWebApp.factory('UserMessageService', ['$resource', 'UrlsService',
  function ($resource, urlsService) {
    return $resource(urlsService.restUrl + '/userMessages', {}, {
      // Create Message:
      'createMessage': { method: 'POST', withCredentials: true}
    });
  }]);


