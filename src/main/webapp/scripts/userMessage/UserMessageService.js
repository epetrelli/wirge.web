'use strict';

WirgeWebApp.factory('UserMessageService', ['$resource', 'UrlsService',
  function ($resource, urlsService) {
    return $resource(urlsService.restUrl + '/usermessages', {}, {
      // Create Message:
      'createMessage': { method: 'POST', url: urlsService.restUrl + '/usermessages/', withCredentials: true},
    });
  }]);


