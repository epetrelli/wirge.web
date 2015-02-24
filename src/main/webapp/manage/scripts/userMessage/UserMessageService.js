'use strict';

WirgeManageApp.factory('UserMessageService', ['$resource', 'UrlsService',
  function ($resource, urlsService) {
    return $resource(urlsService.restUrl + '/usermessages', {}, {

      // all messages:
      'getMessages': { method: 'GET', withCredentials: true, isArray:true},

      // get single message:
      'getMessage': { method: 'GET', url: urlsService.restUrl + '/usermessages/:id', withCredentials: true},

      // Create Message:
      'createMessage': { method: 'POST', withCredentials: true},

      // Save Message:
      'saveMessage': { method: 'PUT', withCredentials: true},

      // Delete Message:
      'deleteMessage': { method: 'DELETE', url: urlsService.restUrl + '/usermessages/:id', withCredentials: true}
    });
  }]);


