'use strict';

WirgeManageApp.controller('UserMessageController', ['$scope', '$route', 'UserMessageService', 'resolvedMessage',

  function ($scope, $route, userMessageService, resolvedMessage) {

    $scope.userMessage = resolvedMessage;

    resolvedMessage.$promise.then(function (resolvedMessage) {
      console.log("Message loaded: id=" + resolvedMessage.id);
    });


  }]);
