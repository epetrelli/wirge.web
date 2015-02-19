'use strict';

WirgeWebApp.factory('UserMessageService', ['$resource', 'UrlsService',
  function ($resource, urlsService) {
    return $resource(urlsService.restUrl + '/usermessages', {}, {
      // all messages:
      'get': { method: 'GET', withCredentials: true},

      // get single message:
      'getMessage': { method: 'GET', url: urlsService.restUrl + '/usermessages/:id', withCredentials: true},

      // Create Message:
      'createMessage': { method: 'POST', url: urlsService.restUrl + '/usermessages/', withCredentials: true},

      // Save Message:
      'saveMessage': { method: 'PUT', url: urlsService.restUrl + '/usermessages/:id', withCredentials: true},

      // Delete Message:
      'deleteMessage': { method: 'DELETE', url: urlsService.restUrl + '/usermessages/:id', withCredentials: true}
    });
  }]);


